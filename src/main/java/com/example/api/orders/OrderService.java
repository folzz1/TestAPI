package com.example.api.orders;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> orders() {
        return orderRepository.findAll();
    }

    public void add(Order order) {
        orderRepository.save(order);
    }
}
