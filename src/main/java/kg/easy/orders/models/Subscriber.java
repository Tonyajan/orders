package kg.easy.orders.models;

import lombok.Data;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "subscriber")

public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthDate;
    private String phoneNumber;
    private int age;
}
