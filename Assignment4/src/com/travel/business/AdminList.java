/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import com.travel.users.Admin;
import java.util.ArrayList;

/**
 *
 * @author lihang
 */
public class AdminList {

    private final ArrayList<Admin> adminList;

    public AdminList() {
        this.adminList = new ArrayList<>();
    }

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }

    
    public void addAdmin(Admin a) {
        adminList.add(a);
    }

    public Admin addAdmin(String uname, String pw) {
        Admin a = new Admin(uname, pw);
        adminList.add(a);
        return a;
    }

    public void deleteAdmin(Admin a) {
        adminList.remove(a);
    }


    public boolean isEmpty() {
        return adminList.isEmpty();
    }
    
    
}
