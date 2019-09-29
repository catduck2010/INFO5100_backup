/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lihang.lab3_5.business;

import java.util.ArrayList;

/**
 *
 * @author lihang
 */
public class ProductDirectory {

    private ArrayList<Product> productList;

    public ProductDirectory() {
        this.productList = new ArrayList<>();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public Product addProduct() {
        Product product = new Product();
        this.productList.add(product);
        return product;
    }

    public void deleteProduct(Product ac) {
        this.productList.remove(ac);
    }

    public Product searchProduct(String acNumber) {
        for (Product ac : this.productList) {
            if (ac.getAvailibility().equals(acNumber)) {
                return ac;
            }
        }
        return null;
    }
}
