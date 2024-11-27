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

    @DeleteMapping(path = "delete/{id}")
    public void delete(@PathVariable Long id) {
        Order order = new Order();
        order.setId(id);
        orderService.delete(order);
    }

    @GetMapping(path = "{id}")
    public Order get(@PathVariable Long id) {
        orderService.getOrderById(id);
        return orderService.getOrderById(id);
    }

    @GetMapping(path = "put/{id}")
    public void put(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        orderService.update(order);
    }
}
