/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travel.interfaces;

import com.travel.business.AdminList;
import com.travel.business.AirlinerList;
import com.travel.business.CustomerList;
import com.travel.users.*;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author lihang
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form LoginPanel
     */
    private final AdminList admins;
    private final AirlinerList airliners;
    private final CustomerList customers;

    private final JPanel rightPanel;

    public LoginPanel(JPanel p, AdminList ad, AirlinerList al, CustomerList cl) {
        initComponents();
        this.rightPanel = p;
        this.admins = ad;
        this.airliners = al;
        this.customers = cl;
        ItemListener il=new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
                //System.out.println(e.getSource());
                fillUserBox();
                txtPswd.setText("");
            }
        };
        
        this.radioAdmin.addItemListener(il);
        this.radioAir.addItemListener(il);
        this.radioCustomer.addItemListener(il);
        
        fillUserBox();
    }
    
    private void fillUserBox(){
        if(radioAdmin.isSelected()){
            if(admins.isEmpty()){
                //set no user
                setUserBoxEmpty();
            }else{
                //fill the box
                loadBoxWithAdmins(admins.getAdminList());
            }
        }else if(radioAir.isSelected()){
            if(airliners.isEmpty()){
                setUserBoxEmpty();
            }else{
                loadBoxWithAirliners(airliners.getAirlinerList());
            }
        }else if(radioCustomer.isSelected()){
            if(customers.isEmpty()){
                setUserBoxEmpty();
            }else{
                loadBoxWithCustomers(customers.getCustomerList());
            }
        }else{
            
        }      
    }
    
    private void setUserBoxEmpty(){
        this.boxUsers.removeAllItems();
        this.boxUsers.addItem("No Users");
    }
    
    private void loadBoxWithAdmins(ArrayList<Admin> al){
        this.boxUsers.removeAllItems();
        for(Admin a:al){
            this.boxUsers.addItem(a);
        }
    }
    
    private void loadBoxWithAirliners(ArrayList<Airliner> al){
        this.boxUsers.removeAllItems();
        for(Airliner a:al){
            this.boxUsers.addItem(a);
        }
    }
    
    private void loadBoxWithCustomers(ArrayList<Customer> al){
        this.boxUsers.removeAllItems();
        for(Customer a:al){
            this.boxUsers.addItem(a);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupUserType = new javax.swing.ButtonGroup();
        boxUsers = new javax.swing.JComboBox<>();
        txtPswd = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        radioAdmin = new javax.swing.JRadioButton();
        radioAir = new javax.swing.JRadioButton();
        radioCustomer = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JButton();

        boxUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Users" }));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnGroupUserType.add(radioAdmin);
        radioAdmin.setSelected(true);
        radioAdmin.setText("Admin");

        btnGroupUserType.add(radioAir);
        radioAir.setText("Airliner");

        btnGroupUserType.add(radioCustomer);
        radioCustomer.setText("Customer");

        jLabel1.setText("Login as:");

        btnGoBack.setText("<< Go Back");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioAir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioCustomer))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtPswd)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnLogin))
                        .addComponent(boxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGoBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAdmin)
                    .addComponent(radioAir)
                    .addComponent(radioCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin))
                .addContainerGap(80, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        //test
        System.out.println(txtPswd.getPassword());
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) this.rightPanel.getLayout();
        this.rightPanel.remove(this);
        layout.previous(this.rightPanel);
    }//GEN-LAST:event_btnGoBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> boxUsers;
    private javax.swing.JButton btnGoBack;
    private javax.swing.ButtonGroup btnGroupUserType;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton radioAdmin;
    private javax.swing.JRadioButton radioAir;
    private javax.swing.JRadioButton radioCustomer;
    private javax.swing.JPasswordField txtPswd;
    // End of variables declaration//GEN-END:variables
}
