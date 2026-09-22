package com.example.springboot.Controllers;

import com.example.springboot.Service.OrderDetailService;
import com.example.springboot.entities.order_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailController {
    @Autowired
    public OrderDetailService orderDetailService;

    @GetMapping
    public List<order_detail> getAllOrderDetail() {
        return orderDetailService.getAllOrderDetail();
    }

    @GetMapping("/{id}")
    public order_detail getOrderDetailById(@PathVariable Long id) {
        return orderDetailService.getOrderDetailById(id);
    }

    @PostMapping("/create")
    public order_detail createOrderDetail(@RequestBody order_detail orderDetail) {
        return orderDetailService.createOrderDetail(orderDetail);
    }

    @PutMapping("/{id}")
    public order_detail updateOrderDetail(@PathVariable Long id, @RequestBody order_detail orderDetail) {
        return orderDetailService.updateOrderDetail(orderDetail, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteOrderDetail(id);
        return;
    }
}
