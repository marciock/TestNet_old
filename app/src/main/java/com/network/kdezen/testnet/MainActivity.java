package com.network.kdezen.testnet;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler=new Handler();
        handler.postDelayed(this, 3000);

    }

    public void run() {
        // TODO Auto-generated method stub
        startActivity(new Intent(this, com.network.kdezen.testnet.MenuActivity.class));

        finish();

    }

}
