package com.example.myapplicationbigtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginactivity extends AppCompatActivity {//teb3a android
    EditText username,password;
    Button btlogin;
    DBHelper DB; //DBHelper est une classe qui permet de gerer base de donnees a partir mn SQLlite

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btlogin = (Button) findViewById(R.id.log);
        DB = new DBHelper(this);
        btlogin.setOnClickListener(new View.OnClickListener() {
              @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(loginactivity.this, "please enter all informations", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass=DB.checkuserpassword(user,pass);
                    if (checkuserpass==true ){
                        Toast.makeText(loginactivity.this, "welcome", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),homeactivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginactivity.this, "invalid informations", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

}