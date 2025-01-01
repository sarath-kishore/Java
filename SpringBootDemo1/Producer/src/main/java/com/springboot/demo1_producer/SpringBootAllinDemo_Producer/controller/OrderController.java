package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.controller;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.exception.OrderException;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.Order;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@RestController
@Controller
@RequestMapping("/")
@Log4j2
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public String createOrder(@RequestParam("name") String name, Model model) throws OrderException {
        System.out.println("inside create order 1");
        //        try {
            Order order = new Order();
            order.setName(name);
            Order createdOrder = orderService.createOrder(order);
            System.out.println("post mapping");
//            model.addAttribute("orders", orderService.getAllOrders());
            Long lastOrderId = createdOrder.getOrderId();
            model.addAttribute("lastOrderId", lastOrderId);

            return "index"; // Return the view name (index.html)
//        }
//        catch (OrderException e) {
//            System.out.println("post mapping error, " + e.getMessage());
//            model.addAttribute("errorMessage", e.getMessage());
//            return "error";
//        }
    }

    // Endpoint to create a new order using postman
    @PostMapping("/api/orders")
    public ResponseEntity<?> createOrder2(@RequestBody Order order, Model model) throws OrderException {
        System.out.println("inside create order 2");
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    // Endpoint to get all orders (you can later implement pagination or filters)
    @GetMapping
    public String showHome(Model model) {
//        public ResponseEntity<List<Order>> getAllOrders(Model model) {
//        List<Order> orders = orderService.getAllOrders();
//        return ResponseEntity.ok(orders);
        Long lastOrderId = orderService.getLastOrderId();
        model.addAttribute("lastOrderId", lastOrderId);
        System.out.println(lastOrderId);
        System.out.println("get mapping");
        return "index"; // Return the view name (index.html)
    }

    @GetMapping("/api/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/api/orders/name")
    public ResponseEntity<List<Order>> getName(@RequestBody Order order) {
        List<Order> orders = orderService.getByName(order.getName());
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/api/orders/last")
    public ResponseEntity<List<Order>> getLastOrder() {
        List<Order> orders = List.of(orderService.getLastOrder());
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/api/orders/csrf")
    @ResponseBody // since thymeleaf is being used to render html pages, this annotation is necessary to indicate that this endpoint is a REST endpoint and not to be resolved by thymeleaf engine
    public CsrfToken getCSRF(HttpServletRequest request){
//    public Map<String, CsrfToken> getCSRF(HttpServletRequest request){
        System.out.println("inside get mapping csrf");
        return (CsrfToken) request.getAttribute("_csrf");
//        return Map.of("csrf", (CsrfToken) request.getAttribute("_csrf"));
    }
}