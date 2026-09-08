package com.example.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     //Attr name tương ứng với cột fullName trong db
    @Column
    private String fullName;

    //Attr email tương ứng với cột email trong db
    @Column(columnDefinition = "VARCHAR(50)")
    private String email;

    //Attr password tương ứng với cột password trong db
    @Column(columnDefinition = "VARCHAR(50)") 
    private String password;

    //Attr phone tương ứng với cột phone trong db
    @Column(columnDefinition = "VARCHAR(20)")
    private String phone;

    //Attr address tương ứng với cột address trong db
    @Column(columnDefinition = "VARCHAR(100)")
    private String address;

    //định nghĩa một cusotmer có nhiều order
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private cart cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<order> getOrders() {
        return orders;
    }

    public void setOrders(List<order> orders) {
        this.orders = orders;
    }

    public cart getCart() {
        return cart;
    }

    public void setCart(cart cart) {
        this.cart = cart;
    }

    
}
