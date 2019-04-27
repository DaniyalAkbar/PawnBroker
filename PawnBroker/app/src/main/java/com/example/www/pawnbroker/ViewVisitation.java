package com.example.www.pawnbroker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.UserCRUD;
import com.example.www.CRUD.VisitationCRUD;
import com.example.www.adapter.UserAdapter;
import com.example.www.adapter.VisitationAdapter;

public class ViewVisitation extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_forall);
        lv=(ListView)findViewById(R.id.lv);
        VisitationAdapter AL = new VisitationAdapter(this,new VisitationCRUD(this).viewAllVisitation(),"update");
        lv.setAdapter(AL);
        BroadcastReceiver broadcast_reciever = new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent intent) {
                String action = intent.getAction();
                if (action.equals("refresh")) {

                    lv.setAdapter(null);
                    VisitationAdapter AL = new VisitationAdapter(ViewVisitation.this,new VisitationCRUD( ViewVisitation.this).viewAllVisitation(),"update");
                    lv.setAdapter(AL);

                }
            }
        };
    }
}
