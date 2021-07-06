package kg.easy.orders.services;

import kg.easy.orders.dto.OrderDto;
import kg.easy.orders.dto.SubscriberOrderDto;
import kg.easy.orders.enums.OrderStatus;
import kg.easy.orders.models.responses.Response;

public class OrderServiceImpl implements OrderService {
    @Override
    public Response saveOrder(OrderDto orderDto) {
        return null;
    }

    @Override
    public Response findOrdersByStatus(OrderStatus status) {
        return null;
    }

    @Override
    public Response getOrderForProcess(Long id) {
        return null;
    }

    @Override
    public Response changeOrderStatus(OrderStatus status, Long id) {
        return null;
    }

    @Override
    public Response getNextOrder() {
        return null;
    }

    @Override
    public Response closeOrder(OrderCloseDto orderCloseDto) {
        return null;
    }

    @Override
    public OrderDto save(OrderDto orderDto) {
        return null;
    }

    @Override
    public SubscriberOrderDto saveOrder(SubscriberOrderDto subscriberOrderDto) {
        return null;
    }
}
