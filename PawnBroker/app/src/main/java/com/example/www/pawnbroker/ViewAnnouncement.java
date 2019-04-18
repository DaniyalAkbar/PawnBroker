package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.AnnouncementsCRUD;
import com.example.www.CRUD.PaymentCRUD;

public class ViewAnnouncement extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_forall);
        lv=(ListView)findViewById(R.id.lv);
        ArrayAdapter ap = new ArrayAdapter(ViewAnnouncement.this,android.R.layout.simple_list_item_1,new AnnouncementsCRUD(ViewAnnouncement.this).viewAllAnnouncements());
        lv.setAdapter(ap);
    }
}
