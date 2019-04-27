package com.example.www.pawnbroker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.AnnouncementsCRUD;
import com.example.www.CRUD.PaymentCRUD;
import com.example.www.CRUD.UserCRUD;
import com.example.www.adapter.AnnouncementAdapter;
import com.example.www.adapter.UserAdapter;

public class ViewAnnouncement extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_forall);
        lv=(ListView)findViewById(R.id.lv);
        AnnouncementAdapter ap = new AnnouncementAdapter(ViewAnnouncement.this,new AnnouncementsCRUD(ViewAnnouncement.this).viewAllAnnouncements(),"update");
        lv.setAdapter(ap);
        BroadcastReceiver broadcast_reciever = new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent intent) {
                String action = intent.getAction();
                if (action.equals("refresh")) {

                    lv.setAdapter(null);
                    AnnouncementAdapter ap = new AnnouncementAdapter(ViewAnnouncement.this,new AnnouncementsCRUD(ViewAnnouncement.this).viewAllAnnouncements(),"update");
                    lv.setAdapter(ap);

                }
            }
        };
        registerReceiver(broadcast_reciever, new IntentFilter("refresh"));
    }
}
