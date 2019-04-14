package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.TestimonialCRUD;
import com.example.www.CRUD.VisitationCRUD;

public class ViewTestimonial extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_forall);
        lv=(ListView)findViewById(R.id.lvUsers);
        ArrayAdapter ap = new ArrayAdapter(ViewTestimonial.this,android.R.layout.simple_list_item_1,new TestimonialCRUD(ViewTestimonial.this).viewAllTestimonial());
        lv.setAdapter(ap);
    }
}
