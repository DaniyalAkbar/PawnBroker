package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.www.CRUD.UserCRUD;
import com.example.www.model.users;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class AddUser extends AppCompatActivity {
    Button AddUserBtnButton;
    EditText FirstName,LastName,RegDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);
        AddUserBtnButton=(Button)findViewById(R.id.txtUserSubmitBtn);
        FirstName=(EditText)findViewById(R.id.txtFirstName);
        LastName=(EditText)findViewById(R.id.txtLastName);
        RegDate=(EditText)findViewById(R.id.txtRegDate);
        AddUserBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    users u= new users();
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    u.setFname(FirstName.getText().toString());
                    u.setLname(LastName.getText().toString());
                    u.setRegDate(fm.parse(RegDate.getText().toString()).toString());
                    new UserCRUD(AddUser.this).add(u);
                    ShowDialog("New User Added Successfully");

                }catch (java.text.ParseException e){
                    ShowDialog("Incorrect Date Format. Please Try Again");

                    e.printStackTrace();
                }
            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(AddUser.this);
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
