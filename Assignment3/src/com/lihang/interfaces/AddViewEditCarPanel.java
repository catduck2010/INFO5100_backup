/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lihang.interfaces;

import com.lihang.business.CarInfo;
import com.lihang.business.CarList;
import com.lihang.util.Validator;
import java.awt.CardLayout;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author lihang
 */
public class AddViewEditCarPanel extends JPanel {

    /**
     * Creates new form AddCarPanel
     */
    public static final int ADD_OPTION = 1;
    public static final int VIEW_EDIT_OPTION = 2;
    public static final int VIEW_ONLY_OPTION = 3;

    private final int mode;
    private boolean isEditing;
    private final JPanel bottomPanel;
    private final MainFrame mainFrame;
    private CarList carList = null;
    private CarInfo carInfo = null;

    public AddViewEditCarPanel(MainFrame frame, CarList list) {
        //Add mode
        initComponents();
        setBorderOfDateButtons();
        this.mainFrame = frame;
        this.bottomPanel = frame.getBottomPanel();
        this.mode = AddViewEditCarPanel.ADD_OPTION;
        setTabTitles();
        this.carList = list;
    }

    public AddViewEditCarPanel(MainFrame frame, CarInfo car, int md) {
        //Edit mode
        isEditing = false;
        initComponents();
        setBorderOfDateButtons();
        switchEdit();
        setLabels();
        this.mainFrame = frame;
        this.bottomPanel = frame.getBottomPanel();
        this.mode = md;
        if (mode == AddViewEditCarPanel.VIEW_ONLY_OPTION) {
            this.btnRestore.setEnabled(false);
            this.btnSuper.setEnabled(false);
        }
        setTabTitles();
        this.carInfo = car;

        fillCarInfo();
        switchEdit();
    }

