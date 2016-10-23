package com.network.kdezen.testnet;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;

public class ScanActivity extends AppCompatActivity {
    private Button btnScan;
    private ListView listViewIP;
    private TextView textView;

    private static String breakIp;
    ArrayList<String> ipList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);


        MediaKdezen mediaKdezen=new MediaKdezen();


        btnScan = (Button) findViewById(R.id.btScanIP);
        listViewIP = (ListView) findViewById(R.id.ListScanIP);
        textView=(TextView) findViewById(R.id.textScan);
        ipList = new ArrayList();


        try {
            textView.setText(mediaKdezen.ip().getHostAddress());




           breakIp=mediaKdezen.ip().getHostAddress().substring(0,(mediaKdezen.ip().getHostAddress().length()-3));


       } catch (SocketException e) {
          e.printStackTrace();
       }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, ipList);

        listViewIP.setAdapter(adapter);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new ScanIpTask().execute();

            }
        });


    }
    private class ScanIpTask extends AsyncTask<Void, String, Void> {




        final String subnet = breakIp.toString();

       // static final String subnet="192.168.1.";
        static final int lower = 1;
        static final int upper = 110;
        static final int timeout = 500;

        @Override
        protected Void doInBackground(Void... params) {

            for (int i = lower; i <= upper; i++) {
                String host = subnet + i;




                try {
                    InetAddress inetAddress = InetAddress.getByName(host);
                    if (inetAddress.isReachable(timeout)) {
                        publishProgress(inetAddress.toString());
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            ipList.clear();
            adapter.notifyDataSetInvalidated();

            Toast.makeText(ScanActivity.this, "Escaneando IP...", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(String... values) {

            ipList.add(values[0]);
            adapter.notifyDataSetInvalidated();
            Toast.makeText(ScanActivity.this, values[0], Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            Toast.makeText(ScanActivity.this, "Nenhuma Rede", Toast.LENGTH_LONG).show();
        }
    }



}
