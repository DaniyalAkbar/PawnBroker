package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.www.CRUD.AnnouncementsCRUD;

import java.util.ArrayList;

public class SearchAnnouncements  extends AppCompatActivity {

    EditText et;
    ListView lv;
    Button btnSearch;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_announcements);
        et = (EditText)findViewById(R.id.itemToSearchAnnouncments);
        lv = (ListView)findViewById(R.id.lvAnnouncments);
        btnSearch = (Button)findViewById(R.id.btnAnnouncmentsSearch);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> arrLst = new ArrayList<String>();
        arrLst.add("Date");
        arrLst.add("Type");
        ArrayAdapter adapt = new ArrayAdapter(SearchAnnouncements.this, android.R.layout.simple_list_item_1,arrLst);
        spinner.setAdapter(adapt);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter AL = null;
                String input = et.getText().toString();

                if(spinner.getSelectedItem().equals("Date")){
                    //Toast.makeText(SearchAnnouncements.this, "u entered first name", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchAnnouncements.this,android.R.layout.simple_list_item_1,new AnnouncementsCRUD(SearchAnnouncements.this).searchAnnouncementsByDate(input.toString()));
                }
                else if(spinner.getSelectedItem().equals("Type")){
                    //Toast.makeText(SearchAnnouncements.this, "u entered last name", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchAnnouncements.this,android.R.layout.simple_list_item_1,new AnnouncementsCRUD(SearchAnnouncements.this).searchAnnouncementsByType(input.toString()));
                }
                lv.setAdapter(AL);
            }
        });



    }
}
