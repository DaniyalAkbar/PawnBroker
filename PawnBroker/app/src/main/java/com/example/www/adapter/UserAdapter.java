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

import com.example.www.CRUD.UserCRUD;
import com.example.www.model.users;
import com.example.www.pawnbroker.R;
import com.example.www.pawnbroker.UpdateUser;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    Context context;
    ArrayList<users> items;
    String s;
    public UserAdapter(Context context, ArrayList<users> items, String s){
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
                    inflate(R.layout.adapter_user, parent, false);
        }

        // get current item to be displayed
        final users currentItem = (users) getItem(position);

        // get the TextView for item name and item description
        TextView txtUserID = (TextView)
                convertView.findViewById(R.id.txtUserID);
        TextView txtFname = (TextView)
                convertView.findViewById(R.id.txtUserFname);

        TextView txtUserLname = (TextView)
                convertView.findViewById(R.id.txtUserLname);
        TextView txtUserregdate = (TextView)convertView.findViewById(R.id.txtUserregDate);
        final Button btn=(Button)convertView.findViewById(R.id.btn_User);
        btn.setText(s);


                txtUserID.setText(String.valueOf(currentItem.getUID()));
                txtFname.setText(String.valueOf(currentItem.getFname()));
                txtUserLname.setText(String.valueOf(currentItem.getLname()));
                txtUserregdate.setText(String.valueOf(currentItem.getRegDate()));
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(btn.getText().toString().equalsIgnoreCase("update")){

                            Intent i = new Intent(context,UpdateUser.class);
                            i.putExtra("UID",String.valueOf(currentItem.getUID()));
                            i.putExtra("FNAME",currentItem.getFname());
                            i.putExtra("LNAME",currentItem.getLname());
                            i.putExtra("REGDATE",currentItem.getRegDate());
                            context.startActivity(i);


                        }
                        else if(btn.getText().toString().equalsIgnoreCase("delete")){
                            new UserCRUD(context).deleteByID(currentItem.getUID());
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

