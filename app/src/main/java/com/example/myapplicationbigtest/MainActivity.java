package com.example.myapplicationbigtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Button signup1, signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialiser les boutons en utilisant findViewById
        signup1 = findViewById(R.id.buttonsignup);
        signin = findViewById(R.id.buttonsignin);








        // Définir les écouteurs de clic pour les boutons signin et signup1
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), loginactivity.class);
                startActivity(intent);
            }
        });

        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SIGNUIP.class);
                startActivity(intent);
            }
        });
    }
}
