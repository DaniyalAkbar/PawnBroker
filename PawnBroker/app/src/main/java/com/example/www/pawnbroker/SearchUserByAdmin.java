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
import com.example.www.model.users;

import java.util.ArrayList;

public class SearchUserByAdmin extends AppCompatActivity {

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
        ArrayAdapter adapt = new ArrayAdapter(SearchUserByAdmin.this, android.R.layout.simple_list_item_1,arrLst);
        spinner.setAdapter(adapt);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<users> arrayList = new ArrayList<users>();


                if(spinner.getSelectedItem().equals("First Name")){
                    //u = new UserCRUD(SearchUserByAdmin.this).searchUserByFirstName(et.getText().toString());
                    String input = et.getText().toString();
                    Toast.makeText(SearchUserByAdmin.this, input.toString(), Toast.LENGTH_SHORT).show();
                    ArrayAdapter AL = new ArrayAdapter(SearchUserByAdmin.this,android.R.layout.simple_list_item_1,new UserCRUD(SearchUserByAdmin.this).searchUserByFirstName(input.toString()));
                    lv.setAdapter(AL);
                }
                else if(spinner.getSelectedItem().equals("Last Name")){
                    //u = new UserCRUD(SearchUserByAdmin.this).searchUserByLastName(et.getText().toString());
                }
                else if(spinner.getSelectedItem().equals("Registration Date")){
                    //u = new UserCRUD(SearchUserByAdmin.this).searchUserByRegDate(et.getText().toString());
                }

                //arrayList.add(u);


            }
        });



    }
}
