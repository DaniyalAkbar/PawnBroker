package com.example.www.pawnbroker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);

                } catch (Exception e)
                {

                }finally {
                    startActivity(new Intent(Splash.this,MainActivity.class));
                    finish();
                }
            }
        }).start();

    }
}
