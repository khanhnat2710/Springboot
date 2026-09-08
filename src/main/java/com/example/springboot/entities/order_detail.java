package com.example.springboot.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class order_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INT CHECK(quantity > 0)")
    private Integer quantity;

    @Column(columnDefinition = "DOUBLE CHECK(price > 0)")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private order order;
}
