package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ShowableListMenu;
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

        Annoucncement=(EditText)findViewById(R.id.txtAnnouncement);
        ADate=(EditText)findViewById(R.id.txtDateAnnouncement);
        Type=(EditText)findViewById(R.id.txtTypeAnnouncement);
        AnnouncementID.setText(getIntent().getStringExtra("AID"));
        Annoucncement.setText(getIntent().getStringExtra("ANNOUNCEMENT"));
        ADate.setText(getIntent().getStringExtra("ADATE"));
        Type.setText(getIntent().getStringExtra("TYPE"));

        AnnouncementID.setEnabled(false);
        AddAnnouncementBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(AnnouncementID.getText().length()!=0 && Annoucncement.getText().length()!=0 && Type.getText().length()!=0 && ADate.getText().length()!=0) {
                        announcements a = new announcements();
                        a.setAID(Integer.parseInt(AnnouncementID.getText().toString()));
                        a.setAnnouncement(Annoucncement.getText().toString());
                        a.setType(Type.getText().toString());
                        a.setDate(ADate.getText().toString());
                        new AnnouncementsCRUD(UpdateAnnouncement.this).update(a);
                        ShowDialog("Annoucement Updated Successfully");
                        Intent i = new Intent("refresh");
                        sendBroadcast(i);
                    }else{
                        ShowDialog("Please enter all values!");
                    }


                }catch (Exception e){

                    ShowDialog(e.getMessage());
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
