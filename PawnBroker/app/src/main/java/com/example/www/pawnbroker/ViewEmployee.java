package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.EmployeeCRUD;

public class ViewEmployee extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_forall);
        lv=(ListView)findViewById(R.id.lv);
        ArrayAdapter ap = new ArrayAdapter(ViewEmployee.this,android.R.layout.simple_list_item_1,new EmployeeCRUD(ViewEmployee.this).viewAllEmployee());
        lv.setAdapter(ap);
    }
}
