package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.AnnouncementsCRUD;
import com.example.www.CRUD.VisitationCRUD;
import com.example.www.model.announcements;
import com.example.www.model.visitation;

import java.text.SimpleDateFormat;

public class AddVisitation extends AppCompatActivity {
    Button AddVisitationBtnButton;
    EditText Visitation,VDate,Empid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_announcement);
        AddVisitationBtnButton=(Button)findViewById(R.id.txtVisitationSubmitBtn);
        Visitation=(EditText)findViewById(R.id.txtVisitation);
        VDate=(EditText)findViewById(R.id.txtDateVisitation);
        Empid=(EditText)findViewById(R.id.txtEmpIdFK);
        AddVisitationBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    visitation v= new visitation();
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    v.setVisitation(Visitation.getText().toString());
                    v.setEmpid(Integer.parseInt(Empid.getText().toString()));
                    v.setVdate(VDate.getText().toString());
                    new VisitationCRUD(AddVisitation.this).addVisitation(v);
                    ShowDialog("New Visitation Added Successfully");

                }catch (SQLiteException e){
                    ShowDialog(e.getMessage());
                }
            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(AddVisitation.this);
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
