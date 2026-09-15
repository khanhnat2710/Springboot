package com.example.springboot.Repositories;


import com.example.springboot.entities.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<order, Long> {
}
