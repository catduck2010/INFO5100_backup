/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import java.util.Date;

/**
 *
 * @author lihang
 */
public class Flight {
    private int seats;
    private String planeModel;
    private Date takeOffTime;
    private Date landTime;
    private String departure;
    private String arrival;
    
    private CustomerList onBoard;
    
    public Flight(){
        
    }
}
