package com.network.kdezen.testnet;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.DhcpInfo;
import android.net.*;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.LinearLayout;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Created by kdezen on 30/05/16.
 */
public class MediaKdezen {

    public void runActivity(Class<?> className, Activity activity, int id, final String name_parameters_1, final String parameters_1){


        final Intent intent=new Intent(activity,className);
        final Bundle bundle1=new Bundle();
        final Bundle bundle2=new Bundle();
        final Activity finalActivity=activity;

        LinearLayout abre=(LinearLayout) activity.findViewById(id);

        // final Class classe=myClass;

        abre.setClickable(true);
        abre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub



                // Activity activity=new Activity();
                bundle1.putString(name_parameters_1,parameters_1);
                //   bundle2.putString(name_parameters_2,parameters_2);

                intent.putExtras(bundle1);
                // intent.putExtras(bundle2);

                finalActivity.startActivity(intent);

            }
        });


    }


    public void runActivityPlus(Class<?> className,Activity activity,int id, final String name_parameters_1, final String parameters_1,final String name_parameters_2,final String paramaters_2){


        final Intent intent=new Intent(activity,className);
        final Bundle bundle1=new Bundle();
        final Bundle bundle2=new Bundle();
        final Activity finalActivity=activity;

        LinearLayout abre=(LinearLayout) activity.findViewById(id);

        // final Class classe=myClass;

        abre.setClickable(true);
        abre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub



                // Activity activity=new Activity();
                bundle1.putString(name_parameters_1,parameters_1);
                String parameters=paramaters_2;
                bundle2.putString(name_parameters_2,parameters);

                intent.putExtras(bundle1);
                intent.putExtras(bundle2);

                finalActivity.startActivity(intent);

            }
        });


    }


    public void voltar(final Activity activity,int id,final boolean tela){
        LinearLayout sair=(LinearLayout) activity.findViewById(id);
        sair.setClickable(true);



        sair.setOnClickListener(new View.OnClickListener() {


            final Activity newActivity=activity;
            @Override
            public void onClick(View v) {

                if(tela==true) {
                    activity.finish();
                    // MediaHelpers mediaHelpers=new MediaHelpers();
                    //  mediaHelpers.playOnly(activity,R.raw.voltar);

                }else{
                    activity.finish();
                    System.exit(0);
                }

            }
        });

    }


    static InetAddress ip() throws SocketException {
        Enumeration<NetworkInterface> nis =NetworkInterface.getNetworkInterfaces();
        NetworkInterface ni;
        while(nis.hasMoreElements()){
            ni=nis.nextElement();
            if(!ni.isLoopback() && ni.isUp()){
                for(InterfaceAddress ia : ni.getInterfaceAddresses()){
                    if(ia.getAddress().getAddress().length==4){
                        return ia.getAddress();
                    }
                }
            }
        }
        return null;
    }


}