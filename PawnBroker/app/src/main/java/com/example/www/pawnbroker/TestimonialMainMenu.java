package com.example.www.pawnbroker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TestimonialMainMenu extends AppCompatActivity {
    Button addbtn,viewbtn,updatebtn,deletebtn,searchbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_testimonial);
        addbtn=(Button)findViewById(R.id.addTestimonialBtn);
        viewbtn=(Button)findViewById(R.id.viewTestimonialBtn);
        deletebtn=(Button)findViewById(R.id.deleteTestimonialBtn);
        searchbtn=(Button)findViewById(R.id.searchTestimonialBtn);
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestimonialMainMenu.this,DeleteTestimonial.class));
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestimonialMainMenu.this,AddTestimonial.class));
            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestimonialMainMenu.this,ViewTestimonial.class));
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestimonialMainMenu.this,SearchTestimonials.class));
            }
        });



    }
}
