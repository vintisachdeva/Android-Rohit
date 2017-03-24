package com.bmpl.activtiylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"Inside onCreate()");
    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        //dialog--> yes-->  finish() or no--> onResume()
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG,"Inside onPause()");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG,"Inside onRestart()");
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG,"Inside onStart()");
    }


    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG,"Inside onResume()");
    }



    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG,"Inside onStop()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"Inside onDestroy()");
    }

}
