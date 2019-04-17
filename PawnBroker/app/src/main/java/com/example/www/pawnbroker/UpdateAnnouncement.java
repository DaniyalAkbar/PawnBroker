package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.AnnouncementsCRUD;
import com.example.www.model.announcements;

import java.text.SimpleDateFormat;

public class UpdateAnnouncement extends AppCompatActivity {
    Button AddAnnouncementBtnButton;
    EditText Annoucncement,ADate,Type,AnnouncementID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_announcement);

        AddAnnouncementBtnButton=(Button)findViewById(R.id.txtAnnouncementSubmitBtn);
        AnnouncementID=(EditText)findViewById(R.id.txtAnnouncementID);
        AnnouncementID.setInputType(InputType.TYPE_CLASS_NUMBER);
        AnnouncementID.setInputType(InputType.TYPE_CLASS_NUMBER);

        Annoucncement=(EditText)findViewById(R.id.txtAnnouncement);
        ADate=(EditText)findViewById(R.id.txtDateAnnouncement);
        Type=(EditText)findViewById(R.id.txtTypeAnnouncement);
        AddAnnouncementBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    announcements a= new announcements();
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    a.setAID(Integer.parseInt(AnnouncementID.getText().toString()));
                    a.setAnnouncement(Annoucncement.getText().toString());
                    a.setType(Type.getText().toString());
                    a.setDate(fm.parse(ADate.getText().toString()).toString());
                    new AnnouncementsCRUD(UpdateAnnouncement.this).update(a);
                    ShowDialog("Annoucement Updated Successfully");

                }catch (java.text.ParseException e){
                    ShowDialog("Incorrect Date Format. Please Try Again");

                    e.printStackTrace();
                }
            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(UpdateAnnouncement.this);
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
