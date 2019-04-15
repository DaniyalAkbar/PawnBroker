package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.www.DB.Db;
import com.example.www.model.transaction;

import java.util.ArrayList;

public class TransactionCRUD {
    Db d;
    Context context;
    public TransactionCRUD(Context context){
        this.context=context;
        d= new Db(context);
        d.OpenorCreatDB();
    }

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

    public ArrayList<String> viewAllTransaction(){
        Cursor c = d.executerawquery("select * from transactions");
        ArrayList<String> getTransaction = new ArrayList<>();
        while(c.moveToNext()){
            String u =null;
            u=String.valueOf(c.getInt(c.getColumnIndex("TrID")));
            u+="\t";
            u+=String.valueOf(c.getFloat(c.getColumnIndex("amount")));
            u+=" ";
            u+=c.getString(c.getColumnIndex("tdate"));
            u+="\t";
            u+=c.getString(c.getColumnIndex("type"));

            getTransaction.add(u);
            Toast.makeText(context, getTransaction.get(0).toString(), Toast.LENGTH_SHORT).show();
        }
        return  getTransaction;
    }
    public ArrayList<String> searchTransactionByDate(String date){
        Cursor c = d.executerawquery("select * from transactions where tdate='"+date+"'");
        ArrayList<String> getTransaction = new ArrayList<>();
        while(c.moveToNext()){
            String u =null;
            u=String.valueOf(c.getInt(c.getColumnIndex("TrID")));
            u+="\t";
            u+=String.valueOf(c.getFloat(c.getColumnIndex("amount")));
            u+=" ";
            u+=c.getString(c.getColumnIndex("tdate"));
            u+="\t";
            u+=c.getString(c.getColumnIndex("type"));

            getTransaction.add(u);
            Toast.makeText(context, getTransaction.get(0).toString(), Toast.LENGTH_SHORT).show();
        }
        return getTransaction;
    }
    public ArrayList<String> searchTransactionByID(int TrID){
        Cursor c = d.executerawquery("select * from transactions where TrID='"+TrID+"'");
        ArrayList<String> getTransaction = new ArrayList<>();
        while(c.moveToNext()){
            String u =null;
            u=String.valueOf(c.getInt(c.getColumnIndex("TrID")));
            u+="\t";
            u+=String.valueOf(c.getFloat(c.getColumnIndex("amount")));
            u+=" ";
            u+=c.getString(c.getColumnIndex("tdate"));
            u+="\t";
            u+=c.getString(c.getColumnIndex("type"));

            getTransaction.add(u);
            Toast.makeText(context, getTransaction.get(0).toString(), Toast.LENGTH_SHORT).show();
        }
        return getTransaction;
    }

}
