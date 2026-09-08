package com.example.springboot.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_detail")
public class cart_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "INT CHECK(quantity > 0)")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private book book;
}
