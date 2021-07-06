package kg.easy.orders.services.impl;

import kg.easy.orders.dao.SubscriberRepo;
import kg.easy.orders.dto.SubscriberDto;
import kg.easy.orders.mappers.SubscriberMapper;
import kg.easy.orders.models.Subscriber;
import kg.easy.orders.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepo subscriberRepo;
    @Override
    public SubscriberDto findSubscriberByPhoneNumber(String phoneNumber) {

        Subscriber subscriber = subscriberRepo.findByPhoneNumber(phoneNumber);

        return SubscriberMapper.INSTANCE.toSubscriberDto(subscriber);
    }

    @Override
    public SubscriberDto save(SubscriberDto subscriberDto) {
        Subscriber subscriber = subscriberRepo.save(
                SubscriberMapper.INSTANCE.toSubscriber(subscriberDto)
        );
        return SubscriberMapper.INSTANCE.toSubscriberDto(subscriber);
    }
}
