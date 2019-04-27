package com.example.www.model;

import java.util.Date;

public class announcements {

    int AID;
    String announcement;
    String type;
    String date;

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public int getAID() {
        return AID;
    }

    public void setAID(int AID) {
        this.AID = AID;
    }

}
