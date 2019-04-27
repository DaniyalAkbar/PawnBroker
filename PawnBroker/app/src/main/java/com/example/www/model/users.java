package com.example.www.model;

public class users {
    int UID;



    String Fname;
    String Lname;
    String RegDate;


    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }
    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }
}
