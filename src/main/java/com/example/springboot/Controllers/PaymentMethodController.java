package com.example.springboot.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.Service.PaymentMethodService;
import com.example.springboot.entities.payment_method;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {
    @Autowired
    public PaymentMethodService paymentMethodService;

    @GetMapping
    public List<payment_method> getAllPaymentMethod() {
        return paymentMethodService.getAllPaymentMethod();
    }

    @GetMapping("/{id}")
    public payment_method getPaymentMethodById(@PathVariable Long id) {
        return paymentMethodService.getPaymentMethodById(id);
    }

    @PostMapping("/create")
    public String createPaymentMethod(@RequestBody payment_method paymentMethod) {
        paymentMethodService.createPaymentMethod(paymentMethod);
        return "Thêm phương thức thanh toán thành công";
    }

    @PutMapping("/{id}")
    public String updatePaymentMethod(@PathVariable Long id, @RequestBody payment_method paymentMethod) {
        paymentMethodService.updatePaymentMethod(id, paymentMethod);
        return "Sửa thành công";
    }

    @DeleteMapping("/{id}")
    public String deletePaymentMethod(@PathVariable Long id) {
        paymentMethodService.deletePaymentMethod(id);
        return "Xóa thành công";
    }
}
