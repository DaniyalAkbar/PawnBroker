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
import com.example.www.CRUD.VisitationCRUD;
import com.example.www.model.announcements;
import com.example.www.model.visitation;
import com.example.www.pawnbroker.R;
import com.example.www.pawnbroker.UpdateAnnouncement;
import com.example.www.pawnbroker.UpdateVisitation;

import java.util.ArrayList;

public class VisitationAdapter extends BaseAdapter {
    Context context;
    ArrayList<visitation> items;
    String s;
    public VisitationAdapter(Context context, ArrayList<visitation> items, String s){
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
                    inflate(R.layout.adapter_visitation, parent, false);
        }

        // get current item to be displayed
        final visitation currentItem = (visitation) getItem(position);

        // get the TextView for item name and item description
        TextView txtVID = (TextView)
                convertView.findViewById(R.id.txtVisitationID);
        TextView txtVisitation = (TextView)
                convertView.findViewById(R.id.txtVisitationvisit);

        TextView txtVisitationEmpid = (TextView)
                convertView.findViewById(R.id.txtVisitationEmpID);
        TextView txtVDate = (TextView)convertView.findViewById(R.id.txtVisitationDate);
        final Button btn=(Button)convertView.findViewById(R.id.btn_Visitation);
        btn.setText(s);


        txtVID.setText(String.valueOf(currentItem.getVid()));
        txtVisitation.setText(String.valueOf(currentItem.getVisitation()));
        txtVisitationEmpid.setText(String.valueOf(currentItem.getEmpid()));
        txtVDate.setText(String.valueOf(currentItem.getVdate()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn.getText().toString().equalsIgnoreCase("update")){

                    Intent i = new Intent(context, UpdateVisitation.class);
                    i.putExtra("VID",String.valueOf(currentItem.getVid()));
                    i.putExtra("VISITATION",currentItem.getVisitation());
                    i.putExtra("EMPID",String.valueOf(currentItem.getEmpid()));
                    i.putExtra("VDATE",currentItem.getVdate());
                    context.startActivity(i);


                }
                else if(btn.getText().toString().equalsIgnoreCase("delete")){
                    new VisitationCRUD(context).deleteVisitation(currentItem.getVid());
                    items.remove(getItem(position));
                    notifyDataSetChanged();
                    if(getCount()==0){
                        ShowDialog("All Records Deleted");
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
