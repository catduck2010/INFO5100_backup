/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Organization.AdminOrganization;
import Business.UserAccount.UserAccount;

/**
 *
 * @author ran
 */
public class ConfigureABusiness {

    public static Business configure() {
        // Three roles: LabAssistant, Doctor, Admin

        Business business = Business.getInstance();

        AdminOrganization adminOrganization = new AdminOrganization();

        business.getOrganizationDirectory().getOrganizationList().add(adminOrganization);

        Employee employee = new Employee();
        employee.setName("Abc Xyz");

        UserAccount account = new UserAccount();
        account.setUsername("admin");
        account.setPassword("admin");

        account.setRole("Admin");
        account.setEmployee(employee);

        adminOrganization.getEmployeeDirectory().getEmployeeList().add(employee);

        adminOrganization.getUserAccountDirectory().getUserAccountList().add(account);

        return business;
    }

}


