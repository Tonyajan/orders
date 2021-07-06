package kg.easy.orders.mappers;

import kg.easy.orders.dao.OrderRepo;
import kg.easy.orders.dto.OrderDto;
import kg.easy.orders.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper

public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDto toOrderDto(Order order);
    Order toOrder (OrderDto orderDto);

    default List<OrderDto> toOrderDtos(List<OrderRepo> orderRepos){


        List<OrderDto> orderDtos = orderRepos.stream()
                .map(x-> {
                    OrderDto orderDto = toOrderDto(x.getOrder());
                    orderDto.setId(OrderMapper.INSTANCE.toOrderDto(x));

                    return orderDto;
                })
                .collect(Collectors.toList());

        return orderDtos;

    }
    default OrderDto orderToOrderDto(OrderRepo orderRepo){
        OrderDto orderDto = OrderMapper.INSTANCE.toOrderDto(orderRepo.getOrder());
        orderDto.setStatus(OrderMapper.INSTANCE.toOrderDto(orderRepo));
        return orderDto;
    }


}
