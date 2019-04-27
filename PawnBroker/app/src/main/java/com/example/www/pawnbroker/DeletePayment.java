package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.www.CRUD.AnnouncementsCRUD;
import com.example.www.CRUD.PaymentCRUD;
import com.example.www.adapter.PaymentAdapter;

public class DeletePayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dels);
        ListView lv = (ListView)findViewById(R.id.lvdel);
        PaymentAdapter AL = new PaymentAdapter(this,new PaymentCRUD(this).viewAllPayments(),"delete");
        if(AL.getCount()==0){
            ShowDialog("No records found!");
        }
        else {
            lv.setAdapter(AL);
        }
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(DeletePayment.this);
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

