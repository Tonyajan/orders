package kg.easy.orders.dao;

import kg.easy.orders.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubscriberRepo extends JpaRepository<Subscriber, Long> {
    Subscriber findByPhoneNumber(String phoneNumber);
}
