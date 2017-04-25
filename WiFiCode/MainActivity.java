package com.bmpl.wifiapp;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifiManager = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        aSwitch = (Switch)findViewById(R.id.aSwitch);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(!wifiManager.isWifiEnabled()){
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(MainActivity.this, "Wifi Enabled", Toast.LENGTH_SHORT).show();
                }
                else {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(MainActivity.this, "Wifi Disabled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
