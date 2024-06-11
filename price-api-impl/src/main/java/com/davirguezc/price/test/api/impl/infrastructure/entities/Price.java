package com.davirguezc.price.test.api.impl.infrastructure.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "PRICE")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BRAND_ID")
    private String brandId;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST")
    private int priceList;

    @Column(name = "PRODUCT_ID")
    private String productId;

    @Column(name = "PRIORITY")
    private int priority;

    @Column(name = "PRICE")
    private double priceAttribute;

    @Column(name = "CURR")
    private String curr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getPriceList() {
        return priceList;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getPriceAttribute() {
        return priceAttribute;
    }

    public void setPriceAttribute(double price) {
        this.priceAttribute = price;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}