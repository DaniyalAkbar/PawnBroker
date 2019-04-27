package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.PaymentCRUD;
import com.example.www.model.payment;

import java.text.SimpleDateFormat;

public class UpdatePayment extends AppCompatActivity {
    Button AddPaymenttBtnButton;
    EditText Amount,PDate,Trid,PID,Type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_payment);
        AddPaymenttBtnButton=(Button)findViewById(R.id.txtPaymentSubmitBtn);
        PID=(EditText)findViewById(R.id.txtPaymentID);
        Amount=(EditText)findViewById(R.id.txAmount);
        PDate=(EditText)findViewById(R.id.txtDatePayment);
        Trid=(EditText)findViewById(R.id.txtIDTransaction);
        Type=(EditText)findViewById(R.id.txtTypePayment);
        PID.setInputType(InputType.TYPE_CLASS_NUMBER);
        PID.setInputType(InputType.TYPE_CLASS_PHONE);
        Trid.setText(getIntent().getStringExtra("TRID"));
        PDate.setText(getIntent().getStringExtra("PDATE"));
        Amount.setText(getIntent().getStringExtra("AMOUNT"));
        Type.setText(getIntent().getStringExtra("TYPE"));
        PID.setText(getIntent().getStringExtra("PID"));
        PID.setEnabled(false);


        AddPaymenttBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(PID.getText().length()!=0 && Amount.getText().length()!=0 && Trid.getText().length()!=0 && PDate.getText().length()!=0 && Type.getText().length()!=0) {
                        payment p = new payment();
                        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                        p.setPid(Integer.parseInt(PID.getText().toString()));
                        p.setAmount(Float.parseFloat(Amount.getText().toString()));
                        p.setTrID(Integer.parseInt(Trid.getText().toString()));
                        p.setPdate(PDate.getText().toString());
                        p.setType(Type.getText().toString());
                        new PaymentCRUD(UpdatePayment.this).updatePayment(p);
                        ShowDialog("Payment Updated Successfully");
                        Intent i = new Intent("refresh");
                        sendBroadcast(i);
                    }


                }catch (SQLiteException e){
                    ShowDialog(e.getMessage());
                }catch (Exception e){
                    ShowDialog(e.getMessage());
                }

            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(UpdatePayment.this);
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
