package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.AnnouncementsCRUD;
import com.example.www.CRUD.UserCRUD;
import com.example.www.model.announcements;
import com.example.www.model.users;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAnnouncement extends AppCompatActivity {
    Button AddAnnouncementBtnButton;
    EditText Annoucncement,ADate,Type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_announcement);
        AddAnnouncementBtnButton=(Button)findViewById(R.id.txtAnnouncementSubmitBtn);
        Annoucncement=(EditText)findViewById(R.id.txtAnnouncement);
        ADate=(EditText)findViewById(R.id.txtDateAnnouncement);
        Type=(EditText)findViewById(R.id.txtTypeAnnouncement);
        ADate.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        AddAnnouncementBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(Type.getText().length()!=0 && Annoucncement.getText().length()!=0 && ADate.getText().length()!=0) {
                        announcements a = new announcements();
                        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                        a.setAnnouncement(Annoucncement.getText().toString());
                        a.setType(Type.getText().toString());
                        a.setDate(ADate.getText().toString());
                        new AnnouncementsCRUD(AddAnnouncement.this).addAnnouncement(a);
                        ShowDialog("New Annoucement Added Successfully");
                    }
                    else
                    {
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
        AlertDialog.Builder AD = new AlertDialog.Builder(AddAnnouncement.this);
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
