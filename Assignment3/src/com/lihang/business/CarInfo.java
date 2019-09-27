/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lihang.business;

import java.util.Date;

/**
 *
 * @author lihang
 */
public class CarInfo {

    //Driver
    private String firstName;
    private String middleName;
    private String lastName;

    //Car
    private String manufacturer;
    private String modelNum;
    private String SN;
    private int seats;
    private boolean isAvailable;
    private Date productionDate;
    private Date lastMaintenance;

    //Location
    private double longtitude;
    private double latitude;

    private String city;

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void switchAvailibility() {
        this.isAvailable = !isAvailable;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelNum() {
        return modelNum;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public String getSN() {
        return SN;
    }

    public void setSN(String SN) {
        this.SN = SN;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Date getLastMaintenance() {
        return lastMaintenance;
    }

    public void setLastMaintenance(Date lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public String toString() {
        String av = " ";
        if (isAvailable) {
            av = "✓";
        }
        return av;
    }

    public String getStringForMatching() {
        return firstName + " " + middleName + " " + lastName + " "
                + modelNum + " " + manufacturer + " " + SN + " " + city;

    }

}
