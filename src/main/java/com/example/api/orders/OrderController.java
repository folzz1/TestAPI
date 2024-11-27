package com.example.api.orders;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path = "list")
    public List<Order> orders() {
        return orderService.orders();
    }

    @PostMapping(path = "item")
    public void add(@RequestBody Order order) {
        orderService.add(order);
    }
}
