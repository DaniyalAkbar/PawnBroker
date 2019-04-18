package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.www.DB.Db;
import com.example.www.model.testimonial;

import java.util.ArrayList;

public class TestimonialCRUD {

    Context context;
    Db d;
    public TestimonialCRUD(Context context){
        this.context=context;
        d= new Db(context);
        d.OpenorCreatDB();
    }
    public void addTestimonial(testimonial u){
        String sql = "insert into testimonial(testimonial, UID, adate) values('"+u.getTestimonial()+"','"+u.getUid()+"','"+u.getAdate()+"')";
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

    public ArrayList<String> viewAllTestimonial(){
        Cursor c = d.executerawquery("select * from testimonial");
        ArrayList<String> getTestimonial = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u ;
            u=String.valueOf(c.getInt(c.getColumnIndex("TID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("testimonial"));
            u+="\t";
            u+=String.valueOf(c.getInt(c.getColumnIndex("UID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("adate"));

            getTestimonial.add(u);
            Toast.makeText(context, getTestimonial.get(0).toString(), Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
        return  getTestimonial;
    }
    public ArrayList<String> searchTestimonialByDate(String date){
        Cursor c = d.executerawquery("select * from testimonial where adate='"+date+"'");
        ArrayList<String> getTestimonial = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u ;
            u=String.valueOf(c.getInt(c.getColumnIndex("TID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("testimonial"));
            u+="\t";
            u+=String.valueOf(c.getInt(c.getColumnIndex("UID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("adate"));

            getTestimonial.add(u);
            c.moveToNext();
        }
        return  getTestimonial;
    }
    public ArrayList<String> searchTestimonialsByUserID(int UID){
        Cursor c = d.executerawquery("select * from testimonial where UID='"+UID+"'");
        ArrayList<String> getTestimonial = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u ;
            u=String.valueOf(c.getInt(c.getColumnIndex("TID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("testimonial"));
            u+="\t";
            u+=String.valueOf(c.getInt(c.getColumnIndex("UID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("adate"));

            getTestimonial.add(u);
            c.moveToNext();
        }
        return  getTestimonial;
    }



}
