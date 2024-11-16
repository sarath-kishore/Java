package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.repository;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // You can add custom query methods here if required
    @Query(value = "SELECT * FROM orders ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Order getLastRecord();

    Order findFirstByOrderByIdDesc();
    List<Order> findByName(String name);
    @Query("SELECT o FROM Order o ORDER BY o.id DESC")
    List<Order> findLastRecord();
}