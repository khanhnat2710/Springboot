package com.example.springboot.Service;

import com.example.springboot.Repositories.AdminRepository;
import com.example.springboot.Repositories.CustomerRepository;
import com.example.springboot.Repositories.OrderRepository;
import com.example.springboot.Repositories.PaymentMethodRepository;
import com.example.springboot.entities.order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;

    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public AdminRepository adminRepository;

    @Autowired
    public PaymentMethodRepository paymentMethodRepository;

    //Lấy toàn bộ order
    public List<order> getAllOrder() {
        return orderRepository.findAll();
    }

    //Lấy order theo id
    public order getOrderById(long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy"));
    }

    //Tạo order
    public order createOrder(order order) {
        Long customerId = order.getCustomer().getId();
        Long adminId = order.getAdmin().getId();
        Long paymentId = order.getPaymentMethod().getId();
        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Khong ton tai khach hang");
        }
        if (!adminRepository.existsById(adminId)) {
            throw new RuntimeException("Khong ton tai admin");
        }
        if (!paymentMethodRepository.existsById(paymentId)) {
            throw new RuntimeException("Khong ton tai phuong thuc thanh toan");
        }
        return orderRepository.save(order);
    }

    //Update
    public order updateOrder(order order, Long id) {
        order existingOrder = getOrderById(id);
        Long customerId = order.getCustomer().getId();
        Long adminId = order.getAdmin().getId();
        Long paymentId = order.getPaymentMethod().getId();
        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Khong ton tai khach hang");
        }
        if (!adminRepository.existsById(adminId)) {
            throw new RuntimeException("Khong ton tai admin");
        }
        if (!paymentMethodRepository.existsById(paymentId)) {
            throw new RuntimeException("Khong ton tai phuong thuc thanh toan");
        }
        //Update lại existing
        existingOrder.setOrderDate(order.getOrderDate());
        existingOrder.setTotalAmount(order.getTotalAmount());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setAdmin(order.getAdmin());
        existingOrder.setCustomer(order.getCustomer());
        existingOrder.setPaymentMethod(order.getPaymentMethod());
        return orderRepository.save(existingOrder);
    }

    //delete
    public void deleteOrder(Long id){
        order existingOrder = getOrderById(id);
        orderRepository.delete(existingOrder);
        return;
    }
}
