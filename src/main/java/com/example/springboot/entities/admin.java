package com.example.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

//Định nghĩa một admin là 1 entity tương ứng với bảng trong db
@Entity
//Cấu hình cho class này tương ứng với bản có tên là admin trong db
@Table(name = "admin")
public class admin {
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

    //định nghãi một admin quản lý nhiều order
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<order> orders = new ArrayList<>();

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

    public List<order> getOrders() {
        return orders;
    }

    public void setOrders(List<order> orders) {
        this.orders = orders;
    }

    
}

