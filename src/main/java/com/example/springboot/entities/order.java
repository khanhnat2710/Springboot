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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public customer getCustomer() {
        return customer;
    }

    public void setCustomer(customer customer) {
        this.customer = customer;
    }

    public admin getAdmin() {
        return admin;
    }

    public void setAdmin(admin admin) {
        this.admin = admin;
    }

    public payment_method getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(payment_method paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<order_detail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<order_detail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
