package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.www.DB.Db;
import com.example.www.model.users;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UserCRUD {
    Context context;
    Db d;

    public UserCRUD(Context context){
        this.context=context;
         d= new Db(context);
         d.OpenorCreatDB();
    }


    public void add(users u){

        String sql = "insert into users(Fname, Lname, regdate) values('"+u.getFname()+"','"+u.getLname()+"','"+u.getRegDate()+"')";
        d.executequery(sql);
    }
    public void deleteByID(int ID){

        String sql = "delete from users where UID="+ID+"";
        d.executequery(sql);
    }
    public void update(users u){
        String sql = "update users set fname='"+u.getFname()+"',lname='"+u.getLname()+"',regdate='"+u.getRegDate()+"' where UID='"+u.getUID()+"' ";
        d.executequery(sql);
    }
    public  ArrayList<String> viewall(){
        Cursor c = d.executerawquery("select * from users");
        ArrayList<String> getusers = new ArrayList<>();
        c.moveToFirst();
        while(c.moveToNext()){
            String u;
            u=String.valueOf(c.getInt(c.getColumnIndex("UID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("Fname"));
            u+=" ";
            u+=c.getString(c.getColumnIndex("Lname"));
            u+="\t";
                u+=c.getString(c.getColumnIndex("regdate"));

            getusers.add(u);

        }
        return  getusers;

    }
    public users searchUserByFirstName(String FirstName){
        Cursor c = d.executerawquery("select * from users where Fname='"+FirstName+"'");
        users u = new users();
        while(c.moveToNext()){
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
        while(c.moveToNext()){
            u.setUID(c.getInt(c.getColumnIndex("UID")));
            u.setFname(c.getString(c.getColumnIndex("Fname")));
            u.setLname(c.getString(c.getColumnIndex("Lname")));
            u.setRegDate(c.getString(c.getColumnIndex("regdate")));
        }
        return  u;
    }
}
