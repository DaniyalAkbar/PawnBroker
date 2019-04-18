package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.UserCRUD;
import com.example.www.model.users;

import java.text.SimpleDateFormat;

public class UpdateUser extends AppCompatActivity {
    Button AddUserBtnButton;
    EditText FirstName,LastName,RegDate,UserID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_user);
        AddUserBtnButton=(Button)findViewById(R.id.updateUserSubmitBtn);
        UserID=(EditText)findViewById(R.id.txtUserID);
        FirstName=(EditText)findViewById(R.id.txtFirstName);
        LastName=(EditText)findViewById(R.id.txtLastName);
        RegDate=(EditText)findViewById(R.id.txtRegDate);
        UserID.setInputType(InputType.TYPE_CLASS_NUMBER);
        UserID.setInputType(InputType.TYPE_CLASS_PHONE);
        AddUserBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    users u= new users();
                    SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                    u.setUID(Integer.parseInt(UserID.getText().toString()));
                    u.setFname(FirstName.getText().toString());
                    u.setLname(LastName.getText().toString());
                    u.setRegDate(fm.parse(RegDate.getText().toString()).toString());
                    new UserCRUD(UpdateUser.this).update(u);
                    ShowDialog("User Updated Successfully");

                }catch (java.text.ParseException e){
                    ShowDialog("Incorrect Date Format. Please Try Again");

                    e.printStackTrace();
                }
            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(UpdateUser.this);
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
