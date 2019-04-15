package com.example.www.pawnbroker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AnnouncementMainMenu extends AppCompatActivity {
    Button addbtn,viewbtn,updatebtn,deletebtn,searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_announcement);
        addbtn=(Button)findViewById(R.id.addAnnouncementBtn);
        viewbtn=(Button)findViewById(R.id.viewAnnouncementBtn);
        updatebtn=(Button)findViewById(R.id.updateAnnouncementBtn);
        deletebtn=(Button)findViewById(R.id.deleteAnnouncementBtn);
        searchbtn=(Button)findViewById(R.id.searchAnnouncementBtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnnouncementMainMenu.this,DeleteAnnouncement.class));
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnnouncementMainMenu.this,AddUser.class));
            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AnnouncementMainMenu.this,ViewAnnouncement.class));
            }
        });



    }
}
