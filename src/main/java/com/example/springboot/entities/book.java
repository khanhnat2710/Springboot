package com.example.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String bookName;

    @Column(columnDefinition = "VARCHAR(100)")
    private String image;

    @Column(columnDefinition = "YEAR")
    private Integer publishYear;

    @Column(columnDefinition = "INT CHECK(quantity >0)")
    private Integer quantity;

    @Column(columnDefinition = "DOUBLE CHECK(price > 0)")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher")
    private publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<order_detail> orderDetails = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<cart_detail> cartDetails = new ArrayList<>();
}
