package com.bmpl.registrationform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText, passwordEditText;

    private final int reqCode = 10;

    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText)findViewById(R.id.nameEditText);
        emailEditText = (EditText)findViewById(R.id.emailEditText);
        passwordEditText = (EditText)findViewById(R.id.passwordEditText);

        signIn = (Button)findViewById(R.id.signInButton);

        signIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", nameEditText.getText().toString());
                intent.putExtra("email", emailEditText.getText().toString());
                intent.putExtra("password", passwordEditText.getText().toString());

                startActivityForResult(intent, reqCode);
                //startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode == reqCode){
            if(resultCode == 1)
            {
                nameEditText.setText(intent.getStringExtra("name"));
                emailEditText.setText(intent.getStringExtra("email"));
                passwordEditText.setText(intent.getStringExtra("password"));

            }else if(resultCode == 0)
            {
                nameEditText.setText("");
                emailEditText.setText("");
                passwordEditText.setText("");
            }
        }
    }
}