/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lihang
 */
public class Validator {

    public static boolean IsValidUsername(String str) {
        String regex = "^[a-zA-Z0-9]+_[a-zA-Z0-9]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+$";
        return Match(regex, str);
    }

    public static boolean IsValidPassword(String str) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$#*&])[A-Za-z\\d$#*&]{6,}";
        return Match(regex, str);
    }

    public static boolean IsEmpty(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }
    
    public static boolean IsSamePassword(String pw,String re){
        if(pw.equals(re))return true;
        return false;
    }

    private static boolean Match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
}
