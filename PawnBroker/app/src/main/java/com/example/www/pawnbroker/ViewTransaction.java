package com.example.www.pawnbroker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
        lv.setAdapter(AL);
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
    }
}
