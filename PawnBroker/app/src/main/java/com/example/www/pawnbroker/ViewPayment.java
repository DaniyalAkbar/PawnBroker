package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.PaymentCRUD;
import com.example.www.CRUD.TransactionCRUD;

public class ViewPayment extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_forall);
        lv=(ListView)findViewById(R.id.lv);
        ArrayAdapter ap = new ArrayAdapter(ViewPayment.this,android.R.layout.simple_list_item_1,new PaymentCRUD(ViewPayment.this).viewAllPayments());
        lv.setAdapter(ap);
    }
}
