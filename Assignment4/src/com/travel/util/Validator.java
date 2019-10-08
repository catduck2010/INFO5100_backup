/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lihang
 */
public class Validator {

    public static boolean IsLatLon(String str) {
        //Latitude, Longitude
        String regex = "^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$";
        return Match(regex, str);
    }

    public static boolean IsBetweenNums(String str) {
        //a, b or a,b
        String regex = "^[+]{0,1}(\\d+),\\s*[+]{0,1}(\\d+)$";
        return Match(regex, str);
    }

    public static boolean IsYear(String str) {
        String regex = "^\\d{4}$";
        return Match(regex, str);
    }

    public static boolean IsPositiveInt(String str) {
        String regex = "^[1-9]\\d*$";
        return Match(regex, str);
    }

    public static boolean IsEmpty(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    private static boolean Match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
