package com.example.springboot.Controllers;

import com.example.springboot.Service.OrderService;
import com.example.springboot.entities.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    public OrderService orderService;

    @GetMapping
    public List<order> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/create")
    public order createOrder(@RequestBody order order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public order updateOrder(@PathVariable Long id, @RequestBody order order) {
        return orderService.updateOrder(order, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return;
    }
}
