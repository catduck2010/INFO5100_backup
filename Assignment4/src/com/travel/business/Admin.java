/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

/**
 *
 * @author lihang
 */
public class Admin extends User{
    
    public Admin(String uname, String pw) {
        super(uname, pw, User.ADMINISTRATOR);
    }
    
}
