package com.example.www.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Db {
    Context context;
    SQLiteDatabase db;
    public Db(Context context){
        this.context=context;
    }
    public void OpenorCreatDB(){
        db=context.openOrCreateDatabase("pawndb",Context.MODE_PRIVATE,null);
    }
    public void executequery(String sql){
        db.execSQL(sql);
    }
    public void createtables(){
        executequery("create table if not exists users(UID Integer autoincrement,Fname varchar,Lname varchar,regdate date)");
        executequery("create table if not exists announcements(AID Integer autoincrement, announcement varchar,type varchar,adate date)");
        executequery("create table if not exists testimonial(TID Integer autoincrement,testimonial varchar,UID varchar references users(UID),adate date)");
        executequery("create table if not exists transaction(TrID Integer autoincrement,amount real,type varchar,tdate varchar)");
        executequery("create table if not exists payment(PID Integer autoincrement,amount real,date varchar,pdate varchar)");       //transaction foreign key needs to be added
        executequery("create table if not exists employee(empid Integer autoincrement,Fnmae varchar, Lname varchar)");
        executequery("create table if not exists visitation(vid Integer autoincrement,visitation varchar, empid int references employee(empid),vdate date)");

    }
    public Cursor executerawquery(String sql){
        Cursor c = db.rawQuery(sql,null);
        c.moveToFirst();
        return c;

    }


}
