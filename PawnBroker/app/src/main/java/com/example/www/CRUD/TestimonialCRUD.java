package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;

import com.example.www.DB.Db;
import com.example.www.model.testimonial;

import java.util.ArrayList;

public class TestimonialCRUD {

    Context context;
    public TestimonialCRUD(Context context){
        this.context=context;
    }
    Db d = new Db(context);
    public void addTestimonial(testimonial u){
        String sql = "insert into testimonial(testimonial, uid, adate) values('"+u.getTestimonial()+"','"+u.getUid()+"','"+u.getAdate()+"')";
        d.executequery(sql);
    }
    public void updateTestimonial(testimonial u){
        String sql = "update testimonial set testimonial='"+u.getTestimonial()+"',UID='"+u.getUid()+"',adate='"+u.getAdate()+"' where TID='"+u.getTid()+"' ";
        d.executequery(sql);
    }
    public void deleteTestimonial(int TID){
        String sql = "delete from testimonial where TID= "+TID+"; ";
        d.executequery(sql);
    }

    public ArrayList<testimonial> viewAllTestimonial(){
        Cursor c = d.executerawquery("select * from testimonial");
        ArrayList<testimonial> getTestimonial = new ArrayList<>();
        while(c.moveToNext()){
            testimonial u = new testimonial();
            u.setTid(c.getInt(c.getColumnIndex("TID")));
            u.setAdate(c.getString(c.getColumnIndex("adate")));
            u.setTestimonial(c.getString(c.getColumnIndex("testimonial")));
            u.setUid(c.getInt(c.getColumnIndex("UID")));
            getTestimonial.add(u);
        }
        return  getTestimonial;
    }
    public testimonial searchTestimonialByDate(String date){
        Cursor c = d.executerawquery("select * from testimonial where adate='"+date+"'");
        testimonial u = new testimonial();
        while(c.moveToNext()){
            u.setTid(c.getInt(c.getColumnIndex("TID")));
            u.setAdate(c.getString(c.getColumnIndex("adate")));
            u.setTestimonial(c.getString(c.getColumnIndex("testimonial")));
            u.setUid(c.getInt(c.getColumnIndex("UID")));
        }
        return  u;
    }
    public testimonial searchTestimonialsByUserID(int UID){
        Cursor c = d.executerawquery("select * from testimonial where UID='"+UID+"'");
        testimonial u = new testimonial();
        while(c.moveToNext()){
            u.setTid(c.getInt(c.getColumnIndex("TID")));
            u.setAdate(c.getString(c.getColumnIndex("adate")));
            u.setTestimonial(c.getString(c.getColumnIndex("testimonial")));
            u.setUid(c.getInt(c.getColumnIndex("UID")));
        }
        return  u;
    }



}
