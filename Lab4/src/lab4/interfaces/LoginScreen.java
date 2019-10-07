/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.interfaces;

import lab4.business.Abstract.User;
import lab4.business.Users.Customer;
import lab4.business.Users.Supplier;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author AEDSpring2019
 */
public class LoginScreen extends javax.swing.JPanel {

    /**
     * Creates new form LoginScreen
     */
    List<User> list;
    JPanel panelRight;
    
    public final int loginMode;

    public LoginScreen(JPanel panelRight, List<User> list) {
        this(panelRight,list,User.CUSTOMER);
    }
    
    public LoginScreen(JPanel panelRight, List<User> list, int mode) {
        initComponents();
        this.list = list;
        this.panelRight = panelRight;
        //System.out.println(list.toString());
        loginMode=mode;
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPword = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        comboUser = new javax.swing.JComboBox<>();
        txtTitle = new javax.swing.JLabel();

        btnSubmit.setText("Login");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        comboUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtTitle.setText("Supplier Login Screen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 44, Short.MAX_VALUE)
                                .addComponent(txtTitle)
                                .addGap(0, 44, Short.MAX_VALUE))
                            .addComponent(txtPword))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtTitle)
                .addGap(18, 18, 18)
                .addComponent(comboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String passwd = txtPword.getText();
        if (passwd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password is empty");
            return;
        }
        User u = (User) comboUser.getSelectedItem();
        if (u != null) {
            if (u.getRole().equals("SUPPLIER")) {
                Supplier s = (Supplier) u;
                if (s.verify(passwd)) {
                    grantAccess(u);
                    //login
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect Password", "Unable to log in", JOptionPane.WARNING_MESSAGE);

                    //joptionpane
                }

            }else if (u.getRole().equals("CUSTOMER")) {
                Customer c = (Customer) u;
                if (c.verify(passwd)) {
                    grantAccess(u);
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect Password", "Unable to log in", JOptionPane.WARNING_MESSAGE);

                    //joptionpane
                }
            }else{
                JOptionPane.showMessageDialog(this, "Fatal Error", "Unable to log in", JOptionPane.WARNING_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "User is null", "Unable to log in", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed
    private void grantAccess(User u) {
        SuccessScreen ss = new SuccessScreen(u);
        CardLayout layout = (CardLayout) panelRight.getLayout();
        panelRight.add(ss);
        layout.next(panelRight);
    }

    private void initialize() {
        //text should either be "Supplier Login Screen" OR "Customer Login Screen"
        //Based on the selection
        
        comboUser.removeAllItems();
        if(loginMode==User.CUSTOMER){
            txtTitle.setText("Customer Login Screen");
        }else{
            txtTitle.setText("Supplier Login Screen");
        }
        
        for(User u: list){
            comboUser.addItem(u);
        }
        
        //only customer or suppliers should be listed based on the selection
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<Object> comboUser;
    private javax.swing.JTextField txtPword;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
