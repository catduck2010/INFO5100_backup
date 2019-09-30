/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lihang.business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        this.addBasicInfos();
        this.updateListInfo();
        this.updateAvailableCars();
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

    private void addBasicInfos() {

        Date nextDay = getNextDay(), lastYear = getLastYear();
        //CarInfo(String firstName, String lastName, String manufacturer, 
        //String modelNum, String SN, int seats, boolean isAvailable, Date productionDate, 
        //Date lastMaintenance, double longitude, double latitude, String city)
        CarInfo car0 = new CarInfo("John", "Appleseed", "Toyota", "TO-0001",
                "KDJXHDIDFO", 4, true, lastYear, nextDay, 42.3549825, -71.072195, "Boston"),
                car1 = new CarInfo("John", "Dick", "Volkswagen", "VW-0009",
                        "BXCUBYQSDI", 4, true, lastYear, nextDay, 37.7844452,-122.4731381, "San Francisco"),
                car2 = new CarInfo("Bob", "Sherlock", "Honda", "HD-9080",
                        "XCNXUGCYSD", 4, true, lastYear, nextDay, 42.3556404,-71.055665, "Boston"),
                car3 = new CarInfo("Robert", "Watson", "Kia", "KIA-K5",
                        "XBCYTDFSOD", 4, true, lastYear, nextDay, 38.8841189,-76.9950225, "D.C."),
                car4 = new CarInfo("Hi", "Lee", "Hyundai", "HY-SD",
                        "XNCIXUBCUL", 4, true, lastYear, nextDay, 42.3669166,-71.0584111, "Boston"),
                car5 = new CarInfo("Ji-Won", "Kim", "Renault", "TO-0001",
                        "SDHXCUYSKD", 4, true, lastYear, nextDay, 42.3551624,-71.0633332, "Boston"),
                car6 = new CarInfo("Elizabeth", "Hart", "Peugeot", "PG-30",
                        "XIOCJSDFDX", 4, true, lastYear, nextDay, 42.3588362,-71.0578277, "Boston"),
                car7 = new CarInfo("Samantha", "Timo", "Nissan", "TO-0001",
                        "QGDUIFSDHD", 4, true, lastYear, nextDay, 42.3595541,-71.0524312, "Boston"),
                car8 = new CarInfo("Roose", "Dick", "Tesla", "TO-0001",
                        "KIDFSDFBXO", 4, true, lastYear, nextDay, 42.3567012,-71.0573372, "Boston"),
                car9 = new CarInfo("YT", "Yang", "Renault Samsung", "RS-QM6",
                        "BJDBSFDNFD", 4, true, lastYear, nextDay, 42.3560868,-71.0532185, "Boston");

        carList.add(car0);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
        carList.add(car7);
        carList.add(car8);
        carList.add(car9);
    }

    private Date getNextDay() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateFormat.format(currentDate));

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);

        // convert calendar to date
        return c.getTime();
    }

    private Date getLastYear() {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateFormat.format(currentDate));

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
        c.add(Calendar.YEAR, -1);

        // convert calendar to date
        return c.getTime();
    }
}
