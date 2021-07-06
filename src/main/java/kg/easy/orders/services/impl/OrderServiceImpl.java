package kg.easy.orders.services.impl;

import kg.easy.orders.dao.OrderRepo;
import kg.easy.orders.dto.OrderDto;
import kg.easy.orders.dto.SubscriberDto;
import kg.easy.orders.enums.OrderStatus;
import kg.easy.orders.mappers.OrderMapper;
import kg.easy.orders.mappers.SubscriberMapper;
import kg.easy.orders.models.Order;
import kg.easy.orders.models.responses.Response;
import kg.easy.orders.services.OrderCloseDto;
import kg.easy.orders.services.OrderService;
import kg.easy.orders.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderService orderService;
    @Override
    public Response saveOrder(OrderDto orderDto) {

        Response response = Response.getResponse();

        SubscriberDto subscriberDto = subscriberService.findSubscriberByPhoneNumber(orderDto.getSubscriber().getPhoneNumber());

        if (subscriberDto == null){

            subscriberDto = new SubscriberDto();
            subscriberDto.setPhoneNumber(orderDto.getSubscriber().getPhoneNumber());
            subscriberDto = subscriberService.saveSubscriber(subscriberDto);

        }else{
            Order currOrder = orderRepo.findTopBySubscriberOrderByIdDesc(SubscriberMapper.INSTANCE.toSubscriber(subscriberDto));
            OrderStatus orderStatus = orderService.findActualOrderStatus(currOrder);
            if (orderStatus.equals(OrderStatus.IN_PROCESS)){
                response.setMessage("Ваш запрос обрабатывается");
                return response;
            }else if (orderStatus.equals(OrderStatus.APPROVED)){
                response.setMessage("У Вас услуга подключена");
                return response;
            }
            orderService.close(currOrder);
        }

        Order order = new Order();
        order.setStartDate(new Date());
        order.setSchoolAddress(orderDto.getSchoolAddress());
        order.setSubscriber(SubscriberMapper.INSTANCE.toSubscriber(subscriberDto));

        order = orderRepo.save(order);

        OrderDto orderDto = orderService.changeOrderStatus(OrderMapper.INSTANCE.toOrderDto(order), OrderStatus.NEW, null);

        response.setObject(orderDto);

        return response;
    }

    @Override
    public Response findOrdersByStatus(OrderStatus status) {

        Response response = Response.getResponse();

        List<Order> orderHistories = orderService.findOrderByStatus(status);

        List<OrderDto> orderDtos = OrderMapper.INSTANCE.toOrderDtos(order);

        response.setObject(orderDtos);

        return response;
    }

    @Override
    public Response getOrderForProcess(Long id) {

        Response response = Response.getResponse();

        Order order = orderRepo.findById(id).orElse(null);

        if (order == null){
            response.setStatus(0);
            response.setMessage("Заявка не найдена");
            return response;
        }

        OrderStatus status = orderService.findActualOrderStatus(order);

        if (!status.equals(OrderStatus.NEW)){
            response.setStatus(0);
            response.setMessage("Некорректный статус заявки!");
            return response;
        }

        OrderDto orderDto = orderService.appendHistory(OrderMapper.INSTANCE.toOrderDto(order), OrderStatus.IN_PROCESS, null);

        response.setObject(orderDto);
        return response;
    }

    @Override
    public Response changeOrderStatus(OrderStatus status, Long id) {

        Response response = Response.getResponse();

        Order order = orderRepo.findById(id).orElse(null);

        if (order == null){
            response.setStatus(0);
            response.setMessage("Заявка не найдена");
            return response;
        }

        OrderDto orderDto = orderService.appendHistory(OrderMapper.INSTANCE.toOrderDto(order),status, null);

        response.setObject(orderDto);

        return response;
    }

    @Override
    public Response getNextOrder() {
        Response response = Response.getResponse();
        OrderHistory orderHistory = orderHistoryService.getTopOrderHistoryForNextProcess();
        if (orderHistory == null){
            response.setStatus(1);
            response.setMessage("Заявки для следующей обработки отсутсвуют");
            return response;
        }
        OrderDto orderDto = OrderMapper.INSTANCE.orderHistoryToOrderDto(orderHistory);
        response.setObject(orderDto);
        return response;
    }

    @Override
    public Response closeOrder(OrderCloseDto orderCloseDto) {

        Response response = Response.getResponse();
        Order order = orderRepo.findById(orderCloseDto.getOrderId()).orElse(null);
        if (order==null){
            response.setStatus(404);
            response.setMessage("Не найдено");
            return response;
        }
        orderService.closeHistory(order);
        OrderDto orderDto = orderService.(OrderMapper.INSTANCE.toOrderDto(order),orderCloseDto.getStatus(),orderCloseDto.getComment());
        response.setObject(orderDto);

        return response;
    }
}