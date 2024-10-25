package com.example.myapplicationbigtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SIGNUIP extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText repassword;
    private Button signup;
    private DBHelper DB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signuip);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.buttonsignup);

        DB = new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                if (user.equals("") || pass.equals("") || repass.equals(""))
                    Toast.makeText(getApplicationContext(), "fill all the fields", Toast.LENGTH_SHORT).show();

                else {
                    if (pass.equals(repass)) {
                        boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertdata(user, pass);
                            if (insert == true) {
                                Toast.makeText(SIGNUIP.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), homeactivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SIGNUIP.this, "registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(SIGNUIP.this, "this user already exists,please signin directly", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SIGNUIP.this, "password not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }}