    public boolean checkEmptyAndInvalid() {
        boolean emptyExists = false
                || Validator.IsEmpty(this.txtFirstName.getText().trim())
                || Validator.IsEmpty(this.txtLastName.getText().trim())
                || Validator.IsEmpty(this.txtCity.getText().trim())
                || Validator.IsEmpty(this.txtModelNum.getText().trim())
                || Validator.IsEmpty(this.txtBrand.getText().trim())
                || Validator.IsEmpty(this.txtSN.getText().trim())
                || Validator.IsEmpty(this.txtSeats.getText().trim())
                || Validator.IsEmpty(this.txtLat.getText().trim())
                || Validator.IsEmpty(this.txtLon.getText().trim());
        if (emptyExists) {
            JOptionPane.showMessageDialog(this, "One or more input fields cannot be empty.",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            return true;//not ok to continue
        }
        boolean valid = Validator.IsLatLon(this.txtLat.getText().trim()
                + "," + this.txtLon.getText().trim());
        if (!valid) {
            JOptionPane.showMessageDialog(this, "Invalid Latitude or/and Longitude.",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        valid = Validator.IsPositiveInt(this.txtSeats.getText().trim());
        if (!valid) {
            JOptionPane.showMessageDialog(this, "Invalid input on seats.",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        return false;//OKay to continue
    }

    private void setBorderOfDateButtons() {
        //make better look on macOS look and feel
        Border aqua = txtBrand.getBorder();
        dateBtnProducted.setBorder(aqua);
        dateBtnMaintainedUntil.setBorder(aqua);
    }

    private void goHome() {
        bottomPanel.remove(this);
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        layout.previous(bottomPanel);
    }

    private void setTabTitles() {
        tabbedPane.setTitleAt(0, "Driver");
        tabbedPane.setTitleAt(1, "Car Basic");
        tabbedPane.setTitleAt(2, "Current Location");
    }

    private void setLabels() {
        if (mode == AddViewEditCarPanel.ADD_OPTION) {
            this.btnSuper.setText("Add");
        } else {
            this.titleLabel.setText("View Details");
            if (isEditing) {
                this.btnSuper.setText("Save");
            } else {
                this.btnSuper.setText("Edit");
            }
        }
    }

    private void switchEdit() {
        if (mode != AddViewEditCarPanel.ADD_OPTION) {

            this.txtBrand.setEditable(isEditing);
            this.txtCity.setEditable(isEditing);
            this.txtFirstName.setEditable(isEditing);
            this.txtLastName.setEditable(isEditing);
            this.txtLat.setEditable(isEditing);
            this.txtLon.setEditable(isEditing);
            this.txtMidName.setEditable(isEditing);
            this.txtModelNum.setEditable(isEditing);
            this.txtSN.setEditable(isEditing);
            this.txtSeats.setEditable(isEditing);

            this.boxAvail.setEnabled(isEditing);
            this.dateBtnMaintainedUntil.setEnabled(isEditing);
            this.dateBtnProducted.setEnabled(false);
        }
    }

    private void resetInput() {
        if (mode == AddViewEditCarPanel.ADD_OPTION) {
            this.txtBrand.setText("");
            this.txtCity.setText("");
            this.txtFirstName.setText("");
            this.txtLastName.setText("");
            this.txtLat.setText("0.0");
            this.txtLon.setText("0.0");
            this.txtMidName.setText("");
            this.txtModelNum.setText("");
            this.txtSN.setText("");
            this.txtSeats.setText("4");

            this.boxAvail.setSelected(true);
            this.dateBtnMaintainedUntil.setToday();
            this.dateBtnProducted.setToday();
        } else {
            if (isEditing) {
                fillCarInfo();
            }
        }
    }

    private void fillCarInfo() {
        DecimalFormat df = new DecimalFormat("#0.0000000");
        this.txtBrand.setText(carInfo.getManufacturer());
        this.txtCity.setText(carInfo.getCity());
        this.txtFirstName.setText(carInfo.getFirstName());
        this.txtLastName.setText(carInfo.getLastName());
        this.txtLat.setText(df.format(carInfo.getLatitude()));
        this.txtLon.setText(df.format(carInfo.getLongitude()));
        this.txtMidName.setText(carInfo.getMiddleName());
        this.txtModelNum.setText(carInfo.getModelNum());
        this.txtSN.setText(carInfo.getSN());
        this.txtSeats.setText("" + carInfo.getSeats());

        this.boxAvail.setSelected(carInfo.isAvailable());
        this.dateBtnMaintainedUntil.setDate(carInfo.getLastMaintenance());
        this.dateBtnProducted.setDate(carInfo.getProductionDate());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        tabDriverInfoPanel = new javax.swing.JPanel();
        txtFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMidName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        tabCarBasicPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        txtSN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtModelNum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSeats = new javax.swing.JTextField();
        dateBtnMaintainedUntil = new com.lihang.util.DateChooserJButton();
        jLabel11 = new javax.swing.JLabel();
        dateBtnProducted = new com.lihang.util.DateChooserJButton();
        boxAvail = new javax.swing.JCheckBox();
        tabCarDetailPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtLon = new javax.swing.JTextField();
        txtLat = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnSuper = new javax.swing.JButton();
        btnRestore = new javax.swing.JButton();
        btnGoHome = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        jLabel2.setText("First Name");

        jLabel3.setText("Middle Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("City");

        javax.swing.GroupLayout tabDriverInfoPanelLayout = new javax.swing.GroupLayout(tabDriverInfoPanel);
        tabDriverInfoPanel.setLayout(tabDriverInfoPanelLayout);
        tabDriverInfoPanelLayout.setHorizontalGroup(
            tabDriverInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDriverInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDriverInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(tabDriverInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFirstName)
                    .addComponent(txtMidName, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addComponent(txtLastName)
                    .addComponent(txtCity))
                .addContainerGap())
        );
        tabDriverInfoPanelLayout.setVerticalGroup(
            tabDriverInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDriverInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDriverInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDriverInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMidName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDriverInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDriverInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        tabbedPane.addTab("tab1", tabDriverInfoPanel);

        jLabel6.setText("Car Model");

        jLabel7.setText("Car S/N");

        jLabel8.setText("Manufacturer");

        jLabel9.setText("Production Date");

        jLabel10.setText("Seats");

        txtSeats.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSeats.setText("4");

        dateBtnMaintainedUntil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dateBtnMaintainedUntil.setPreferredSize(new java.awt.Dimension(78, 26));

        jLabel11.setText("Maintenance Vaild Until");

        dateBtnProducted.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dateBtnProducted.setPreferredSize(new java.awt.Dimension(78, 26));

        boxAvail.setSelected(true);
        boxAvail.setText("Available");

        javax.swing.GroupLayout tabCarBasicPanelLayout = new javax.swing.GroupLayout(tabCarBasicPanel);
        tabCarBasicPanel.setLayout(tabCarBasicPanelLayout);
        tabCarBasicPanelLayout.setHorizontalGroup(
            tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCarBasicPanelLayout.createSequentialGroup()
                .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabCarBasicPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSN, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtModelNum)
                            .addComponent(txtBrand, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(tabCarBasicPanelLayout.createSequentialGroup()
                        .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxAvail)
                            .addGroup(tabCarBasicPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 50, Short.MAX_VALUE)
                        .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateBtnMaintainedUntil, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(dateBtnProducted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        tabCarBasicPanelLayout.setVerticalGroup(
            tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCarBasicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(boxAvail))
                    .addComponent(dateBtnMaintainedUntil, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(dateBtnProducted, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCarBasicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(102, 102, 102))
        );

        tabbedPane.addTab("tab2", tabCarBasicPanel);

        jLabel12.setText("Latitude");

        jLabel13.setText("Longitude");

        txtLon.setText("0.0");

        txtLat.setText("0.0");

        jLabel14.setText("° ");

        jLabel15.setText("° ");

        javax.swing.GroupLayout tabCarDetailPanelLayout = new javax.swing.GroupLayout(tabCarDetailPanel);
        tabCarDetailPanel.setLayout(tabCarDetailPanelLayout);
        tabCarDetailPanelLayout.setHorizontalGroup(
            tabCarDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabCarDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLon, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tabCarDetailPanelLayout.setVerticalGroup(
            tabCarDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCarDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabCarDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(txtLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        tabbedPane.addTab("tab3", tabCarDetailPanel);

        btnSuper.setText("OK");
        btnSuper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuperActionPerformed(evt);
            }
        });

        btnRestore.setText("Restore Input");
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });

        btnGoHome.setText("⌂ Home");
        btnGoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoHomeActionPerformed(evt);
            }
        });

        titleLabel.setText("Add Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGoHome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuper))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 225, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuper)
                    .addComponent(btnRestore)
                    .addComponent(btnGoHome))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuperActionPerformed
        // TODO add your handling code here:
        if (checkEmptyAndInvalid()) {
            return;
        }
        if (mode == AddViewEditCarPanel.ADD_OPTION) {
            CarInfo car = carList.addCar();

            car.setCity(this.txtCity.getText());
            car.setFirstName(this.txtFirstName.getText());
            //car.setAvailable(this.boxAvail.isSelected());
            car.setLastName(this.txtLastName.getText());
            car.setMiddleName(this.txtMidName.getText());
            car.setSeats(Integer.parseInt(this.txtSeats.getText()));
            car.setManufacturer(this.txtBrand.getText());
            car.setSN(this.txtSN.getText());
            car.setModelNum(this.txtModelNum.getText());
            car.setLatitude(Double.parseDouble(this.txtLat.getText()));
            car.setLongitude(Double.parseDouble(this.txtLon.getText()));

            car.setAvailable(this.boxAvail.isSelected());
            System.out.println(this.boxAvail.isSelected());
            //boxAvail.is

            car.setLastMaintenance(this.dateBtnMaintainedUntil.getDate());
            car.setProductionDate(this.dateBtnProducted.getDate());

            carList.addAvailibility(car.isAvailable());

            JOptionPane.showMessageDialog(this, "Car information added.",
                    "Success", JOptionPane.INFORMATION_MESSAGE);

            resetInput();
            mainFrame.loadTable();
        } else if (mode == AddViewEditCarPanel.VIEW_EDIT_OPTION) {
            if (!isEditing) {
                isEditing = true;
                switchEdit();
                setLabels();
            } else {
                isEditing = false;

                CarInfo car = carInfo;

                car.setCity(this.txtCity.getText());
                car.setFirstName(this.txtFirstName.getText());
                car.setAvailable(this.boxAvail.isSelected());
                car.setLastName(this.txtLastName.getText());
                car.setMiddleName(this.txtMidName.getText());
                car.setSeats(Integer.parseInt(this.txtSeats.getText()));
                car.setManufacturer(this.txtBrand.getText());
                car.setSN(this.txtSN.getText());
                car.setModelNum(this.txtModelNum.getText());
                car.setLatitude(Double.parseDouble(this.txtLat.getText()));
                car.setLongitude(Double.parseDouble(this.txtLon.getText()));

                car.setAvailable(this.boxAvail.isSelected());

                car.setLastMaintenance(this.dateBtnMaintainedUntil.getDate());
                //car.setProductionDate(this.dateBtnProducted.getDate());
                mainFrame.getCarList().updateListInfo();
                mainFrame.getCarList().updateAvailableCars();
                JOptionPane.showMessageDialog(this, "Car information changed.",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

                switchEdit();
                setLabels();

                mainFrame.loadTable();
            }
        }

    }//GEN-LAST:event_btnSuperActionPerformed

    private void btnGoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoHomeActionPerformed
        // TODO add your handling code here:
        goHome();
    }//GEN-LAST:event_btnGoHomeActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        // TODO add your handling code here:
        resetInput();
    }//GEN-LAST:event_btnRestoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxAvail;
    private javax.swing.JButton btnGoHome;
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnSuper;
    private com.lihang.util.DateChooserJButton dateBtnMaintainedUntil;
    private com.lihang.util.DateChooserJButton dateBtnProducted;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel tabCarBasicPanel;
    private javax.swing.JPanel tabCarDetailPanel;
    private javax.swing.JPanel tabDriverInfoPanel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLat;
    private javax.swing.JTextField txtLon;
    private javax.swing.JTextField txtMidName;
    private javax.swing.JTextField txtModelNum;
    private javax.swing.JTextField txtSN;
    private javax.swing.JTextField txtSeats;
    // End of variables declaration//GEN-END:variables
}
