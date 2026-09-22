package com.example.springboot.Service;

import com.example.springboot.Repositories.BookRepository;
import com.example.springboot.Repositories.OrderDetailRepository;
import com.example.springboot.Repositories.OrderRepository;
import com.example.springboot.entities.order_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    public OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public BookRepository bookRepository;

    //Lấy toàn bộ order_detail
    public List<order_detail> getAllOrderDetail() {
        return orderDetailRepository.findAll();
    }

    //Lấy order_detail theo id
    public order_detail getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong tim thay"));
    }

    //Tạo order_detail
    public order_detail createOrderDetail(order_detail orderDetail) {
        Long orderId = orderDetail.getOrder().getId();
        Long bookId = orderDetail.getBook().getId();
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Khong ton tai don hang");
        }
        if (!bookRepository.existsById(bookId)) {
            throw new RuntimeException("Khong ton tai sach");
        }
        return orderDetailRepository.save(orderDetail);
    }

    //Update
    public order_detail updateOrderDetail(order_detail orderDetail, Long id) {
        order_detail existingOrderDetail = getOrderDetailById(id);
        Long orderId = orderDetail.getOrder().getId();
        Long bookId = orderDetail.getBook().getId();
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Khong ton tai don hang");
        }
        if (!bookRepository.existsById(bookId)) {
            throw new RuntimeException("Khong ton tai sach");
        }

        //Update lại existing
        existingOrderDetail.setQuantity(orderDetail.getQuantity());
        existingOrderDetail.setPrice(orderDetail.getPrice());
        existingOrderDetail.setOrder(orderDetail.getOrder());
        existingOrderDetail.setBook(orderDetail.getBook());
        return orderDetailRepository.save(existingOrderDetail);
    }

    //delete
    public void deleteOrderDetail(Long id) {
        order_detail existingOrderDetail = getOrderDetailById(id);
        orderDetailRepository.delete(existingOrderDetail);
        return;
    }
}
