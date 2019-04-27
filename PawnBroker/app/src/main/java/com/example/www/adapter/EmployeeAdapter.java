package com.example.www.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.www.CRUD.EmployeeCRUD;
import com.example.www.CRUD.UserCRUD;
import com.example.www.model.employee;
import com.example.www.model.users;
import com.example.www.pawnbroker.R;
import com.example.www.pawnbroker.UpdateEmployee;
import com.example.www.pawnbroker.UpdateUser;

import java.util.ArrayList;

public class EmployeeAdapter extends BaseAdapter {
    Context context;
    ArrayList<employee> items;
    String s;
    public EmployeeAdapter(Context context, ArrayList<employee> items, String s){
        this.context=context;
        this.items=items;
        this.s=s;
    }

    //public constructor

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.adapter_employee, parent, false);
        }


        // get current item to be displayed
        final employee currentItem = (employee) getItem(position);

        // get the TextView for item name and item description
        TextView txtEmpID = (TextView)
                convertView.findViewById(R.id.txtEmpID);
        TextView txtFname = (TextView)
                convertView.findViewById(R.id.txtEmpFname);

        TextView txtLname = (TextView)
                convertView.findViewById(R.id.txtEmpLname);
        final Button btn=(Button)convertView.findViewById(R.id.btn_Employee);
        btn.setText(s);


                txtEmpID.setText(String.valueOf(currentItem.getEmpid()));
                txtFname.setText(String.valueOf(currentItem.getFname()));
                txtLname.setText(String.valueOf(currentItem.getLname()));

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(btn.getText().toString().equalsIgnoreCase("update")){

                            Intent i = new Intent(context, UpdateEmployee.class);
                            i.putExtra("EMPID",String.valueOf(currentItem.getEmpid()));
                            i.putExtra("FNAME",currentItem.getFname());
                            i.putExtra("LNAME",currentItem.getLname());
                            context.startActivity(i);


                        }
                        else if(btn.getText().toString().equalsIgnoreCase("delete")){
                            new EmployeeCRUD(context).deleteEmployee(currentItem.getEmpid());
                            items.remove(getItem(position));
                            notifyDataSetChanged();
                            if(getCount()==0) {
                                ShowDialog("All Records Deleted!");
                            }
                        }
                    }
                });
        // returns the view for the current row
        return convertView;
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(context);
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

