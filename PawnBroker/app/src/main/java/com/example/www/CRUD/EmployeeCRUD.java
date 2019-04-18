package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;

import com.example.www.DB.Db;
import com.example.www.model.employee;

import java.util.ArrayList;

public class EmployeeCRUD {

    Context context;
    Db d;
    public EmployeeCRUD(Context context){
        this.context=context;
        d= new Db(context);
        d.OpenorCreatDB();
    }
    public void addEmployee(employee u){

        String sql = "insert into employee(Fname, Lname) values('"+u.getFname()+"','"+u.getLname()+"')";
        d.executequery(sql);
    }
    public void updateEmployee(employee u){
        String sql = "update employee set Fname='"+u.getFname()+"',Lname='"+u.getLname()+"' where empid='"+u.getEmpid()+"' ";
        d.executequery(sql);
    }
    public void deleteEmployee(int empid){
        String sql = "delete from employee where empid= "+empid+"; ";
        d.executequery(sql);
    }

    public ArrayList<String> viewAllEmployee(){
        Cursor c = d.executerawquery("select * from employee");
        ArrayList<String> getEmployee = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u;
            u=String.valueOf(c.getInt(c.getColumnIndex("empid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("Fname"));
            u+=" ";
            u+=c.getString(c.getColumnIndex("Lname"));

            getEmployee.add(u);
            c.moveToNext();
        }
        return  getEmployee;
    }
    public ArrayList<String> searchEmployeeByID(int id){
        Cursor c = d.executerawquery("select * from employee where empid='"+id+"'");
        ArrayList<String> getEmployee = new ArrayList<>();
        while(c.moveToNext()){
            String u;
            u=String.valueOf(c.getInt(c.getColumnIndex("empid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("Fname"));
            u+=" ";
            u+=c.getString(c.getColumnIndex("Lname"));

            getEmployee.add(u);

        }
        return  getEmployee;
    }

    public ArrayList<String> searchEmployeeByFname(String fname){
        Cursor c = d.executerawquery("select * from employee where Fname='"+fname+"'");
        ArrayList<String> getEmployee = new ArrayList<>();
        while(c.moveToNext()){
            String u;
            u=String.valueOf(c.getInt(c.getColumnIndex("empid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("Fname"));
            u+=" ";
            u+=c.getString(c.getColumnIndex("Lname"));

            getEmployee.add(u);

        }
        return  getEmployee;
    }
    public ArrayList<String> searchEmployeeByLname(String lname){
        Cursor c = d.executerawquery("select * from employee where lname='"+lname+"'");
        ArrayList<String> getEmployee = new ArrayList<>();
        while(c.moveToNext()){
            String u;
            u=String.valueOf(c.getInt(c.getColumnIndex("empid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("Fname"));
            u+=" ";
            u+=c.getString(c.getColumnIndex("Lname"));

            getEmployee.add(u);

        }
        return  getEmployee;
    }


}
