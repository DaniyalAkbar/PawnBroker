package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.VisitationCRUD;

public class ViewVisitation extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_forall);
        lv=(ListView)findViewById(R.id.lvUsers);
        ArrayAdapter ap = new ArrayAdapter(ViewVisitation.this,android.R.layout.simple_list_item_1,new VisitationCRUD(ViewVisitation.this).viewAllVisitation());
        lv.setAdapter(ap);
    }
}
