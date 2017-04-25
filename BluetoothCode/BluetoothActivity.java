package com.bmpl.bluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity implements View.OnClickListener{

    Switch aSwitch;
    Button visibleButton, pairDeviceButton;
    ListView listView;
    ArrayAdapter arrayAdapter;

    Set<BluetoothDevice> pairedDevice; //to get the information of paired device


    //to check whether bluetooth driver is available or not, check bluetooth is on or not
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        aSwitch = (Switch)findViewById(R.id.bluetoothSwitch);
        visibleButton = (Button)findViewById(R.id.visibleButton);
        pairDeviceButton = (Button)findViewById(R.id.pairButton);
        listView = (ListView)findViewById(R.id.listView);

        visibleButton.setOnClickListener(this);
        pairDeviceButton.setOnClickListener(this);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(bluetoothAdapter == null){
                    Toast.makeText(BluetoothActivity.this, "No Bluetooth available", Toast.LENGTH_SHORT).show();
                }
                else if(!bluetoothAdapter.isEnabled()){
                   // bluetoothAdapter.enable();
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);
                    Toast.makeText(BluetoothActivity.this, "Turned On", Toast.LENGTH_SHORT).show();
                }
                else if(bluetoothAdapter.isEnabled()){
                    bluetoothAdapter.disable();
                    Toast.makeText(BluetoothActivity.this, "Turned Off", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(BluetoothAdapter.Action);
                    //startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.visibleButton:
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, "3000");
                startActivity(intent);
                break;

            case R.id.pairButton:

                pairedDevice = bluetoothAdapter.getBondedDevices();
                ArrayList arrayList = new ArrayList();

                for(BluetoothDevice bluetoothDevice:pairedDevice){
                    arrayList.add(bluetoothDevice.getName());
                }
                arrayAdapter = new ArrayAdapter(BluetoothActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList);
                listView.setAdapter(arrayAdapter);

                break;
        }
    }
}