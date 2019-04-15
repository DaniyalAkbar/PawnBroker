package com.example.www.pawnbroker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class UserMainMenu extends AppCompatActivity {
    Button addbtn,viewbtn,updatebtn,deletebtn,searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_user);
        addbtn=(Button)findViewById(R.id.addUserBtn);
        viewbtn=(Button)findViewById(R.id.viewUserBtn);
        updatebtn=(Button)findViewById(R.id.updateUserBtn);
        deletebtn=(Button)findViewById(R.id.deleteUserBtn);
        searchbtn=(Button)findViewById(R.id.searchUserBtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserMainMenu.this,DeleteUser.class));
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserMainMenu.this,AddUser.class));
            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserMainMenu.this,ViewUser.class));
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserMainMenu.this,SearchUserByAdmin.class));
            }
        });




    }
}
