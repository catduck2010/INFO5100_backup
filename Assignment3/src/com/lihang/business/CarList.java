/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lihang.business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author lihang
 */
public class CarList {

    private final ArrayList<CarInfo> carList;
    private Date lastUpdate;
    private int avails = 0, unavails = 0;

    public CarList() {
        this.carList = new ArrayList<>();
        this.updateListInfo();
        //this.updateAvailableCars();
    }

    public ArrayList<CarInfo> getCarList() {
        return carList;
    }

    public void deleteCar(CarInfo car) {
        deleteAvailibility(car.isAvailable());
        this.carList.remove(car);
        updateListInfo();
    }

    public CarInfo addCar() {
        CarInfo car = new CarInfo();
        carList.add(car);
        updateListInfo();
        return car;
    }

    public void updateListInfo() {
        Date now = new Date();
        lastUpdate = now;
        //updateAvailableCars();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public String getDateLabelString() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy"),
                sdf2 = new SimpleDateFormat("HH:mm:ss");
        return "<html><body>" + sdf1.format(lastUpdate)
                + "</br><p align=\"center\">" + sdf2.format(lastUpdate) + "</p></body></html>";
    }

    public void updateAvailableCars() {
        avails = 0;
        unavails = 0;
        for (CarInfo car : carList) {
            if (car.isAvailable()) {
                avails++;
            } else {
                unavails++;
            }
        }
    }

    public int getAvailableNum() {
        return avails;
    }

    public int getUnavailableNum() {
        return unavails;
    }

    public ArrayList<String> getAllManufacturers() {
        ArrayList<String> mList = new ArrayList<>();
        for (CarInfo car : carList) {
            if (!mList.contains(car.getManufacturer().trim())) {
                mList.add(car.getManufacturer().trim());
            }
        }
        return mList;
    }

    public boolean isEmpty() {
        return carList.isEmpty();
    }

    public void addAvailibility(boolean b) {
        if (b) {
            avails++;
        } else {
            unavails++;
        }
    }

    private void deleteAvailibility(boolean b) {
        if (b) {
            avails--;
        } else {
            unavails--;
        }
    }
}
