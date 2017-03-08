package com.bmpl.greetapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textViewResult;
    EditText editTextName, editTextMobile;
    Button buttonSubmit, buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }


    public void initialize(){

        textViewResult = (TextView)findViewById(R.id.textViewResult);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextMobile = (EditText)findViewById(R.id.editTextMobile);

        buttonSubmit = (Button)findViewById(R.id.submitButton);
        buttonCancel = (Button)findViewById(R.id.cancelButton);

        buttonSubmit.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.submitButton:

                String name = editTextName.getText().toString().trim();
                String mobile = editTextMobile.getText().toString().trim();

                if(!name.equals("") && !mobile.equals(""))
                {
                    textViewResult.setText(name + " " + mobile);

                    Toast.makeText(this, "Submitted", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this, "Fill Details First", Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.cancelButton:

                editTextName.setText("");
                editTextMobile.setText("");
                textViewResult.setText("");

                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();

                break;
        }
    }
}