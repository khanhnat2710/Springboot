package com.example.springboot.Service;

import com.example.springboot.Repositories.CartRepository;
import com.example.springboot.Repositories.CustomerRepository;
import com.example.springboot.entities.cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public CustomerRepository customerRepository;

    //Lấy toàn bộ cart
    public List<cart> getAllCart() {
        return cartRepository.findAll();
    }

    //Lấy cart theo id
    public cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong tim thay"));
    }

    //Tạo cart
    public cart createCart(cart cart) {
        Long customerId = cart.getCustomer().getId();
        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Khong ton tai khach hang");
        }
        return cartRepository.save(cart);
    }

    //Update
    public cart updateCart(cart cart, Long id) {
        cart existingCart = getCartById(id);
        Long customerId = cart.getCustomer().getId();
        if (!customerRepository.existsById(customerId)) {
            throw new RuntimeException("Khong ton tai khach hang");
        }
        //Update lại existing
        existingCart.setCreateDate(cart.getCreateDate());
        existingCart.setCustomer(cart.getCustomer());
        return cartRepository.save(existingCart);
    }

    //delete
    public void deleteCart(Long id) {
        cart existingCart = getCartById(id);
        cartRepository.delete(existingCart);
        return;
    }
}
