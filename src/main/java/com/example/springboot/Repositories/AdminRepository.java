package com.example.springboot.Repositories;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.admin;

@ReadingConverter
public interface AdminRepository extends JpaRepository<admin, Long> {
    
}
