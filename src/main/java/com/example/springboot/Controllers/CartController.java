package com.example.springboot.Controllers;

import com.example.springboot.Service.CartService;
import com.example.springboot.entities.cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    @Autowired
    public CartService cartService;

    @GetMapping
    public List<cart> getAllCart() {
        return cartService.getAllCart();
    }

    @GetMapping("/{id}")
    public cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @PostMapping("/create")
    public cart createCart(@RequestBody cart cart) {
        return cartService.createCart(cart);
    }

    @PutMapping("/{id}")
    public cart updateCart(@PathVariable Long id, @RequestBody cart cart) {
        return cartService.updateCart(cart, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return;
    }
}
