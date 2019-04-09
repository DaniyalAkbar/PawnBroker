package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;

import com.example.www.DB.Db;
import com.example.www.model.employee;

import java.util.ArrayList;

public class EmployeeCRUD {

    Context context;
    public EmployeeCRUD(Context context){
        this.context=context;
    }
    Db d = new Db(context);
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

    public ArrayList<employee> viewAllEmployee(){
        Cursor c = d.executerawquery("select * from employee");
        ArrayList<employee> getEmployee = new ArrayList<>();
        while(c!=null){
            employee u = new employee();
            u.setEmpid(c.getInt(c.getColumnIndex("empid")));
            u.setFname(c.getString(c.getColumnIndex("Fname")));
            u.setLname(c.getString(c.getColumnIndex("Lname")));
            getEmployee.add(u);
        }
        return  getEmployee;
    }
    public employee searchEmployeeByID(int id){
        Cursor c = d.executerawquery("select * from employee where empid='"+id+"'");
        employee u = new employee();
        while(c!=null){
            u.setEmpid(c.getInt(c.getColumnIndex("empid")));
            u.setFname(c.getString(c.getColumnIndex("Fname")));
            u.setLname(c.getString(c.getColumnIndex("Lname")));
        }
        return  u;
    }

    public employee searchEmployeeByFname(String fname){
        Cursor c = d.executerawquery("select * from employee where Fname='"+fname+"'");
        employee u = new employee();
        while(c!=null){
            u.setEmpid(c.getInt(c.getColumnIndex("empid")));
            u.setFname(c.getString(c.getColumnIndex("Fname")));
            u.setLname(c.getString(c.getColumnIndex("Lname")));
        }
        return  u;
    }


}
