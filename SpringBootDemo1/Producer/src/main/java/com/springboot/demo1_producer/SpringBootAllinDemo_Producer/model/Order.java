package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    private LocalDateTime timestamp;

    private String name;

    public void setTimestamp(LocalDateTime now) {
        this.timestamp = now;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long lastOrderId) {
        this.id = lastOrderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
