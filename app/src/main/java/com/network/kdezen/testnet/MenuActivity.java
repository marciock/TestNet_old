package com.network.kdezen.testnet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {

    private LinearLayout ping;
    private LinearLayout scan;
    private LinearLayout config;
    private LinearLayout test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ping =(LinearLayout) findViewById(R.id.LayoutPing);
        scan=(LinearLayout)findViewById(R.id.LayoutScan);
        config=(LinearLayout)findViewById(R.id.LayoutConfig);
        test=(LinearLayout)findViewById(R.id.LayoutConfig);
        MediaKdezen mediaKdezen=new MediaKdezen();

        mediaKdezen.runActivity(com.network.kdezen.testnet.PingActivity.class,this,R.id.LayoutPing,"menu","1");
        mediaKdezen.runActivity(com.network.kdezen.testnet.ConfigActivity.class,this,R.id.LayoutConfig,"menu","2");
        mediaKdezen.runActivity(com.network.kdezen.testnet.ScanActivity.class,this,R.id.LayoutScan,"menu","3");
        mediaKdezen.runActivity(com.network.kdezen.testnet.PingActivity.class,this,R.id.LayoutTest,"menu","4");
    }
}
