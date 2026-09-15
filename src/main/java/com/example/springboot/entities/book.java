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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public category getCategory() {
        return category;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(publisher publisher) {
        this.publisher = publisher;
    }

    public author getAuthor() {
        return author;
    }

    public void setAuthor(author author) {
        this.author = author;
    }

    public List<order_detail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<order_detail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<cart_detail> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<cart_detail> cartDetails) {
        this.cartDetails = cartDetails;
    }
}
