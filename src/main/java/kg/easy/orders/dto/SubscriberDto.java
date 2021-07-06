package kg.easy.orders.dto;

import lombok.Data;

import java.util.Date;

@Data

public class SubscriberDto {
    private Long id;
    private String name;
    private Date birthDate;
    private String phoneNumber;
    private int age;

}
