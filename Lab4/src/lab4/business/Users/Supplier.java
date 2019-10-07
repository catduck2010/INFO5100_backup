/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.business.Users;

import lab4.business.Abstract.User;
import lab4.business.ProductDirectory;

/**
 *
 * @author AEDSpring2019
 */
public class Supplier extends User implements Comparable<Supplier> {

    private ProductDirectory directory;

    public Supplier(String userName, String password) {
        super(userName, password, "SUPPLIER");
        directory = new ProductDirectory();
    }

    public ProductDirectory getDirectory() {
        return directory;
    }

    public void setDirectory(ProductDirectory directory) {
        this.directory = directory;
    }

    @Override
    public int compareTo(Supplier o) {
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
