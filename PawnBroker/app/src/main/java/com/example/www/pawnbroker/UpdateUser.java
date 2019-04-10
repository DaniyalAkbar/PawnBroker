package com.example.www.pawnbroker;

import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.UserCRUD;
import com.example.www.model.users;

public class UpdateUser extends AppCompatActivity {
    Button UserSubmitBtn;
    EditText userid,fname,lname,regdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_user);
        UserSubmitBtn=(Button)findViewById(R.id.UserSubmitBtn);
        userid=(EditText)findViewById(R.id.txtUserID);
        fname=(EditText)findViewById(R.id.txtFirstName);
        lname=(EditText)findViewById(R.id.txtLastName);
        regdate=(EditText)findViewById(R.id.txtRegDate);
        UserSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                users u = new users();
                u.setUID(Integer.parseInt(userid.getText().toString()));
                u.setFname(fname.getText().toString());
                u.setLname(lname.getText().toString());
                u.setRegDate(regdate.getText().toString());
                new UserCRUD(UpdateUser.this).update(u);
            }
        });
    }
}
