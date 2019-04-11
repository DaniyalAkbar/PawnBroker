package com.example.www.pawnbroker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.www.DB.Db;

public class MainActivity extends AppCompatActivity {
    Button user,employee,visitation,transactions,testimonial,announcements,payments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Db d = new Db(MainActivity.this);
        d.OpenorCreatDB();
        d.createtables();
        user=(Button)findViewById(R.id.btnUsers);
        employee= (Button)findViewById(R.id.btnEmployee);
        visitation=(Button)findViewById(R.id.btnVisitation);
        transactions=(Button)findViewById(R.id.btnTransactions);
        testimonial=(Button)findViewById(R.id.btnTestimonial);
        announcements=(Button)findViewById(R.id.btnAnnouncments);
        payments=(Button) findViewById(R.id.btnPayments);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UserMainMenu.class));
            }
        });
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,EmployeeMainMenu.class));
            }
        });
        visitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(MainActivity.this,VisitationMainMenu.class));
            }
        });
        transactions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TransactionMainMenu.class));
            }
        });
        testimonial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,TestimonialMainMenu.class));
            }
        });
        payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PaymentMainMenu.class));
            }
        });
        announcements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AnnouncementMainMenu.class));
            }
        });



    }
}
