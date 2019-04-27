package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.www.CRUD.TransactionCRUD;

import java.util.ArrayList;

public class SearchTransactions extends AppCompatActivity {

    EditText et;
    ListView lv;
    Button btnSearch;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_transactions);
        et = (EditText)findViewById(R.id.itemToSearchTransactions);
        lv = (ListView)findViewById(R.id.lvTransactions);
        btnSearch = (Button)findViewById(R.id.btnTransactionsSearch);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> arrLst = new ArrayList<String>();
        arrLst.add("Registration ID");
        arrLst.add("Registration Date");
        ArrayAdapter adapt = new ArrayAdapter(SearchTransactions.this, android.R.layout.simple_list_item_1,arrLst);
        spinner.setAdapter(adapt);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(spinner.getSelectedItem().equals("Registration ID")){
                    et.setInputType(InputType.TYPE_CLASS_NUMBER);
                    et.setInputType(InputType.TYPE_CLASS_PHONE);
                }
                else if(spinner.getSelectedItem().equals("Registration Date")){
                    et.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter AL = null;
                String input = et.getText().toString().trim();

                if(spinner.getSelectedItem().equals("Registration ID")){
                    AL = new ArrayAdapter(SearchTransactions.this,android.R.layout.simple_list_item_1,new TransactionCRUD(SearchTransactions.this).searchTransactionByID(Integer.parseInt(input)));

                }
                else if(spinner.getSelectedItem().equals("Registration Date")){
                    AL = new ArrayAdapter(SearchTransactions.this,android.R.layout.simple_list_item_1,new TransactionCRUD(SearchTransactions.this).searchTransactionByDate(input.toString()));

                }

                if(AL.getCount()>0) {
                    lv.setAdapter(AL);
                }else{
                    ShowDialog("No records found!");
                }
            }
        });

   }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(SearchTransactions.this);
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
