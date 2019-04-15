package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter AL = null;
                String input = et.getText().toString().trim();

                if(spinner.getSelectedItem().equals("Registration ID")){
                    Toast.makeText(SearchTransactions.this, "u entered ID", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchTransactions.this,android.R.layout.simple_list_item_1,new TransactionCRUD(SearchTransactions.this).searchTransactionByID(Integer.parseInt(input)));
                }
                else if(spinner.getSelectedItem().equals("Registration Date")){
                    Toast.makeText(SearchTransactions.this, "u entered date", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchTransactions.this,android.R.layout.simple_list_item_1,new TransactionCRUD(SearchTransactions.this).searchTransactionByDate(input.toString()));
                }
                lv.setAdapter(AL);
            }
        });



    }
}
