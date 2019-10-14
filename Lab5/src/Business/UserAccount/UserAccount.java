/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;

/**
 *
 * @author raunak
 */
public class UserAccount {
    // Three roles: LabAssistant, Doctor, Admin
    
    private String username;
    private String password;
    private Employee employee;
    private String role;

    public UserAccount() {
        
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}