package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private TextView titleTxtView;
    private TextView luckyNumberTxtView;
    private Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        luckyNumberTxtView = (TextView) findViewById(R.id.luckyNumberTxt);
        shareBtn = (Button) findViewById(R.id.shareButton);

        int randomInt = luckyNumber();                                       //generating random integer
        luckyNumberTxtView.setText("" + randomInt);
        String userName = getIntent().getStringExtra("username");      //accepting username from intent

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareTo(userName, randomInt); //passing values to other activities outside this activity,
            }
        });

    }

    public int luckyNumber() {
        Random random = new Random();
        return random.nextInt(45); //return random between 0 and max 45
    }

    //sharing username and random number to other apps, implicit intent
    public void shareTo(String name, int luckyNumber) {
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        myIntent.putExtra(Intent.EXTRA_SUBJECT, "Sharing " + name + " 's lucky number");
        myIntent.putExtra(Intent.EXTRA_TEXT, "Hey, here is my lucky number: " + luckyNumber);

        startActivity(Intent.createChooser(myIntent, "Choose to share"));
    }
}

/*
Optionally, you can add extras to include more information,
such as email recipients (EXTRA_EMAIL, EXTRA_CC, EXTRA_BCC),
the email subject (EXTRA_SUBJECT),
the body text (EXTRA_TEXT).
 */