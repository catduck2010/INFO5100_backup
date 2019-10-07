/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.business.Users;

import lab4.business.Abstract.User;
import lab4.business.CustomerDirectory;
import java.util.Date;

/**
 *
 * @author Lihang Zhou
 */
public class Customer extends User implements Comparable<Customer> {

    private Date created;

    public Customer(String username, String passwd) {
        super(username, passwd, "CUSTOMER");
        created = new Date();
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public int compareTo(Customer o) {
        return o.getUserName().compareTo(this.getUserName());
    }

    @Override
    public String toString() {
        return getUserName(); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verify(String password) {
        if (password.equals(getPassword())) {
            return true;
        }
        return false;
    }
}
