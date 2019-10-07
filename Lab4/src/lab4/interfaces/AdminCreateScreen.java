/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4.interfaces;

//import com.sun.prism.paint.Color;
import lab4.business.Abstract.User;
import lab4.business.Users.Admin;
import lab4.business.Users.Customer;
import lab4.business.Users.Supplier;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import lab4.util.Validator;

/**
 *
 * @author Lihang Zhou
 */
public class AdminCreateScreen extends javax.swing.JPanel {

    /**
     * Creates new form AdminScreen
     */
    private final JPanel panelRight;
    private final Admin admin;
    private final Border originalBorder;
    public AdminCreateScreen(JPanel panelRight, Admin admin) {
        initComponents();
        this.panelRight = panelRight;
        this.admin = admin;
        originalBorder=txtUser.getBorder();
    }
    
    private void resetBorders(){
        lblUser.setForeground(Color.BLACK);
        lblPasswd.setForeground(Color.BLACK);
        lblVerify.setForeground(Color.BLACK);
        txtUser.setBorder(originalBorder);
        txtPswd.setBorder(originalBorder);
        txtRePswd.setBorder(originalBorder);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        btnCreate = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPswd = new javax.swing.JTextField();
        txtRePswd = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        lblPasswd = new javax.swing.JLabel();
        lblVerify = new javax.swing.JLabel();
        radioCustomer = new javax.swing.JRadioButton();
        radioSupplier = new javax.swing.JRadioButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblUser.setText("Username");

        lblPasswd.setText("Passcode");

        lblVerify.setText("Verify");

        radioGroup.add(radioCustomer);
        radioCustomer.setSelected(true);
        radioCustomer.setText("Customer");

        radioGroup.add(radioSupplier);
        radioSupplier.setText("Supplier");

        btnBack.setText("<< Go Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setText("Create A New User");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblVerify)
                                .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblPasswd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPswd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRePswd, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(radioCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreate))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPasswd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRePswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVerify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(radioCustomer)
                    .addComponent(btnBack)
                    .addComponent(radioSupplier))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        resetBorders();
        if (!Validator.IsValidUsername(txtUser.getText())) {
            JOptionPane.showMessageDialog(this, "Username Invalid.", "ERROR", JOptionPane.WARNING_MESSAGE);
            txtUser.setBorder(BorderFactory.createLineBorder(Color.RED));
            lblUser.setForeground(Color.red);
            return;
        }
        if (!Validator.IsValidPassword(txtPswd.getText())) {
            JOptionPane.showMessageDialog(this, "Passcode Invalid.", "ERROR", JOptionPane.WARNING_MESSAGE);
            txtPswd.setBorder(BorderFactory.createLineBorder(Color.RED));
            lblPasswd.setForeground(Color.red);
            txtRePswd.setBorder(BorderFactory.createLineBorder(Color.RED));
            lblVerify.setForeground(Color.red);
            return;
        }
        if (!Validator.IsSamePassword(txtPswd.getText(), txtRePswd.getText())) {
            JOptionPane.showMessageDialog(this, "Passcode is not the same in two fields.", "ERROR", JOptionPane.WARNING_MESSAGE);
            txtPswd.setBorder(BorderFactory.createLineBorder(Color.RED));
            lblPasswd.setForeground(Color.red);
            txtRePswd.setBorder(BorderFactory.createLineBorder(Color.RED));
            lblVerify.setForeground(Color.red);
            return;
        }
        User u;
        if (radioCustomer.isSelected()) {
            u = new Customer(txtUser.getText(), txtPswd.getText());
            admin.custDir.getCustomerList().add(u);
        } else {
            u = new Supplier(txtUser.getText(), txtPswd.getText());
            admin.suppDir.getSupplierList().add(u);
        }
        JOptionPane.showMessageDialog(this, "Succeed to create.", "OKAY", JOptionPane.INFORMATION_MESSAGE);
        this.radioCustomer.setSelected(true);
        this.txtPswd.setText("");
        this.txtUser.setText("");
        this.txtRePswd.setText("");
        this.resetBorders();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        CardLayout layout = (CardLayout) panelRight.getLayout();
        panelRight.remove(this);
        for (Component comp:panelRight.getComponents()){
            if(comp instanceof AdminMainScreen){
                ((AdminMainScreen) comp).populate();
            }
        }
        layout.previous(panelRight);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblPasswd;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblVerify;
    private javax.swing.JRadioButton radioCustomer;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JRadioButton radioSupplier;
    private javax.swing.JTextField txtPswd;
    private javax.swing.JTextField txtRePswd;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
