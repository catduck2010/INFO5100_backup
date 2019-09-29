/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lihang.lab3_5.business;

import java.util.Date;

/**
 *
 * @author lihang
 */
public class Product {

    private String productName;
    private String availibility;
    private String price;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private Date createdOn;

    public Product() {
        this.createdOn = new Date();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAvailibility() {
        return availibility;
    }

    public void setAvailibility(String availibility) {
        this.availibility = availibility;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

   

    public Date getCreatedOn() {
        return createdOn;
    }

    @Override
    public String toString() {
        return getProductName();
    }
}
