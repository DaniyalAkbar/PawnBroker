package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.www.DB.Db;
import com.example.www.model.announcements;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class AnnouncementsCRUD {
    Context context;
    Db d;
    public AnnouncementsCRUD(Context context){
        this.context=context;
        d= new Db(context);
        d.OpenorCreatDB();
    }
    public void addAnnouncement(announcements u){
        String sql = "insert into announcements(announcement, type, adate) values('"+u.getAnnouncement()+"','"+u.getType()+"','"+u.getDate()+"')";
        d.executequery(sql);
    }
    public void update(announcements u){
        String sql = "update announcements set announcement='"+u.getAnnouncement()+"',type='"+u.getType()+"',adate='"+u.getDate()+"' where AID='"+u.getAID()+"' ";
        d.executequery(sql);
    }
    public void delete(int AID){
        String sql = "delete from announcements where AID= "+AID+"; ";
        d.executequery(sql);
    }
    public  ArrayList<String> viewAllAnnouncements(){
        Cursor c = d.executerawquery("select * from announcements");
        ArrayList<String> getAnnouncements = new ArrayList<>();
        c.moveToFirst();
        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
        while(c.moveToNext()){
            String u =null;
            u=String.valueOf(c.getInt(c.getColumnIndex("AID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("announcement"));
            u+="\t";
            u+=c.getString(c.getColumnIndex("adate"));
            u+="\t";
            u+=c.getString(c.getColumnIndex("type"));

            getAnnouncements.add(u);
            Toast.makeText(context, getAnnouncements.get(0).toString(), Toast.LENGTH_SHORT).show();
        }
        return  getAnnouncements;

    }
    public ArrayList<String> searchAnnouncementsByDate(String date){
        Cursor c = d.executerawquery("select * from announcements where adate='"+date+"'");
        ArrayList<String> getAnnouncements = new ArrayList<>();
        while(c.moveToNext()){
            String u =null;
            u=String.valueOf(c.getInt(c.getColumnIndex("AID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("announcement"));
            u+="\t";
            u+=c.getString(c.getColumnIndex("adate"));
            u+="\t";
            u+=c.getString(c.getColumnIndex("type"));

            getAnnouncements.add(u);
        }
        return getAnnouncements;
    }
    public ArrayList<String> searchAnnouncementsByType(String type){
        Cursor c = d.executerawquery("select * from announcements where type='"+type+"'");
        ArrayList<String> getAnnouncements = new ArrayList<>();
        while(c.moveToNext()){
            String u =null;
            u=String.valueOf(c.getInt(c.getColumnIndex("AID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("announcement"));
            u+="\t";
            u+=c.getString(c.getColumnIndex("adate"));
            u+="\t";
            u+=c.getString(c.getColumnIndex("type"));

            getAnnouncements.add(u);
        }
        return getAnnouncements;
    }

}
