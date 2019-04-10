package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.www.DB.Db;
import com.example.www.model.announcements;
import com.example.www.model.users;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.Date;


public class AnnouncementsCRUD {
    Context context;

    public AnnouncementsCRUD(Context context){
        this.context=context;
    }
    Db d = new Db(context);
    public void addAnnouncement(announcements u){
        String sql = "insert into announcement(announcement, type, date) values('"+u.getAnnouncement()+"','"+u.getType()+"','"+u.getDate()+"')";
        d.executequery(sql);
    }
    public void update(announcements u){
        String sql = "update announcements set announcements='"+u.getAnnouncement()+"',type='"+u.getType()+"',date='"+u.getDate()+"' where AID='"+u.getAID()+"' ";
        d.executequery(sql);
    }
    public void delete(int AID){
        String sql = "delete from announcements where AID= "+AID+"; ";
        d.executequery(sql);
    }
    public  ArrayList<announcements> viewAllAnnouncements(){
        Cursor c = d.executerawquery("select * from announcements");
        ArrayList<announcements> getAnnouncements = new ArrayList<>();
        while(c.moveToNext()){
            announcements u = new announcements();
            u.setAID(c.getInt(c.getColumnIndex("AID")));
            u.setAnnouncement(c.getString(c.getColumnIndex("announcements")));
            u.setDate(c.getString(c.getColumnIndex("date")));
            u.setType(c.getString(c.getColumnIndex("type")));
            getAnnouncements.add(u);
        }
        return  getAnnouncements;

    }
    public announcements searchAnnouncementsByDate(String date){
        Cursor c = d.executerawquery("select * from announcements where date='"+date+"'");
        announcements u = new announcements();
        while(c.moveToNext()){
            u.setAID((c.getInt(c.getColumnIndex("UID"))));
            u.setAnnouncement(c.getString(c.getColumnIndex("announcements")));
            u.setType(c.getString(c.getColumnIndex("type")));
            u.setDate(c.getString(c.getColumnIndex("date")));
        }
        return  u;
    }
    public announcements searchAnnouncementsByType(String type){
        Cursor c = d.executerawquery("select * from announcements where type='"+type+"'");
        announcements u = new announcements();
        while(c.moveToNext()){
            u.setAID((c.getInt(c.getColumnIndex("UID"))));
            u.setAnnouncement(c.getString(c.getColumnIndex("announcements")));
            u.setType(c.getString(c.getColumnIndex("type")));
            u.setDate(c.getString(c.getColumnIndex("date")));
        }
        return  u;
    }

}
