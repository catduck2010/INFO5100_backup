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
public class Airliner extends User {

    private final FlightDirectory flightDirectory;
    private String providerName;

    public Airliner(String uname, String pw) {
        super(uname, pw, User.AIRLINER);
        this.flightDirectory = new FlightDirectory();
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    
}
