package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;

import com.example.www.DB.Db;
import com.example.www.model.payment;

import java.util.ArrayList;

public class PaymentCRUD {

    Context context;

    public PaymentCRUD(Context context){
        this.context=context;
    }
    Db d = new Db(context);
    public void addPayment(payment u){
        String sql = "insert into payment(amount, type, pdate, TrID) values('"+u.getAmount()+"','"+u.getType()+"','"+u.getPdate()+"', '"+u.getTrID()+"')";
        d.executequery(sql);
    }
    public void updatePayment(payment u){
        String sql = "update payment set amount='"+u.getAmount()+"',type='"+u.getType()+"',pdate='"+u.getPdate()+"', TrID='"+u.getTrID()+"'   ";
        d.executequery(sql);
    }
    public void deletePayment(int pid){
        String sql = "delete from payment where pid= "+pid+"; ";
        d.executequery(sql);
    }

    public ArrayList<payment> viewAllPayments(){
        Cursor c = d.executerawquery("select * from payment");
        ArrayList<payment> getPayments = new ArrayList<>();
        while(c!=null){
            payment u = new payment();
            u.setPid(c.getInt(c.getColumnIndex("pid")));
            u.setPdate(c.getString(c.getColumnIndex("pdate")));
            u.setAmount(c.getFloat(c.getColumnIndex("amount")));
            u.setType(c.getString(c.getColumnIndex("type")));
            u.setTrID(c.getInt(c.getColumnIndex("TrID")));
            getPayments.add(u);
        }
        return  getPayments;
    }
    public payment searchPaymentsByDate(String date){
        Cursor c = d.executerawquery("select * from payment where pdate='"+date+"'");
        payment u = new payment();
        while(c!=null){
            u.setPid((c.getInt(c.getColumnIndex("pid"))));
            u.setAmount(c.getFloat(c.getColumnIndex("amount")));
            u.setType(c.getString(c.getColumnIndex("type")));
            u.setPdate(c.getString(c.getColumnIndex("pdate")));
            u.setTrID(c.getInt(c.getColumnIndex("TrID")));
        }
        return  u;
    }
    public payment searchPaymentsByType(String type){
        Cursor c = d.executerawquery("select * from payment where type='"+type+"'");
        payment u = new payment();
        while(c!=null){
            u.setPid((c.getInt(c.getColumnIndex("pid"))));
            u.setAmount(c.getFloat(c.getColumnIndex("amount")));
            u.setType(c.getString(c.getColumnIndex("type")));
            u.setPdate(c.getString(c.getColumnIndex("pdate")));
            u.setTrID(c.getInt(c.getColumnIndex("TrID")));
        }
        return  u;
    }

    public payment searchPaymentsByTransaction(int TrID){
        Cursor c = d.executerawquery("select * from payment where TrID='"+TrID+"'");
        payment u = new payment();
        while(c!=null){
            u.setPid((c.getInt(c.getColumnIndex("pid"))));
            u.setAmount(c.getFloat(c.getColumnIndex("amount")));
            u.setType(c.getString(c.getColumnIndex("type")));
            u.setPdate(c.getString(c.getColumnIndex("pdate")));
            u.setTrID(c.getInt(c.getColumnIndex("TrID")));
        }
        return  u;
    }


}
