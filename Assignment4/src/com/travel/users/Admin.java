/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.users;

import com.travel.business.AirlinerList;
import com.travel.business.CustomerList;

/**
 *
 * @author lihang
 */
public class Admin extends User {

    private final CustomerList customers;
    private final AirlinerList airliners;

    public Admin(String uname, String pw) {
        super(uname, pw, User.ADMINISTRATOR);
        this.customers = new CustomerList();
        this.airliners = new AirlinerList();

    }

    public Admin(String uname, String pw, AirlinerList al, CustomerList cl) {
        super(uname, pw, User.ADMINISTRATOR);
        this.customers = cl;
        this.airliners = al;
    }
    
    @Override
    public String toString(){
        return this.getUsername();
    }

}
