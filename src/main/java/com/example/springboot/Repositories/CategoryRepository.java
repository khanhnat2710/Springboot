package com.example.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.category;

public interface CategoryRepository extends JpaRepository<category, Long> {
}
