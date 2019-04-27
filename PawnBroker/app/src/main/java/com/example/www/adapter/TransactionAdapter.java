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

import com.example.www.CRUD.TransactionCRUD;

import com.example.www.model.transaction;
import com.example.www.pawnbroker.R;
import com.example.www.pawnbroker.UpdateTransaction;

import java.util.ArrayList;

public class TransactionAdapter extends BaseAdapter {
    Context context;
    ArrayList<transaction> items;
    String s;
    public TransactionAdapter(Context context, ArrayList<transaction> items, String s){
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
                    inflate(R.layout.adapter_transaction, parent, false);
        }

        // get current item to be displayed
        final transaction currentItem = (transaction) getItem(position);

        // get the TextView for item name and item description
        TextView txtTrid = (TextView)
                convertView.findViewById(R.id.txtTransactionID);
        TextView txtAmount = (TextView)
                convertView.findViewById(R.id.txtTransactionAmount);

        TextView txtType = (TextView)
                convertView.findViewById(R.id.txtTransactionType);
        TextView txtDate = (TextView)convertView.findViewById(R.id.txtTransactionDate);
        final Button btn=(Button)convertView.findViewById(R.id.btn_Transaction);
        btn.setText(s);


        txtTrid.setText(String.valueOf(currentItem.getTrID()));
        txtAmount.setText(String.valueOf(currentItem.getAmount()));
        txtType.setText(String.valueOf(currentItem.getType()));
        txtDate.setText(String.valueOf(currentItem.getTdate()));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btn.getText().toString().equalsIgnoreCase("update")){

                    Intent i = new Intent(context, UpdateTransaction.class);
                    i.putExtra("TRID",String.valueOf(currentItem.getTrID()));
                    i.putExtra("AMOUNT",String.valueOf(currentItem.getAmount()));
                    i.putExtra("TYPE",String.valueOf(currentItem.getType()));
                    i.putExtra("TDATE",currentItem.getTdate());
                    context.startActivity(i);


                }
                else if(btn.getText().toString().equalsIgnoreCase("delete")){
                    new TransactionCRUD(context).deleteTransaction(currentItem.getTrID());
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
