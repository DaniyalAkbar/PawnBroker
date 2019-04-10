package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.www.CRUD.UserCRUD;

public class DeleteUser extends AppCompatActivity {
    Button btnUserDelete;
    EditText txtDeleteID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_user);
        btnUserDelete=(Button)findViewById(R.id.btnUserDelete);
        txtDeleteID=(EditText)findViewById(R.id.txtDeleteUserID);
        btnUserDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int getID = Integer.parseInt(txtDeleteID.getText().toString());
                    new UserCRUD(DeleteUser.this).deleteByID(getID);
                }catch (Exception e){
                    Toast.makeText(DeleteUser.this, "please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
