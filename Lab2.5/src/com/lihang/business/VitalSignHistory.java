/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lihang.business;

import java.util.ArrayList;

/**
 *
 * @author lihang
 */
public class VitalSignHistory {

    private ArrayList<VitalSign> vitalSignHistory;

    public VitalSignHistory() {
        this.vitalSignHistory = new ArrayList<>();
    }

    public ArrayList<VitalSign> getVitalSignHistory() {
        return vitalSignHistory;
    }

    public void setVitalSignHistory(ArrayList<VitalSign> vitalSignHistory) {
        this.vitalSignHistory = vitalSignHistory;
    }

    public VitalSign addVitalSign() {
        VitalSign vs = new VitalSign();
        this.vitalSignHistory.add(vs);
        return vs;
    }

    public void deleteVitalSign(VitalSign vs) {
        this.vitalSignHistory.remove(vs);
    }

}
