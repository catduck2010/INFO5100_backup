/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Organization.AdminOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabAssistantOrganization;
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

        business.getOrganizationDirectory().getOrganizationList()
                .add(adminOrganization);

        Employee employee = new Employee();
        employee.setName("Abc Xyz");

        UserAccount account = new UserAccount();
        account.setUsername("admin");
        account.setPassword("admin");

        account.setRole("Admin");
        account.setEmployee(employee);

        adminOrganization.getEmployeeDirectory().getEmployeeList().add(employee);

        adminOrganization.getUserAccountDirectory().getUserAccountList().add(account);
        
        LabAssistantOrganization labOrg=new LabAssistantOrganization();
        business.getOrganizationDirectory().getOrganizationList().add(labOrg);
        
        Employee ben=new Employee();
        ben.setName("Ben");
        
        UserAccount ac2=new UserAccount();
        ac2.setUsername("lab");
        ac2.setPassword("lab");
        ac2.setRole("Lab Assitant");
        ac2.setEmployee(ben);
        
        
        labOrg.getEmployeeDirectory().getEmployeeList().add(ben);
        labOrg.getUserAccountDirectory().getUserAccountList().add(ac2);
        
        DoctorOrganization drOrg=new DoctorOrganization();
        
        business.getOrganizationDirectory().getOrganizationList().add(drOrg);
        
        Employee jackie=new Employee();
        jackie.setName("Jackie");
        
        UserAccount ac3=new UserAccount();
        ac3.setUsername("doctor");
        ac3.setPassword("doctor");
        ac3.setRole("Doctor");
        ac3.setEmployee(jackie);
        
        drOrg.getEmployeeDirectory().getEmployeeList().add(jackie);
        drOrg.getUserAccountDirectory().getUserAccountList().add(ac3);

        return business;
    }
    
    

}





