package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.EmployeeCRUD;
import com.example.www.model.employee;

public class UpdateEmployee extends AppCompatActivity {
    Button AddEmployeeBtnButton;
    EditText FirstName,LastName,Empid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_employee);
        Empid=(EditText)findViewById(R.id.empid);
        AddEmployeeBtnButton=(Button)findViewById(R.id.txtEmployeeSubmitBtn);
        FirstName=(EditText)findViewById(R.id.txtFirstName);
        LastName=(EditText)findViewById(R.id.txtLastName);
        Empid.setInputType(InputType.TYPE_CLASS_NUMBER);
        Empid.setInputType(InputType.TYPE_CLASS_PHONE);
        Empid.setText(getIntent().getStringExtra("EMPID"));
        FirstName.setText(getIntent().getStringExtra("FNAME"));
        LastName.setText(getIntent().getStringExtra("LNAME"));
        Empid.setEnabled(false);


        AddEmployeeBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(Empid.getText().length()!=0 && FirstName.getText().length()!=0 && LastName.getText().length()!=0) {
                        employee e = new employee();
                        e.setEmpid(Integer.parseInt(Empid.getText().toString()));
                        e.setFname(FirstName.getText().toString());
                        e.setLname(LastName.getText().toString());
                        new EmployeeCRUD(UpdateEmployee.this).updateEmployee(e);
                        ShowDialog("Employee Updated Successfully");
                        Intent i = new Intent("refresh");
                        sendBroadcast(i);
                    }


                }catch (Exception e){
                    ShowDialog(e.getMessage());

                    e.printStackTrace();
                }
            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(UpdateEmployee.this);
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
