package com.example.springboot.Repositories;

import com.example.springboot.entities.cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<cart, Long> {
}
