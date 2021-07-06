package kg.easy.orders.controllers;

import kg.easy.orders.dto.SubscriberOrderDto;
import kg.easy.orders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/subscriber")

public class SubscriberOrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/save")
    public SubscriberOrderDto save(@RequestBody SubscriberOrderDto subscriberOrderDto){
        return orderService.saveOrder(subscriberOrderDto);

    }




}
