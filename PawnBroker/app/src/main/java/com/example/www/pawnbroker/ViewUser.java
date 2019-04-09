package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.UserCRUD;

public class ViewUser extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_users);
        lv=(ListView)findViewById(R.id.lvUsers);
        ArrayAdapter AL = new ArrayAdapter(ViewUser.this,android.R.layout.simple_list_item_1,new UserCRUD(ViewUser.this).viewall());
        lv.setAdapter(AL);


    }
}
