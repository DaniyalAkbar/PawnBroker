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
        executequery("PRAGMA foreign_keys=on;");

    }
    public void executequery(String sql){
        Configure(db);
        db.execSQL(sql);


    }
    public void createtables(){
        executequery("create table if not exists users(UID Integer primary key autoincrement,Fname varchar,Lname varchar,regdate varchar)");
        executequery("create table if not exists announcements(AID Integer primary key autoincrement, announcement varchar,type varchar,adate varchar)");
        executequery("create table if not exists testimonial(TID Integer primary key autoincrement,testimonial varchar,UID integer references users(UID),adate varchar)");
        executequery("create table if not exists transactions(TrID Integer primary key autoincrement,amount real,type varchar,tdate varchar)");
        executequery("create table if not exists payment(PID Integer primary key autoincrement,amount real,pdate date,TrID integer references transactions(Trid),type varchar)");
        executequery("create table if not exists employee(empid Integer primary key autoincrement,Fname varchar, Lname varchar)");
        executequery("create table if not exists visitation(vid Integer primary key autoincrement,visitation varchar, empid integer references employee(empid),vdate varchar)");


    }
    public  void Configure(SQLiteDatabase db){
        db.setForeignKeyConstraintsEnabled(true);
    }
    public Cursor executerawquery(String sql){
        Cursor c = db.rawQuery(sql,null);
        //sc.moveToFirst();
        return c;

    }


}
