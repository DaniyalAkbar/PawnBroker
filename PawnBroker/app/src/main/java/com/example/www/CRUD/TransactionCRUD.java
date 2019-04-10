package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;

import com.example.www.DB.Db;
import com.example.www.model.transaction;

import java.util.ArrayList;

public class TransactionCRUD {

    Context context;
    public TransactionCRUD(Context context){
        this.context=context;
    }
    Db d = new Db(context);
    public void addTransaction(transaction u){
        String sql = "insert into transactions(amount, type, tdate) values('"+u.getAmount()+"','"+u.getType()+"','"+u.getTdate()+"')";
        d.executequery(sql);
    }
    public void updateTransaction(transaction u){
        String sql = "update transactions set amount='"+u.getAmount()+"',type='"+u.getType()+"', tdate='"+u.getTdate()+"' where TrID='"+u.getTrID()+"' ";
        d.executequery(sql);
    }
    public void deleteTransaction(int TrID){
        String sql = "delete from transactions where TrID= "+TrID+"; ";
        d.executequery(sql);
    }

    public ArrayList<transaction> viewAllTransaction(){
        Cursor c = d.executerawquery("select * from transactions");
        ArrayList<transaction> getTransaction = new ArrayList<>();
        while(c.moveToNext()){
            transaction u = new transaction();
            u.setTrID(c.getInt(c.getColumnIndex("TrID")));
            u.setAmount(c.getFloat(c.getColumnIndex("amount")));
            u.setTdate(c.getString(c.getColumnIndex("tdate")));
            u.setType(c.getString(c.getColumnIndex("type")));
            getTransaction.add(u);
        }
        return  getTransaction;
    }
    public transaction searchTransactionByDate(String date){
        Cursor c = d.executerawquery("select * from transactions where tdate='"+date+"'");
        transaction u = new transaction();
        while(c.moveToNext()){
            u.setTrID(c.getInt(c.getColumnIndex("TrID")));
            u.setAmount(c.getFloat(c.getColumnIndex("amount")));
            u.setTdate(c.getString(c.getColumnIndex("tdate")));
            u.setType(c.getString(c.getColumnIndex("type")));
        }
        return  u;
    }
    public transaction searchTransactionByID(int TrID){
        Cursor c = d.executerawquery("select * from transactions where TrID='"+TrID+"'");
        transaction u = new transaction();
        while(c.moveToNext()){
            u.setTrID(c.getInt(c.getColumnIndex("TrID")));
            u.setAmount(c.getFloat(c.getColumnIndex("amount")));
            u.setTdate(c.getString(c.getColumnIndex("tdate")));
            u.setType(c.getString(c.getColumnIndex("type")));
        }
        return  u;
    }

}
