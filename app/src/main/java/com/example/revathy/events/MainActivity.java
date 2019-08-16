package com.example.revathy.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView eventmanager_tv;
Button signin_btn,signup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventmanager_tv=findViewById(R.id.eventmanager);
        signin_btn=findViewById(R.id.signin);
        signup_btn=findViewById(R.id.signup);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,SignUp.class);
                startActivity(intent1);
            }
        });
        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,SignIn.class);
                startActivity(intent2);
            }
        });
    }
}
