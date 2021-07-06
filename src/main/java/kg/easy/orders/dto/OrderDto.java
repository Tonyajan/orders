package kg.easy.orders.dto;

import kg.easy.orders.enums.OrderStatus;
import kg.easy.orders.models.Subscriber;
import lombok.Data;


import java.util.Date;

@Data

public class OrderDto {

    private Long id;
    private String schoolAddress;
    private String schoolName;
    private Date startDate;
    private Date endDate;
    private Date naviDate;
    private String comment;
    private SubscriberDto subscriber;
    private OrderStatus status;
}
