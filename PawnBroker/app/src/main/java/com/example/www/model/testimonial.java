package com.example.www.model;

import java.util.Date;

public class testimonial {
    int TID;
    String testimonial;
    int UID;
    String adate;

    public int getTid() {
        return TID;
    }

    public void setTid(int tid) {
        this.TID = tid;
    }

    public String getTestimonial() {
        return testimonial;
    }

    public void setTestimonial(String testimonial) {
        this.testimonial = testimonial;
    }

    public int getUid() {
        return UID;
    }

    public void setUid(int uid) {
        this.UID = uid;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }
}
