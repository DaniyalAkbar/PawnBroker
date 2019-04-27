package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.VisitationCRUD;
import com.example.www.model.visitation;

import java.text.SimpleDateFormat;

public class UpdateVisitation extends AppCompatActivity {
    Button AddVisitationBtnButton;
    EditText Visitation,VDate,Empid,VID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_visitation);
        AddVisitationBtnButton=(Button)findViewById(R.id.txtVisitationSubmitBtn);
        VID=(EditText)findViewById(R.id.txtVID);
        Visitation=(EditText)findViewById(R.id.txtVisitation);
        VDate=(EditText)findViewById(R.id.txtDateVisitation);
        Empid=(EditText)findViewById(R.id.txtEmpIdFK);
        VID.setText(getIntent().getStringExtra("VID"));
        Visitation.setText(getIntent().getStringExtra("VISITATION"));
        Empid.setText(getIntent().getStringExtra("EMPID"));
        VDate.setText(getIntent().getStringExtra("VDATE"));
        Empid.setEnabled(false);
        VID.setEnabled(false);
        AddVisitationBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(VID.getText().length()!=0 && Visitation.getText().length()!=0 && VDate.getText().length()!=0 && Empid.getText().length()!=0) {
                        visitation v = new visitation();
                        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                        v.setVid(Integer.parseInt(VID.getText().toString()));
                        v.setVisitation(Visitation.getText().toString());
                        v.setEmpid(Integer.parseInt(Empid.getText().toString()));
                        v.setVdate(VDate.getText().toString());
                        new VisitationCRUD(UpdateVisitation.this).updateVisitation(v);
                        ShowDialog("Visitation Updated Successfully");
                        Intent i = new Intent("refresh");
                        sendBroadcast(i);
                    }else {
                        ShowDialog("Please enter all values!");
                    }


                }catch (Exception e){
                    ShowDialog("Incorrect Date Format. Please Try Again");

                    e.printStackTrace();
                }
            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(UpdateVisitation.this);
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
