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

import com.example.www.CRUD.TestimonialCRUD;

import java.util.ArrayList;

public class SearchTestimonials extends AppCompatActivity {

    EditText et;
    ListView lv;
    Button btnSearch;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_testimonials);
        et = (EditText)findViewById(R.id.itemToSearchTestimonial);
        lv = (ListView)findViewById(R.id.lvTestimonial);
        btnSearch = (Button)findViewById(R.id.btnTestimonialSearch);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> arrLst = new ArrayList<String>();
        arrLst.add("User ID");
        arrLst.add("Date");
        ArrayAdapter adapt = new ArrayAdapter(SearchTestimonials.this, android.R.layout.simple_list_item_1,arrLst);
        spinner.setAdapter(adapt);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter AL = null;
                String input = et.getText().toString().trim();

                if(spinner.getSelectedItem().equals("User ID")){
                    Toast.makeText(SearchTestimonials.this, "u entered user id", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchTestimonials.this,android.R.layout.simple_list_item_1,new TestimonialCRUD(SearchTestimonials.this).searchTestimonialsByUserID(Integer.parseInt(input)));
                }
                else if(spinner.getSelectedItem().equals("Date")){
                    Toast.makeText(SearchTestimonials.this, "u entered Date", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchTestimonials.this,android.R.layout.simple_list_item_1,new TestimonialCRUD(SearchTestimonials.this).searchTestimonialByDate(input.toString()));
                }
                lv.setAdapter(AL);
            }
        });



    }
}
