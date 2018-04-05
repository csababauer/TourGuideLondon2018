package com.example.csaba.tourguidelondon2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**header background alpha setting*/
        TextView header = (TextView) findViewById(R.id.header);
        header.getBackground().setAlpha(50);


        TextView button1 = (TextView) findViewById(R.id.sight);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sightIntent = new Intent(MainActivity.this, Sightseeing.class);
                // Start the new activity
                startActivity(sightIntent);
            }
        });

        TextView button2 = (TextView) findViewById(R.id.parks);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parkIntent = new Intent(MainActivity.this, Parks.class);
                // Start the new activity
                startActivity(parkIntent);
            }
        });

        TextView button3 = (TextView) findViewById(R.id.streetart);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent streetIntent = new Intent(MainActivity.this, StreetArt.class);
                // Start the new activity
                startActivity(streetIntent);
            }
        });

        TextView button4 = (TextView) findViewById(R.id.hotels);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotelIntent = new Intent(MainActivity.this, Hotels.class);
                // Start the new activity
                startActivity(hotelIntent);
            }
        });

    }
}
