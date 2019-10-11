/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import com.travel.users.Customer;
import java.util.ArrayList;

/**
 *
 * @author lihang
 */
public class CustomerList {

    private final ArrayList<Customer> customerList;

    public CustomerList() {
        this.customerList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    
    

    public boolean isEmpty() {
        return customerList.isEmpty();
    }
}
