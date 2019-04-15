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

import com.example.www.CRUD.VisitationCRUD;

import java.util.ArrayList;

public class SearchVisitations extends AppCompatActivity {

    EditText et;
    ListView lv;
    Button btnSearch;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_visitation);
        et = (EditText)findViewById(R.id.itemToSearchVisitation);
        lv = (ListView)findViewById(R.id.lvVisitation);
        btnSearch = (Button)findViewById(R.id.btnVisitationSearch);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> arrLst = new ArrayList<String>();
        arrLst.add("Employee ID");
        arrLst.add("Visitation ID");
        arrLst.add("Date");
        ArrayAdapter adapt = new ArrayAdapter(SearchVisitations.this, android.R.layout.simple_list_item_1,arrLst);
        spinner.setAdapter(adapt);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter AL = null;
                String input = et.getText().toString().trim();

                if(spinner.getSelectedItem().equals("Employee ID")){
                    Toast.makeText(SearchVisitations.this, "u entered emp id", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchVisitations.this,android.R.layout.simple_list_item_1,new VisitationCRUD(SearchVisitations.this).searchVisitationByEmp(Integer.parseInt(input)));
                }
                else if(spinner.getSelectedItem().equals("Visitation ID")){
                    Toast.makeText(SearchVisitations.this, "u visitation id", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchVisitations.this,android.R.layout.simple_list_item_1,new VisitationCRUD(SearchVisitations.this).searchVisitationByID(Integer.parseInt(input)));
                }
                else if(spinner.getSelectedItem().equals("Date")){
                    Toast.makeText(SearchVisitations.this, "u entered date", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchVisitations.this,android.R.layout.simple_list_item_1,new VisitationCRUD(SearchVisitations.this).searchVisitationByDate(input.toString()));
                }
                lv.setAdapter(AL);
            }
        });



    }
}