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
import com.example.www.CRUD.EmployeeCRUD;
import com.example.www.adapter.AnnouncementAdapter;
import com.example.www.adapter.EmployeeAdapter;

public class DeleteAnnouncement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dels);
        ListView lv = (ListView) findViewById(R.id.lvdel);
        AnnouncementAdapter ap = new AnnouncementAdapter(DeleteAnnouncement.this,new AnnouncementsCRUD(DeleteAnnouncement.this).viewAllAnnouncements(),"delete");
        if(ap.getCount()==0){
            ShowDialog("No records found!");
        }
        else {
            lv.setAdapter(ap);
        }
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(DeleteAnnouncement.this);
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

