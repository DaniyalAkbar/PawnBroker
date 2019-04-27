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

import com.example.www.CRUD.TestimonialCRUD;
import com.example.www.CRUD.UserCRUD;
import com.example.www.model.testimonial;
import com.example.www.model.users;
import com.example.www.pawnbroker.R;
import com.example.www.pawnbroker.UpdateTestimonial;
import com.example.www.pawnbroker.UpdateUser;

import java.util.ArrayList;

public class TestimonialAdapter extends BaseAdapter {
    Context context;
    ArrayList<testimonial> items;
    String s;
    public TestimonialAdapter(Context context, ArrayList<testimonial> items, String s){
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
                    inflate(R.layout.adapter_testimonials, parent, false);
        }

        // get current item to be displayed
        final testimonial currentItem = (testimonial)getItem(position);

        // get the TextView for item name and item description
        TextView txtTestID = (TextView)
                convertView.findViewById(R.id.txtTestimonialID);
        TextView txtTestTestim = (TextView)
                convertView.findViewById(R.id.txtTestimonialTestim);

        TextView txtTestTestiUID = (TextView)
                convertView.findViewById(R.id.txtTestimonialUID);
        TextView txtTestmonialDate = (TextView)convertView.findViewById(R.id.txtTestimonialDate);
        final Button btn=(Button)convertView.findViewById(R.id.btn_Testimonial);
        btn.setText(s);


        txtTestID.setText(String.valueOf(currentItem.getTid()));
        txtTestTestim.setText(String.valueOf(currentItem.getTestimonial()));
        txtTestTestiUID.setText(String.valueOf(String.valueOf(currentItem.getUid())));
        txtTestmonialDate.setText(String.valueOf(currentItem.getAdate()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn.getText().toString().equalsIgnoreCase("update")){

                    Intent i = new Intent(context, UpdateTestimonial.class);
                    i.putExtra("TID",String.valueOf(currentItem.getTid()));
                    i.putExtra("TESTIMONIAL",currentItem.getTestimonial());
                    i.putExtra("USERID",String.valueOf(currentItem.getUid()));
                    i.putExtra("TESTDATE",currentItem.getAdate());
                    context.startActivity(i);



                }
                else if(btn.getText().toString().equalsIgnoreCase("delete")){
                    new TestimonialCRUD(context).deleteTestimonial(currentItem.getTid());
                    items.remove(getItem(position));
                    notifyDataSetChanged();
                    if(getCount()==0){
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

