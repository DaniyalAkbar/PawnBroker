package com.example.www.pawnbroker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PaymentMainMenu extends AppCompatActivity {
    Button addbtn,viewbtn,updatebtn,deletebtn,searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_payment);
        addbtn=(Button)findViewById(R.id.addPaymentBtn);
        viewbtn=(Button)findViewById(R.id.viewPaymentBtn);
        updatebtn=(Button)findViewById(R.id.updatePaymentBtn);
        deletebtn=(Button)findViewById(R.id.deletePaymentBtn);
        searchbtn=(Button)findViewById(R.id.searchPaymentBtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentMainMenu.this,DeletePayment.class));
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentMainMenu.this,AddPayment.class));
            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentMainMenu.this,ViewPayment.class));
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentMainMenu.this,SearchPayment.class));
            }
        });
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PaymentMainMenu.this,UpdatePayment.class));
            }
        });


    }
}
