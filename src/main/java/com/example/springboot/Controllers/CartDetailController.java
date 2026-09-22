package com.example.springboot.Controllers;

import com.example.springboot.Service.CartDetailService;
import com.example.springboot.entities.cart_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-details")
public class CartDetailController {
    @Autowired
    public CartDetailService cartDetailService;

    @GetMapping
    public List<cart_detail> getAllCartDetail() {
        return cartDetailService.getAllCartDetail();
    }

    @GetMapping("/{id}")
    public cart_detail getCartDetailById(@PathVariable Long id) {
        return cartDetailService.getCartDetailById(id);
    }

    @PostMapping("/create")
    public cart_detail createCartDetail(@RequestBody cart_detail cartDetail) {
        return cartDetailService.createCartDetail(cartDetail);
    }

    @PutMapping("/{id}")
    public cart_detail updateCartDetail(@PathVariable Long id, @RequestBody cart_detail cartDetail) {
        return cartDetailService.updateCartDetail(cartDetail, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCartDetail(@PathVariable Long id) {
        cartDetailService.deleteCartDetail(id);
        return;
    }
}
