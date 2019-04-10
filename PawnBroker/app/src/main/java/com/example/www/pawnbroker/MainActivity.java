package com.example.www.pawnbroker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.www.DB.Db;

public class MainActivity extends AppCompatActivity {
    Button user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Db d = new Db(MainActivity.this);
        d.OpenorCreatDB();
        d.createtables();
        user=(Button)findViewById(R.id.btnUsers);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UserMainMenu.class));
            }
        });


    }
}
