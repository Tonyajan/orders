package kg.easy.orders.models;

import kg.easy.orders.enums.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String schoolAddress;
    private String schoolName;
    private Date startDate;
    private Date endDate;
    private Date naviDate;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_subscriber")
    private Subscriber subscriber;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
