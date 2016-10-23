package com.network.kdezen.testnet;

import java.io.OutputStream;


import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class PingActivity extends AppCompatActivity {

    private Button btnPing;
    private TextView textView;
    private EditText txtIp;
    private Editable host;

    ArrayList<String> ipList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping);

        txtIp=(EditText) findViewById(R.id.editIP);

        textView=(TextView) findViewById(R.id.TextPing);

        btnPing=(Button) findViewById(R.id.buttonGetPing);


        btnPing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myping;

                myping=ping(txtIp.getText().toString());

                textView.append("\n"+myping);
            }
        });




    }


public String ping(String url){
    String str="";

    try{
        java.lang.Process process=Runtime.getRuntime().exec("/system/bin/ping -c 8 "+url);

        BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));

        int i;
        char[] buffer=new char[4096];
        StringBuffer output=new StringBuffer();

        while((i=reader.read(buffer))>0)
            output.append(buffer,0,i);
        reader.close();

        str=output.toString();


    } catch (IOException e) {
        e.printStackTrace();
    }

    return str;

}


}
