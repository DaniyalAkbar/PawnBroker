package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;

import com.example.www.DB.Db;
import com.example.www.model.visitation;

import java.util.ArrayList;

public class VisitationCRUD {

    Context context;
    public VisitationCRUD(Context context){
        this.context=context;
    }
    Db d = new Db(context);
    public void addVisitation(visitation u){
        String sql = "insert into visitation(visitation, empid, vdate) values('"+u.getVisitation()+"','"+u.getEmpid()+"','"+u.getVdate()+"')";
        d.executequery(sql);
    }
    public void updateVisitation(visitation u){
        String sql = "update visitation set visitation='"+u.getVisitation()+"',empid='"+u.getEmpid()+"', vdate='"+u.getVdate()+"' where vid='"+u.getVid()+"' ";
        d.executequery(sql);
    }
    public void deleteVisitation(int vid){
        String sql = "delete from visitation where vid= "+vid+"; ";
        d.executequery(sql);
    }

    public ArrayList<visitation> viewAllVisitation(){
        Cursor c = d.executerawquery("select * from visitation");
        ArrayList<visitation> getVisitation = new ArrayList<>();
        while(c.moveToNext()){
            visitation u = new visitation();
            u.setVid(c.getInt(c.getColumnIndex("vid")));
            u.setVdate(c.getString(c.getColumnIndex("vdate")));
            u.setEmpid(c.getInt(c.getColumnIndex("empid")));
            u.setVisitation(c.getString(c.getColumnIndex("visitation")));
            getVisitation.add(u);
        }
        return  getVisitation;
    }
    public visitation searchVisitationByID(int vid){
        Cursor c = d.executerawquery("select * from visitation where vid='"+vid+"'");
        visitation u = new visitation();
        while(c.moveToNext()){
            u.setVid(c.getInt(c.getColumnIndex("vid")));
            u.setVdate(c.getString(c.getColumnIndex("vdate")));
            u.setEmpid(c.getInt(c.getColumnIndex("empid")));
            u.setVisitation(c.getString(c.getColumnIndex("visitation")));
        }
        return  u;
    }
    public visitation searchVisitationByDate(String date){
        Cursor c = d.executerawquery("select * from visitation where vdate='"+date+"'");
        visitation u = new visitation();
        while(c.moveToNext()){
            u.setVid(c.getInt(c.getColumnIndex("vid")));
            u.setVdate(c.getString(c.getColumnIndex("vdate")));
            u.setEmpid(c.getInt(c.getColumnIndex("empid")));
            u.setVisitation(c.getString(c.getColumnIndex("visitation")));
        }
        return  u;
    }
    public visitation searchVisitationByEmp(int empid){
        Cursor c = d.executerawquery("select * from visitation where empid='"+empid+"'");
        visitation u = new visitation();
        while(c.moveToNext()){
            u.setVid(c.getInt(c.getColumnIndex("vid")));
            u.setVdate(c.getString(c.getColumnIndex("vdate")));
            u.setEmpid(c.getInt(c.getColumnIndex("empid")));
            u.setVisitation(c.getString(c.getColumnIndex("visitation")));
        }
        return  u;
    }


}
