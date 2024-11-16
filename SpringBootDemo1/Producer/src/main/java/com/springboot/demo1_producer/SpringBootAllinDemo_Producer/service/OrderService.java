package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.exception.OrderException;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.Order;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private Long lastOrderId = 0L;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.lastOrderId = getLastOrderId();
    }

    // Method to create a new order
    public Order createOrder(Order order) throws OrderException {
        // Business logic: Check if the order id is a multiple of 3

        lastOrderId++;
        order.setOrderId(lastOrderId);

        if (order.getOrderId() % 3 == 0) {
            throw new OrderException("Order ID cannot be a multiple of 3");
        }

        order.setTimestamp(LocalDateTime.now());

        // Save the order in the database
        var temp = orderRepository.save(order);
        System.out.println(temp);

        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getByName(String name) {
        return orderRepository.findByName(name);
    }

    public Order getLastOrder() {
//        System.out.println(this.lastOrderId);

        Order lastOrder = orderRepository.findFirstByOrderByIdDesc();
//        System.out.println(lastOrder.getId());
//        System.out.println(lastOrder.getName());

        lastOrder = orderRepository.getLastRecord();
//        System.out.println(lastOrder.getId());
//        System.out.println(lastOrder.getName());

        List<Order> orders = orderRepository.findLastRecord();
        return orders.isEmpty() ? null : orders.get(0);
    }

    public Long getLastOrderId(){
//        Order lastOrder = null;
        Order lastOrder = getLastOrder();
        return (lastOrder == null || lastOrder.getOrderId() == null) ? 0L : (Long) lastOrder.getOrderId();
    }

    // You can add other methods for retrieving orders or additional business logic
}