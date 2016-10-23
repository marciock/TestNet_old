package com.network.kdezen.testnet;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class ConfigActivity extends AppCompatActivity {

    private TextView textConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

     //   MediaKdezen mediaKdezen=new MediaKdezen();


        textConfig=(TextView)findViewById(R.id.textConfig);


        WifiManager wifiManager=(WifiManager) this.getSystemService(Context.WIFI_SERVICE);

        DhcpInfo dhcpInfo=wifiManager.getDhcpInfo();

        int dns1=dhcpInfo.dns1;
        int dns2=dhcpInfo.dns2;
        int gate=dhcpInfo.gateway;
        int ipadress=dhcpInfo.ipAddress;
        int inetmask=dhcpInfo.netmask;



     // String teste= String.format("%d.%d.%d.%d",(inetmask & 0xff),(inetmask >> 8 & 0xff),(inetmask >> 16 & 0xff),(inetmask >> 24 & 0xff));

        textConfig.append("\n Gateway: "+formatNet(gate));
        textConfig.append("\n Netmask: "+formatNet(inetmask));
        textConfig.append("\n IP Adress: "+formatNet(ipadress));
        textConfig.append("\n DNS1 :"+formatNet(dns1));
        textConfig.append("\n DNS2 :"+formatNet(dns2));



/*
//Testa configuração rede wifi
        DhcpInfo d;
        WifiManager wifii;
       Context mContext = null;


       wifii=(WifiManager) getSystemService(Context.WIFI_SERVICE);

       d=wifii.getDhcpInfo();

       String t_dns1="\n DNS 1: "+String.valueOf(d.dns1);
       String t_dns2="\n DNS 2: "+String.valueOf(d.dns2);
       String t_gateway="Gateway: "+String.valueOf(d.gateway);
        String t_ipadress="IP Adress: "+String.valueOf(d.ipAddress);
        String t_mask="Subnet Mask: "+String.valueOf(d.gateway);




        //

*/




    }

    public static String formatNet(int paramff){

        String retorna= String.format("%d.%d.%d.%d",(paramff & 0xff),(paramff >> 8 & 0xff),(paramff >> 16 & 0xff),(paramff >> 24 & 0xff));

        return retorna;


    }



}
