package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.www.CRUD.UserCRUD;

import java.util.ArrayList;

public class SearchUser extends AppCompatActivity {

    EditText et;
    ListView lv;
    Button btnSearch;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_user);
        et = (EditText)findViewById(R.id.itemToSearchAdmin);
        lv = (ListView)findViewById(R.id.lvAdmin);
        btnSearch = (Button)findViewById(R.id.btnAdminSearch);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> arrLst = new ArrayList<String>();
        arrLst.add("First Name");
        arrLst.add("Last Name");
        arrLst.add("Registration Date");
        ArrayAdapter adapt = new ArrayAdapter(SearchUser.this, android.R.layout.simple_list_item_1,arrLst);
        spinner.setAdapter(adapt);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter AL = null;
                String input = et.getText().toString().trim();

                if(spinner.getSelectedItem().equals("First Name")){
                   // Toast.makeText(SearchUser.this, "u entered first name", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchUser.this,android.R.layout.simple_list_item_1,new UserCRUD(SearchUser.this).searchUserByFirstName(input.toString()));
                }
                else if(spinner.getSelectedItem().equals("Last Name")){
                    //Toast.makeText(SearchUser.this, "u entered last name", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchUser.this,android.R.layout.simple_list_item_1,new UserCRUD(SearchUser.this).searchUserByLastName(input.toString()));
                }
                else if(spinner.getSelectedItem().equals("Registration Date")){
                    //Toast.makeText(SearchUser.this, "u entered Reg Date", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchUser.this,android.R.layout.simple_list_item_1,new UserCRUD(SearchUser.this).searchUserByRegDate(input.toString()));
                }
                lv.setAdapter(AL);
            }
        });



    }
}
