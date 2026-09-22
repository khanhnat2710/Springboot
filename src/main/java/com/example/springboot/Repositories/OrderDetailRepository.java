package com.example.springboot.Repositories;

import com.example.springboot.entities.order_detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<order_detail, Long> {
}
