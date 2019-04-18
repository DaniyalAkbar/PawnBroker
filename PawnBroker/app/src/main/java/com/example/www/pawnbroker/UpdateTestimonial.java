package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.TestimonialCRUD;
import com.example.www.model.testimonial;

import java.text.SimpleDateFormat;

public class UpdateTestimonial extends AppCompatActivity {
    Button AddTestimonialBtnButton;
    EditText Testimonial,TDate,UID,TestID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_testimonial);
        AddTestimonialBtnButton=(Button)findViewById(R.id.txtTestimonialSubmitBtn);
        TestID=(EditText) findViewById(R.id.txtTestimonialID);
        Testimonial=(EditText)findViewById(R.id.txtTestimonial);
        TDate=(EditText)findViewById(R.id.txtDateTestimonial);
        UID=(EditText)findViewById(R.id.txtUIDFk);
        UID.setInputType(InputType.TYPE_CLASS_NUMBER);
        UID.setInputType(InputType.TYPE_CLASS_PHONE);
        TestID.setInputType(InputType.TYPE_CLASS_NUMBER);
        TestID.setInputType(InputType.TYPE_CLASS_PHONE);

        AddTestimonialBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    testimonial t= new testimonial();
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    t.setTid(Integer.parseInt(TestID.getText().toString()));
                    t.setTestimonial(Testimonial.getText().toString());
                    t.setUid(Integer.parseInt(UID.getText().toString()));
                    t.setAdate(TDate.getText().toString());
                    new TestimonialCRUD(UpdateTestimonial.this).updateTestimonial(t);
                    ShowDialog("New Testimonial Added Successfully");

                }catch (Exception e){
                    ShowDialog(e.getMessage());
                }
            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(UpdateTestimonial.this);
        AD.setTitle("PawnBroker");
        AD.setMessage(Message);
        AD.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AD.show();
    }
}
