package com.example.www.pawnbroker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.EmployeeCRUD;
import com.example.www.CRUD.TransactionCRUD;
import com.example.www.CRUD.VisitationCRUD;
import com.example.www.adapter.EmployeeAdapter;
import com.example.www.adapter.TransactionAdapter;

public class ViewTransaction extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_forall);
        lv=(ListView)findViewById(R.id.lv);
        TransactionAdapter AL = new TransactionAdapter(this,new TransactionCRUD(this).viewAllTransaction(),"update");
        BroadcastReceiver broadcast_reciever = new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent intent) {
                String action = intent.getAction();
                if (action.equals("refresh")) {

                    lv.setAdapter(null);
                    TransactionAdapter AL = new TransactionAdapter(ViewTransaction.this,new TransactionCRUD(ViewTransaction.this).viewAllTransaction(),"update");
                    lv.setAdapter(AL);

                }
            }
        };
        registerReceiver(broadcast_reciever, new IntentFilter("refresh"));
        if(AL.getCount()==0){
            ShowDialog("No records found!");
        }
        else{
            lv.setAdapter(AL);
        }
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(ViewTransaction.this);
        AD.setTitle("PawnBroker");
        AD.setMessage(Message);
        AD.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AD.show();
    }

}
