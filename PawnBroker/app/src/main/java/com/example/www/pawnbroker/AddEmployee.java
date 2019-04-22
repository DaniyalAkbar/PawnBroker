package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.EmployeeCRUD;
import com.example.www.CRUD.UserCRUD;
import com.example.www.model.employee;

import java.text.SimpleDateFormat;

public class AddEmployee extends AppCompatActivity {
    Button AddEmployeeBtnButton;
    EditText FirstName,LastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employee);
        AddEmployeeBtnButton=(Button)findViewById(R.id.txtEmployeeSubmitBtn);
        FirstName=(EditText)findViewById(R.id.txtFirstName);
        LastName=(EditText)findViewById(R.id.txtLastName);

        AddEmployeeBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    employee e= new employee();
                    e.setFname(FirstName.getText().toString());
                    e.setLname(LastName.getText().toString());
                    new EmployeeCRUD(AddEmployee.this).addEmployee(e);
                    ShowDialog("New Employee Added Successfully");

                }catch (Exception e){
                    ShowDialog(e.getMessage());

                    e.printStackTrace();
                }
            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(AddEmployee.this);
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
