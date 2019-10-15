/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author lihang
 */
public class LabAssistantOrganization extends Organization{

    public LabAssistantOrganization() {
        super(Type.Lab.getValue());
    }

    @Override
    public ArrayList<String> getSupportedRole() {
        ArrayList<String> roles = new ArrayList<>();
        roles.add("Lab");
        return roles;
    }
    
}
