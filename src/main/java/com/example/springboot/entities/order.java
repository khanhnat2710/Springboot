package com.example.springboot.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Attr orderDate tương ứng với cột orderDate trong db
    @Column(columnDefinition = "DATE")
    private Date orderDate;

    //Attr totalAmount tương ứng với cột totalAmount trong db
    @Column(columnDefinition = "DECIMAL(8, 2)")
    private Double totalAmount;

    //Attr statu tương tứng vói cột status trong db
    @Column(columnDefinition = "VARCHAR(20)")
    private String status;

    //Nhiều order thuộc về 1 customer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private customer customer;

    //Nhiều order thuộc quản lý 1 admin
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private admin admin;

    //Nhiều order thuộc về 1 payment_method
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id")
    private payment_method paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<order_detail> orderDetails = new ArrayList<>();
}
