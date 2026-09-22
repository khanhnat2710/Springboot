package com.example.springboot.Service;

import com.example.springboot.Repositories.BookRepository;
import com.example.springboot.Repositories.CartDetailRepository;
import com.example.springboot.Repositories.CartRepository;
import com.example.springboot.entities.cart_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService {
    @Autowired
    public CartDetailRepository cartDetailRepository;

    @Autowired
    public CartRepository cartRepository;

    @Autowired
    public BookRepository bookRepository;

    //Lấy toàn bộ cart_detail
    public List<cart_detail> getAllCartDetail() {
        return cartDetailRepository.findAll();
    }

    //Lấy cart_detail theo id
    public cart_detail getCartDetailById(Long id) {
        return cartDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong tim thay"));
    }

    //Tạo cart_detail
    public cart_detail createCartDetail(cart_detail cartDetail) {
        Long cartId = cartDetail.getCart().getId();
        Long bookId = cartDetail.getBook().getId();
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Khong ton tai gio hang");
        }
        if (!bookRepository.existsById(bookId)) {
            throw new RuntimeException("Khong ton tai sach");
        }
        return cartDetailRepository.save(cartDetail);
    }

    //Update
    public cart_detail updateCartDetail(cart_detail cartDetail, Long id) {
        cart_detail existingCartDetail = getCartDetailById(id);
        Long cartId = cartDetail.getCart().getId();
        Long bookId = cartDetail.getBook().getId();
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Khong ton tai gio hang");
        }
        if (!bookRepository.existsById(bookId)) {
            throw new RuntimeException("Khong ton tai sach");
        }
        //Update lại existing
        existingCartDetail.setQuantity(cartDetail.getQuantity());
        existingCartDetail.setCart(cartDetail.getCart());
        existingCartDetail.setBook(cartDetail.getBook());
        return cartDetailRepository.save(existingCartDetail);
    }

    //delete
    public void deleteCartDetail(Long id) {
        cart_detail existingCartDetail = getCartDetailById(id);
        cartDetailRepository.delete(existingCartDetail);
        return;
    }
}
