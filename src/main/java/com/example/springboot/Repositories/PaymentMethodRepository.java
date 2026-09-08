package com.example.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.payment_method;

public interface PaymentMethodRepository extends JpaRepository<payment_method, Long> {
}
