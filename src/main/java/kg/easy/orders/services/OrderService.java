package kg.easy.orders.services;

import kg.easy.orders.dto.OrderDto;
import kg.easy.orders.dto.SubscriberOrderDto;
import kg.easy.orders.enums.OrderStatus;
import kg.easy.orders.models.Order;
import kg.easy.orders.models.responses.Response;

public interface OrderService {
    Response saveOrder(OrderDto orderDto);

    Response findOrdersByStatus(OrderStatus status);

    Response getOrderForProcess(Long id);

    Response changeOrderStatus(OrderStatus status, Long id);

    Response getNextOrder();

    Response closeOrder(OrderCloseDto orderCloseDto);
}
    OrderDto save(OrderDto orderDto);

    SubscriberOrderDto saveOrder(SubscriberOrderDto subscriberOrderDto);

    void close(Order currOrder);
}
