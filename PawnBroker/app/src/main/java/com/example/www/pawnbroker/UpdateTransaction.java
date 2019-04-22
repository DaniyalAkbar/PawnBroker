package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.TransactionCRUD;
import com.example.www.model.transaction;

import java.text.SimpleDateFormat;

public class UpdateTransaction extends AppCompatActivity {
    Button AddTransactiontBtnButton;
    EditText Amount,TDate,Type,TrID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_transaction);
        AddTransactiontBtnButton=(Button)findViewById(R.id.txtTransactionSubmitBtn);
        Amount=(EditText)findViewById(R.id.txAmount);
        TrID=(EditText)findViewById(R.id.txtTrID);
        TDate=(EditText)findViewById(R.id.txtDateTransaction);
        Type=(EditText)findViewById(R.id.txtTypeTransaction);
        TrID.setInputType(InputType.TYPE_CLASS_NUMBER);
        TrID.setInputType(InputType.TYPE_CLASS_PHONE);

        AddTransactiontBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    transaction t= new transaction();
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    t.setTrID(Integer.parseInt(TrID.getText().toString()));
                    t.setAmount(Float.parseFloat(Amount.getText().toString()));
                    t.setType(Type.getText().toString());
                    t.setTdate(TDate.getText().toString());
                    new TransactionCRUD(UpdateTransaction.this).updateTransaction(t);
                    ShowDialog("Transaction Updated Successfully");

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
        AlertDialog.Builder AD = new AlertDialog.Builder(UpdateTransaction.this);
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
