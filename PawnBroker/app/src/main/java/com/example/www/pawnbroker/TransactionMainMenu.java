package com.example.www.pawnbroker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TransactionMainMenu extends AppCompatActivity {
    Button addbtn,viewbtn,updatebtn,deletebtn,searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_user);
        addbtn=(Button)findViewById(R.id.addTransactionBtn);
        viewbtn=(Button)findViewById(R.id.viewTransactionBtn);
        updatebtn=(Button)findViewById(R.id.updateTransactionBtn);
        deletebtn=(Button)findViewById(R.id.deleteTransactionBtn);
        searchbtn=(Button)findViewById(R.id.searchTransactionBtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TransactionMainMenu.this,DeleteTransaction.class));
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TransactionMainMenu.this,AddUser.class));
            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TransactionMainMenu.this,ViewTransaction.class));
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TransactionMainMenu.this,SearchTransactions.class));
            }
        });



    }
}
