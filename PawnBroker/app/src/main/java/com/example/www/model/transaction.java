package com.example.www.model;

import java.util.Date;

public class transaction {
    int TrID;
    float amount;
    String type;
    String tdate;

    public int getTrID() {
        return TrID;
    }

    public void setTrID(int trID) {
        TrID = trID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }
}
