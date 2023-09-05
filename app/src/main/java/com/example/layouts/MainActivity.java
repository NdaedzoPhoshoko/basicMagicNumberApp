package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView titleTxtView, promptNameTxtView;
    private EditText usernameEditText;
    private Button viewLuckyNumBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables
        titleTxtView = (TextView) findViewById(R.id.titleTxt);
        promptNameTxtView = (TextView) findViewById(R.id.whatIsYourNameTxt);
        usernameEditText = (EditText) findViewById(R.id.collectNameTxt);
        viewLuckyNumBtn = (Button) findViewById(R.id.myBtn);

        viewLuckyNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = usernameEditText.getText().toString();
                intentToActivity_2(userName);
            }
        });
    }

    public void intentToActivity_2(String userName) {
        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
        i.setType("text/plain");
        i.putExtra("username", userName);
        startActivity(i);
    }

}