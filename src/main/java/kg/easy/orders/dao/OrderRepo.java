package kg.easy.orders.dao;

import kg.easy.orders.models.Order;
import kg.easy.orders.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findTopBySubscriberOrderByIdDesc(Subscriber subscriber);


    Order getOrder();
}
