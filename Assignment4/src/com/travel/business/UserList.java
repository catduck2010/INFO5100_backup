/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.business;

import com.travel.users.User;
import java.util.ArrayList;

/**
 *
 * @author lihang
 */
public abstract class UserList {
    private final ArrayList<User> userList;
    private int listType;
    
    public UserList(){
        userList=new ArrayList<>();
    }

    public abstract void addUser(User u);
    
    public abstract User addUser(String uname,String pw);

    
    public abstract void deleteUser(User u);
    
    public abstract boolean isEmpty();
}
