package kg.easy.orders.services;

import kg.easy.orders.dto.SubscriberDto;

public interface SubscriberService {

    SubscriberDto findSubscriberByPhoneNumber(String phoneNumber);

    SubscriberDto save(SubscriberDto subscriberDto);

    SubscriberDto saveSubscriber(SubscriberDto subscriberDto);
}
