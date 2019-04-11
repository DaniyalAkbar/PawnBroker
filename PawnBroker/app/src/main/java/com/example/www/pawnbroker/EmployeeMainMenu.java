package com.example.www.pawnbroker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EmployeeMainMenu extends AppCompatActivity {
    Button addbtn,viewbtn,updatebtn,deletebtn,searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_employee);
        addbtn=(Button)findViewById(R.id.addEmployeeBtn);
        viewbtn=(Button)findViewById(R.id.viewEmployeeBtn);
        updatebtn=(Button)findViewById(R.id.updateEmployeeBtn);
        deletebtn=(Button)findViewById(R.id.deleteEmployeeBtn);
        searchbtn=(Button)findViewById(R.id.searchEmployeeBtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeMainMenu.this,DeleteEmployee.class));
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeMainMenu.this,AddEmployee.class));
            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmployeeMainMenu.this,ViewEmployee.class));
            }
        });



    }
}
