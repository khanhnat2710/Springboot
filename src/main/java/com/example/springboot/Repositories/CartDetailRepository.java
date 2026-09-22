package com.example.springboot.Repositories;

import com.example.springboot.entities.cart_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<cart_detail, Long> {
}
