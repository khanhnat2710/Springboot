package com.example.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Repositories.PaymentMethodRepository;
import com.example.springboot.entities.payment_method;

@Service
public class PaymentMethodService {
    @Autowired
    public PaymentMethodRepository paymentMethodRepository;

    public List<payment_method> getAllPaymentMethod() {
        return paymentMethodRepository.findAll();
    }

    public payment_method getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không có phương thức thanh toán phù hợp"));
    }

    public payment_method createPaymentMethod(payment_method paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    public payment_method updatePaymentMethod(Long id, payment_method paymentMethod) {
        payment_method existing = getPaymentMethodById(id);
        existing.setName(paymentMethod.getName());
        return paymentMethodRepository.save(existing);
    }

    public payment_method deletePaymentMethod(Long id) {
        payment_method existing = getPaymentMethodById(id);
        paymentMethodRepository.deleteById(id);
        return existing;
    }
}
