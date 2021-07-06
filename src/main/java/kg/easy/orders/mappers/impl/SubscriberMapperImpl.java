package kg.easy.orders.mappers.impl;

import kg.easy.orders.dto.SubscriberDto;
import kg.easy.orders.dto.SubscriberOrderDto;
import kg.easy.orders.mappers.SubscriberMapper;
import kg.easy.orders.models.Subscriber;
import org.springframework.stereotype.Service;

import java.util.concurrent.Flow;
@Service
public class SubscriberMapperImpl implements SubscriberMapper {
    @Override
    public Subscriber toSubscriber(SubscriberDto subscriberDto) {

        Subscriber subscriber = new Subscriber();
        subscriber.setId(subscriberDto.getId());
        subscriber.setName(subscriberDto.getName());
        subscriber.setPhoneNumber(subscriberDto.getPhoneNumber());
        subscriber.setBirthDate(subscriberDto.getBirthDate());
        subscriber.setAge(subscriberDto.getAge());
        return subscriber;
    }

    @Override
    public SubscriberDto subscriberOrderDtoToSubscriber(SubscriberOrderDto subscriberOrderDto) {
        SubscriberDto subscriberDto= new SubscriberDto();
        subscriberDto.setName(subscriberDto.getName());
        subscriberDto.setBirthDate(subscriberDto.getBirthDate());
        subscriberDto.setPhoneNumber(subscriberDto.getPhoneNumber());
        subscriberDto.setAge(subscriberDto.getAge());
        return subscriberDto;
    }

    @Override
    public SubscriberDto toSubscriberDto(Subscriber subscriber) {
        return null;
    }
}
