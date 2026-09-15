package com.example.springboot.Repositories;

import com.example.springboot.entities.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<book, Long> {
}
