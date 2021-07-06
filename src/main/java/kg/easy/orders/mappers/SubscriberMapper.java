package kg.easy.orders.mappers;

import kg.easy.orders.dto.SubscriberDto;
import kg.easy.orders.models.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubscriberMapper {
    SubscriberMapper INSTANCE = Mappers.getMapper(SubscriberMapper.class);
    Subscriber toSubscriber (SubscriberDto subscriberDto);
    SubscriberDto toSubscriberDto(Subscriber subscriber);
}
