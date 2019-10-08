/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.users;

/**
 *
 * @author lihang
 */
public class Customer extends User {

    private String firstName;
    private String lastName;

    public Customer(String uname, String pw) {
        super(uname, pw, User.CUSTOMER);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
