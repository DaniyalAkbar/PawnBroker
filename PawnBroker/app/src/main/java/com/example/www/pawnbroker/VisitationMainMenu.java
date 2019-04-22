package com.example.www.pawnbroker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class VisitationMainMenu extends AppCompatActivity {
    Button addbtn,viewbtn,updatebtn,deletebtn,searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_visitation);
        addbtn=(Button)findViewById(R.id.addVisitationBtn);
        viewbtn=(Button)findViewById(R.id.viewVisitationBtn);
        updatebtn=(Button)findViewById(R.id.updateVisitationBtn);
        deletebtn=(Button)findViewById(R.id.deleteVisitationBtn);
        searchbtn=(Button)findViewById(R.id.searchVisitationBtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VisitationMainMenu.this,DeleteVisitation.class));
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VisitationMainMenu.this,AddVisitation.class));
            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VisitationMainMenu.this,ViewVisitation.class));
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VisitationMainMenu.this,SearchVisitations.class));
            }
        });
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(VisitationMainMenu.this,UpdateVisitation.class));
            }
        });


    }
}
