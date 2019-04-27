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

import com.example.www.CRUD.AnnouncementsCRUD;
import com.example.www.CRUD.UserCRUD;
import com.example.www.model.announcements;
import com.example.www.model.users;
import com.example.www.pawnbroker.AddAnnouncement;
import com.example.www.pawnbroker.R;
import com.example.www.pawnbroker.UpdateAnnouncement;
import com.example.www.pawnbroker.UpdateUser;

import java.util.ArrayList;

public class AnnouncementAdapter extends BaseAdapter {
    Context context;
    ArrayList<announcements> items;
    String s;
    public AnnouncementAdapter(Context context, ArrayList<announcements> items, String s){
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
                    inflate(R.layout.adapter_announcements, parent, false);
        }


        // get current item to be displayed
        final announcements currentItem = (announcements) getItem(position);

        // get the TextView for item name and item description
        TextView txtAID = (TextView)
                convertView.findViewById(R.id.txtAnnouncmentID);
        TextView txtAnnouncement = (TextView)
                convertView.findViewById(R.id.txtAnnouncmentAnnounce);

        TextView txtAnouoncementType = (TextView)
                convertView.findViewById(R.id.txtAnnouncmentType);
        TextView txtADate = (TextView)convertView.findViewById(R.id.txtAnnouncmentDate);
        final Button btn=(Button)convertView.findViewById(R.id.btn_Announcment);
        btn.setText(s);


        txtAID.setText(String.valueOf(currentItem.getAID()));
        txtAnnouncement.setText(String.valueOf(currentItem.getAnnouncement()));
        txtAnouoncementType.setText(String.valueOf(currentItem.getType()));
        txtADate.setText(String.valueOf(currentItem.getDate()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn.getText().toString().equalsIgnoreCase("update")){

                    Intent i = new Intent(context, UpdateAnnouncement.class);
                    i.putExtra("AID",String.valueOf(currentItem.getAID()));
                    i.putExtra("ANNOUNCEMENT",currentItem.getAnnouncement());
                    i.putExtra("TYPE",currentItem.getType());
                    i.putExtra("ADATE",currentItem.getDate());
                    context.startActivity(i);


                }
                else if(btn.getText().toString().equalsIgnoreCase("delete")){
                    new AnnouncementsCRUD(context).delete(currentItem.getAID());
                    items.remove(getItem(position));
                    notifyDataSetChanged();
                    if (getCount() == 0) {
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
