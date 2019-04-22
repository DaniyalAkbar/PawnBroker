package com.example.www.pawnbroker;

import android.os.Bundle;
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

import com.example.www.CRUD.PaymentCRUD;

import java.util.ArrayList;

public class SearchPayment extends AppCompatActivity {

    EditText et;
    ListView lv;
    Button btnSearch;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_payment);
        et = (EditText)findViewById(R.id.itemToSearchPayment);
        lv = (ListView)findViewById(R.id.lvPayment);
        btnSearch = (Button)findViewById(R.id.btnPaymentSearch);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> arrLst = new ArrayList<String>();
        arrLst.add("Payment Date");
        arrLst.add("Payment Type");
        arrLst.add("Transaction ID");
        ArrayAdapter adapt = new ArrayAdapter(SearchPayment.this, android.R.layout.simple_list_item_1,arrLst);
        spinner.setAdapter(adapt);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                if(spinner.getSelectedItem().equals("Payment Date")){
                    // Toast.makeText(SearchPayment.this, "u entered Payment Date", Toast.LENGTH_SHORT).show();

                    et.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else if(spinner.getSelectedItem().equals("Payment Type")){
                    //Toast.makeText(SearchPayment.this, "u entered Payment Type", Toast.LENGTH_SHORT).show();
                    et.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else if(spinner.getSelectedItem().equals("Transaction ID")){
                    //Toast.makeText(SearchPayment.this, "u entered Transaction ID", Toast.LENGTH_SHORT).show();
                    et.setInputType(InputType.TYPE_CLASS_NUMBER);
                    et.setInputType(InputType.TYPE_CLASS_PHONE);
                }


            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter AL = null;
                String input = et.getText().toString().trim();

                if(spinner.getSelectedItem().equals("Payment Date")){
                   // Toast.makeText(SearchPayment.this, "u entered Payment Date", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchPayment.this,android.R.layout.simple_list_item_1,new PaymentCRUD(SearchPayment.this).searchPaymentsByDate(input.toString()));
                    et.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else if(spinner.getSelectedItem().equals("Payment Type")){
                    //Toast.makeText(SearchPayment.this, "u entered Payment Type", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchPayment.this,android.R.layout.simple_list_item_1,new PaymentCRUD(SearchPayment.this).searchPaymentsByType(input.toString()));
                }
                else if(spinner.getSelectedItem().equals("Transaction ID")){
                    //Toast.makeText(SearchPayment.this, "u entered Transaction ID", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchPayment.this,android.R.layout.simple_list_item_1,new PaymentCRUD(SearchPayment.this).searchPaymentsByTransaction(Integer.parseInt(input)));
                }
                lv.setAdapter(AL);
            }
        });



    }
}
