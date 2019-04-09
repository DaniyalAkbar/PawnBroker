package com.example.www.model;

import java.util.Date;

public class payment {

    int PID;
    float amount;
    int TrID;
    String type;
    String pdate;


    public int getPid() { return PID; }

    public void setPid(int PID) { this.PID = PID; }

    public int getTrID() { return TrID; }

    public void setTrID(int trID) { TrID = trID; }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }
}


