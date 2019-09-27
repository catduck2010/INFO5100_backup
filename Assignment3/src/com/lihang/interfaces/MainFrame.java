/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lihang.interfaces;

import com.lihang.business.*;
import com.lihang.util.Haversine;
import com.lihang.util.Validator;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lihang
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private CarList carList;

    public MainFrame() {
        initComponents();
        //this.setTitle("Uber Cars Management Emulator");
        carList = new CarList();
        this.bottomPanel.setLayout(new CardLayout());
        txtSearch.addFocusListener(new JTextFieldHintListener(txtSearch,
                "Enter Keywords..."));
        setLastUpdate();
        setCarNums();

        this.boxFilter.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println(boxFilter.getSelectedIndex());
                    int index = boxFilter.getSelectedIndex() + 1;
                    if (index != 0 && index != 2
                            && index != 3 && index != 7) {
                        txtSearch.setEnabled(true);
                    } else {
                        txtSearch.setEnabled(false);
                    }
                }
            }
        });
        this.boxFilter.setSelectedIndex(-1);
    }

    public void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblCars.getModel();
        dtm.setRowCount(0);
        for (CarInfo car : carList.getCarList()) {
            Object[] row = new Object[6];

            row[0] = car;
            row[1] = car.getFirstName() + " " + car.getLastName();
            row[2] = car.getManufacturer();
            row[3] = car.getModelNum();
            row[4] = car.getSeats();
            row[5] = car.getCity();

            dtm.addRow(row);
        }
        setLastUpdate();
        setCarNums();
        //((JTextFieldHintListener)acListener).changeHintText("Enter Coordinate(a,b)...");
    }

    public CarList getCarList() {
        return carList;
    }

    private void setLastUpdate() {
        dateLabel.setText(carList.getDateLabelString());
    }

    public JPanel getBottomPanel() {
        return this.bottomPanel;
    }

    public void setCarNums() {
        this.lblAvails.setText("Available: " + carList.getAvailableNum());
        this.lblUnavails.setText("Unavailable: " + carList.getUnavailableNum());
    }

    private void goBackHome() {
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        for (int i = 1; i < bottomPanel.getComponentCount(); i++) {
            bottomPanel.remove(i);
        }
        layout.first(bottomPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        panelLeft = new javax.swing.JPanel();
        btnLeftFind = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        btnLeftAdd = new javax.swing.JButton();
        lblAvails = new javax.swing.JLabel();
        lblUnavails = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        panelCarList = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        boxFilter = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCars = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Uber Cars Management Emulator");

        btnLeftFind.setText("Manufacturers");
        btnLeftFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftFindActionPerformed(evt);
            }
        });

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Last Update");

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Date");

        btnLeftAdd.setText("Add A Car");
        btnLeftAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftAddActionPerformed(evt);
            }
        });

        lblAvails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvails.setText("Available: 000");

        lblUnavails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUnavails.setText("Unavailable: 000");

        javax.swing.GroupLayout panelLeftLayout = new javax.swing.GroupLayout(panelLeft);
        panelLeft.setLayout(panelLeftLayout);
        panelLeftLayout.setHorizontalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLeftLayout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLeftAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnLeftFind, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(lblAvails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUnavails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLeftLayout.setVerticalGroup(
            panelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLeftAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLeftFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAvails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUnavails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                .addComponent(btnHome)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(panelLeft);

        jSplitPane2.setBorder(null);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        boxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Find A Car", "Available", "Unavailable", "City", "Made Year", "Manufacturer", "Maint. Expired", "Model #", "S/N", "Seat # Between", "Test" }));

        tblCars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "✓", "Driver", "Brand", "Car Model", "Seats", "Current Location"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCars);
        if (tblCars.getColumnModel().getColumnCount() > 0) {
            tblCars.getColumnModel().getColumn(0).setMinWidth(15);
            tblCars.getColumnModel().getColumn(0).setMaxWidth(15);
            tblCars.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        btnReset.setText("Reset Table");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnDetails.setText("View Details");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCarListLayout = new javax.swing.GroupLayout(panelCarList);
        panelCarList.setLayout(panelCarListLayout);
        panelCarListLayout.setHorizontalGroup(
            panelCarListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCarListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addGroup(panelCarListLayout.createSequentialGroup()
                        .addComponent(boxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCarListLayout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelCarListLayout.setVerticalGroup(
            panelCarListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCarListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCarListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnDelete)
                    .addComponent(btnDetails))
                .addContainerGap())
        );

        jSplitPane2.setTopComponent(panelCarList);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Click Buttons above or on the left to Start");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(bottomPanel);

        jSplitPane1.setRightComponent(jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLeftAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftAddActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        AddViewEditCarPanel panel = new AddViewEditCarPanel(this, carList);
        for (int i = 1; i < bottomPanel.getComponentCount(); i++) {
            bottomPanel.remove(i);
        }
        this.bottomPanel.add("AddCarJPanel", panel);
        layout.next(bottomPanel);
    }//GEN-LAST:event_btnLeftAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCars.getSelectedRow();
        if (selectedRow >= 0) {
            for (int i = 1; i < bottomPanel.getComponentCount(); i++) {
                bottomPanel.remove(i);
            }
            CarInfo car = (CarInfo) tblCars.getValueAt(selectedRow, 0);
            AddViewEditCarPanel panel = new AddViewEditCarPanel(this, car, AddViewEditCarPanel.VIEW_EDIT_OPTION);
            this.bottomPanel.add("ViewEditCarJPanel", panel);
            CardLayout layout = (CardLayout) bottomPanel.getLayout();
            layout.next(bottomPanel);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row", "No row selected", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblCars.getSelectedRow();
        if (selectedRow >= 0) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure to remove this car?", "WARNING",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                CarInfo car = (CarInfo) tblCars.getValueAt(selectedRow, 0);

                carList.deleteCar(car);
                goBackHome();
                loadTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row", "No row selected", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLeftFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftFindActionPerformed
        // TODO add your handling code here:
        CardLayout layout = (CardLayout) bottomPanel.getLayout();
        for (int i = 1; i < bottomPanel.getComponentCount(); i++) {
            //if(layout.)
            bottomPanel.remove(i);
        }
        ManufacturerPanel panel = new ManufacturerPanel(this, carList);
        this.bottomPanel.add("ManufacturerJPanel", panel);

        layout.next(bottomPanel);
    }//GEN-LAST:event_btnLeftFindActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        goBackHome();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        /*
        0 --
        1 Find A Car
        2 Available
        3 Not Available
        4 City
        5 Made Year
        6 Manufacturer
        7 Maint. Expired
        8 Model #
        9 S/N
        10 Seat # Between
         */
        DefaultTableModel dtm = (DefaultTableModel) tblCars.getModel();
        Date date;
        int index = boxFilter.getSelectedIndex() + 1;
        Pattern pattern;
        String txt = null;
        if (txtSearch.getText().trim().equals("Enter Keywords...")) {
            txt = "";
        } else {
            txt = txtSearch.getText().trim();
        }
        //int noInput[] = {2, 3, 7};
        if (txt.equals("") && index != 0
                && index != 2 && index != 3 && index != 7) {
            JOptionPane.showMessageDialog(this, "Please Enter Keywords.",
                    "NOTICE", JOptionPane.INFORMATION_MESSAGE);
        }
        switch (index) {
            case 0:
                //--
                JOptionPane.showMessageDialog(this, "Please choose a filter.",
                        "NOTICE", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                //find a car
                //txt = txtSearch.getText();
                if (Validator.IsLatLon(txt)) {
                    String[] ab = txt.split(",");
                    double lat = Double.parseDouble(ab[0]);
                    double lon = Double.parseDouble(ab[1].trim());
                    CarInfo nearest = null;
                    double distance = Double.MAX_VALUE;
                    for (CarInfo car : carList.getCarList()) {
                        if (car.isAvailable()) {
                            double calc = Haversine.distance(
                                    lat, car.getLatitude(),
                                    lon, car.getLongtitude(),
                                    0.0, 0.0);
                            if (calc < distance) {
                                distance = calc;
                                nearest = car;
                            }
                        }
                    }
                    //view the found car
                    if (nearest != null) {
                        CardLayout layout = (CardLayout) bottomPanel.getLayout();
                        for (int i = 1; i < bottomPanel.getComponentCount(); i++) {
                            bottomPanel.remove(i);
                        }
                        layout.first(bottomPanel);
                        AddViewEditCarPanel panel = new AddViewEditCarPanel(
                                this, nearest,
                                AddViewEditCarPanel.VIEW_ONLY_OPTION);
                        this.bottomPanel.add("ViewNearestCarJPanel", panel);
                        layout.next(bottomPanel);
                    } else {
                        JOptionPane.showMessageDialog(this, "NO car found.",
                                "NOTICE", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Correct input format: Latitude, Longitude",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 2:
                //Available
                for (int i = tblCars.getRowCount() - 1; i >= 0; i--) {
                    CarInfo car = (CarInfo) tblCars.getValueAt(i, 0);
                    if (!car.isAvailable()) {
                        dtm.removeRow(i);
                    }
                }
                break;
            case 3:
                //unavailable
                for (int i = tblCars.getRowCount() - 1; i >= 0; i--) {
                    CarInfo car = (CarInfo) tblCars.getValueAt(i, 0);
                    if (car.isAvailable()) {
                        dtm.removeRow(i);
                    }
                }
                break;
            case 4:
                //city
                pattern = Pattern.compile(txt);
                for (int i = tblCars.getRowCount() - 1; i >= 0; i--) {
                    CarInfo car = (CarInfo) tblCars.getValueAt(i, 0);
                    Matcher matcher = pattern.matcher(car.getCity());
                    if (!matcher.matches()) {
                        dtm.removeRow(i);
                    }
                }
                break;
            case 5:
                //made year
                txt = txtSearch.getText();
                if (Validator.IsYear(txt)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                    int year = Integer.parseInt(txt);
                    for (int i = tblCars.getRowCount() - 1; i >= 0; i--) {
                        CarInfo car = (CarInfo) tblCars.getValueAt(i, 0);
                        Date madeDate = car.getProductionDate();
                        if (Integer.parseInt(sdf.format(madeDate)) != year) {
                            dtm.removeRow(i);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a correct year.",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case 6:
                //manufacturer
                pattern = Pattern.compile(txt);
                for (int i = tblCars.getRowCount() - 1; i >= 0; i--) {
                    CarInfo car = (CarInfo) tblCars.getValueAt(i, 0);
                    Matcher matcher = pattern.matcher(car.getManufacturer());
                    if (!matcher.matches()) {
                        dtm.removeRow(i);
                    }
                }
                break;
            case 7:
                //maintanance expired
                date = new Date();
                for (int i = tblCars.getRowCount() - 1; i >= 0; i--) {
                    CarInfo car = (CarInfo) tblCars.getValueAt(i, 0);
                    if (!car.getLastMaintenance().before(date)) {
                        dtm.removeRow(i);
                    }
                }
                break;
            case 8:
                //model
                pattern = Pattern.compile(txt);
                for (int i = tblCars.getRowCount() - 1; i >= 0; i--) {
                    CarInfo car = (CarInfo) tblCars.getValueAt(i, 0);
                    Matcher matcher = pattern.matcher(car.getModelNum());
                    if (!matcher.matches()) {
                        dtm.removeRow(i);
                    }
                }
                break;
            case 9:
                //S\N
                pattern = Pattern.compile(txt);
                for (int i = tblCars.getRowCount() - 1; i >= 0; i--) {
                    CarInfo car = (CarInfo) tblCars.getValueAt(i, 0);
                    Matcher matcher = pattern.matcher(car.getSN());
                    if (!matcher.matches()) {
                        dtm.removeRow(i);
                    }
                }
                break;

            case 10:
                //seat between
                //txt = txtSearch.getText();
                if (Validator.IsBetweenNums(txt)) {
                    String[] ab = txt.split(",");
                    int a = Integer.parseInt(ab[0]);
                    int b = Integer.parseInt(ab[1].trim());
                    if (a > b) {
                        int temp = a;
                        a = b;
                        b = temp;
                    }
                    for (int i = tblCars.getRowCount() - 1; i >= 0; i--) {
                        CarInfo car = (CarInfo) tblCars.getValueAt(i, 0);
                        if (car.getSeats() < a || car.getSeats() > b) {
                            dtm.removeRow(i);
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Correct input format: Left #, Right #",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                break;
            default:
                //for test
                System.out.println("Input: " + txt);
                System.out.println("isLatLon: " + Validator.IsLatLon(txt));
                System.out.println("isYear: " + Validator.IsYear(txt));
                System.out.println("isBetweenNums: " + Validator.IsBetweenNums(txt));
                break;
        }

        //JOptionPane.showMessageDialog(this, "There is no result. Reset the table?", "No Result", JOptionPane.YES_NO_OPTION);
        if (!carList.isEmpty() && dtm.getRowCount() == 0) {
            if (JOptionPane.showConfirmDialog(this, "There are no results here. Reset the table?", "No Results",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                // yes option
                loadTable();
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Mac OS X look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Mac OS X".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JComboBox<String> boxFilter;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLeftAdd;
    private javax.swing.JButton btnLeftFind;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblAvails;
    private javax.swing.JLabel lblUnavails;
    private javax.swing.JPanel panelCarList;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JTable tblCars;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public class JTextFieldHintListener implements FocusListener {

        private String hintText;
        private JTextField textField;

        public JTextFieldHintListener(JTextField jTextField, String hintText) {
            this.textField = jTextField;
            this.hintText = hintText;
            jTextField.setText(hintText);  //Show directly by default
            jTextField.setForeground(Color.GRAY);
        }

        public void changeHintText(String text) {
            this.hintText = text;
        }

        @Override
        public void focusGained(FocusEvent e) {
            //clear showing contents when gained focus
            String temp = textField.getText();
            if (temp.equals(hintText)) {
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }

        }

        @Override
        public void focusLost(FocusEvent e) {
            //show contents when focus lost
            String temp = textField.getText();
            if (temp.equals("")) {
                textField.setForeground(Color.GRAY);
                textField.setText(hintText);
            }

        }

    }
}
