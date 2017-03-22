package com.bmpl.registrationform;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{


    TextView nameTextView, emailTextView, passwordTextView;

    Button yesButton, noButton;

    String name, email, password;

    private final int yes = 1;
    private final int no = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameTextView = (TextView)findViewById(R.id.nameTextView);
        emailTextView = (TextView)findViewById(R.id.emailTextView);
        passwordTextView = (TextView)findViewById(R.id.passwordTextView);

        yesButton = (Button)findViewById(R.id.yesButton);
        noButton = (Button)findViewById(R.id.noButton);

        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        email = intent.getStringExtra("email");
        password = intent.getStringExtra("password");

        nameTextView.setText("Welcome " +name);
        emailTextView.setText("Your email is= " +email);
        passwordTextView.setText("Your password is= " +password);

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {

            case R.id.yesButton:
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                setResult(yes, intent);
                break;

            case R.id.noButton:

                break;

        }
    }
}
