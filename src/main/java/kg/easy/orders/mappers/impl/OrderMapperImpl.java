package kg.easy.orders.mappers.impl;

import kg.easy.orders.dto.OrderDto;
import kg.easy.orders.mappers.OrderMapper;
import kg.easy.orders.models.Order;

public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order toOrder(OrderDto orderDto) {
        OrderMapper.INSTANCE.toOrder(orderDto);

        Order order = new Order();
        order.setId(order.getId());
        order.setSchoolAddress(order.getSchoolAddress());
        order.setSchoolName(order.getSchoolName());
        order.setStartDate(order.getStartDate());
        order.setEndDate(order.getEndDate());
        order.setNaviDate(order.getNaviDate());
        order.setComment(order.getComment());
        order.setSubscriber(order.getSubscriber());
        order.setStatus(order.getStatus());
        return order;
    }
}
