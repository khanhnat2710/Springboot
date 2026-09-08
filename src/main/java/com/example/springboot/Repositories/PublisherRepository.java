package com.example.springboot.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.entities.publisher;

public interface PublisherRepository extends JpaRepository<publisher, Long> {
}
