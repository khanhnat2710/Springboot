package com.example.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.author;

public interface AuthorRepository extends JpaRepository<author, Long> {
}
