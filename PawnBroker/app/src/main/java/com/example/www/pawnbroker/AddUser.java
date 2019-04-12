package com.example.www.pawnbroker;

<<<<<<< HEAD
import android.content.DialogInterface;
=======
>>>>>>> master
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
<<<<<<< HEAD
        AddUserBtnButton=(Button)findViewById(R.id.txtUserSubmitBtn);
=======
        AddUserBtnButton=(Button)findViewById(R.id.addUserBtn);
>>>>>>> master
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
<<<<<<< HEAD
                    ShowDialog("New User Added Successfully");

                }catch (java.text.ParseException e){
                    ShowDialog("Incorrect Date Format. Please Try Again");

=======
                    AlertDialog.Builder AD = new AlertDialog.Builder(AddUser.this);
                    AD.setTitle("User Added");
                    AD.setMessage("New User Added Successfully to Database");
                }catch (java.text.ParseException e){
                    Toast.makeText(AddUser.this, "Incorrect Date Format", Toast.LENGTH_SHORT).show();
>>>>>>> master
                    e.printStackTrace();
                }
            }
        });
    }
<<<<<<< HEAD
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
=======
>>>>>>> master
}
