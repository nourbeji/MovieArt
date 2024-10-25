package com.example.myapplicationbigtest;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class homeactivity extends AppCompatActivity {
    CardView cardview1, cardview2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        // First CardView
        cardview1= (CardView ) findViewById(R.id.cardview1);
        cardview2= (CardView ) findViewById(R.id.cardview2);
        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeactivity.this, film1.class);
                startActivity(intent);
            }
        });

        // Second CardView
        cardview2= (CardView ) findViewById(R.id.cardview2);

        cardview2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeactivity.this, film2.class);
                startActivity(intent);
            }
        });
    }
}


