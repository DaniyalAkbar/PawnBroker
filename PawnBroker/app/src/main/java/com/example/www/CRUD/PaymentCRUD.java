package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.www.DB.Db;
import com.example.www.model.payment;

import java.util.ArrayList;

public class PaymentCRUD {

    Context context;
    Db d;
    public PaymentCRUD(Context context){
        this.context=context;
        d= new Db(context);
        d.OpenorCreatDB();
    }
    public void addPayment(payment u){
        String sql = "insert into payment(amount, type, pdate, TrID) values('"+u.getAmount()+"','"+u.getType()+"','"+u.getPdate()+"', '"+u.getTrID()+"')";
        d.executequery(sql);
    }
    public void updatePayment(payment u){
        String sql = "update payment set amount='"+u.getAmount()+"',type='"+u.getType()+"',pdate='"+u.getPdate()+"' TrID='"+u.getTrID()+"' where pid='"+u.getPid()+"'  ";
        d.executequery(sql);
    }
    public void deletePayment(int pid){
        String sql = "delete from payment where pid= "+pid+"; ";
        d.executequery(sql);
    }

    public ArrayList<String> viewAllPayments(){
        Cursor c = d.executerawquery("select * from payment");
        ArrayList<String> getPayments = new ArrayList<>();
        while(c.moveToNext()){
            String u =null;
            u=String.valueOf(c.getInt(c.getColumnIndex("pid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("pdate"));
            u+="\t";
            u+=String.valueOf(c.getFloat(c.getColumnIndex("amount")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("type"));
            u+="\t";
            u=String.valueOf(c.getInt(c.getColumnIndex("TrID")));

            getPayments.add(u);
            Toast.makeText(context, getPayments.get(0).toString(), Toast.LENGTH_SHORT).show();
        }
        return  getPayments;
    }
    public payment searchPaymentsByDate(String date){
        Cursor c = d.executerawquery("select * from payment where pdate='"+date+"'");
        payment u = new payment();
        while(c.moveToNext()){
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
        while(c.moveToNext()){
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
        while(c.moveToNext()){
            u.setPid((c.getInt(c.getColumnIndex("pid"))));
            u.setAmount(c.getFloat(c.getColumnIndex("amount")));
            u.setType(c.getString(c.getColumnIndex("type")));
            u.setPdate(c.getString(c.getColumnIndex("pdate")));
            u.setTrID(c.getInt(c.getColumnIndex("TrID")));
        }
        return  u;
    }


}
