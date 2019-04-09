package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;

import com.example.www.DB.Db;
import com.example.www.model.users;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;

public class usercrud {
    Context context;

    public usercrud(Context context){
        this.context=context;
    }
    Db d = new Db(context);
    public void add(users u){

        String sql = "insert into users(Fname,Lname,regdate) values('"+u.getFname()+"','"+u.getLname()+"','"+u.getRegDate()+"')";
        d.executequery(sql);
    }
    public void update(users u){
        String sql = "update users set fname='"+u.getFname()+"',lname='"+u.getLname()+"',regdate='"+u.getRegDate()+"'";
        d.executequery(sql);
    }
    public  ArrayList<users> viewall(){
        Cursor c = d.executerawquery("select * from users");
        ArrayList<users> getusers = new ArrayList<>();
        while(c!=null){
            users u = new users();
            u.setUID(c.getInt(c.getColumnIndex("UID")));
            u.setFname(c.getString(c.getColumnIndex("Fname")));
            u.setLname(c.getString(c.getColumnIndex("Lname")));
            u.setRegDate(c.getString(c.getColumnIndex("regdate")));
            getusers.add(u);
        }
        return  getusers;

    }
    public users searchUserByFirstName(String FirstName){
        Cursor c = d.executerawquery("select * from users where Fname='"+FirstName+"'");
        users u = new users();
        while(c!=null){
            u.setUID(c.getInt(c.getColumnIndex("UID")));
            u.setFname(c.getString(c.getColumnIndex("Fname")));
            u.setLname(c.getString(c.getColumnIndex("Lname")));
            u.setRegDate(c.getString(c.getColumnIndex("regdate")));
        }
        return  u;

    }
    public users searchUserByRegDate(String regdate){
        Cursor c = d.executerawquery("select * from users where regdate='"+regdate+"'");
        users u = new users();
        while(c!=null){
            u.setUID(c.getInt(c.getColumnIndex("UID")));
            u.setFname(c.getString(c.getColumnIndex("Fname")));
            u.setLname(c.getString(c.getColumnIndex("Lname")));
            u.setRegDate(c.getString(c.getColumnIndex("regdate")));
        }
        return  u;
    }
}
