package com.example.revathy.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
EditText name_edt,password_edt,email_edt;
Button signup_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name_edt=findViewById(R.id.name);
        password_edt=findViewById(R.id.password);
        email_edt=findViewById(R.id.email);
        signup_btn=findViewById(R.id.signup);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(SignUp.this,SignIn.class);
                startActivity(intent3);
            }
        });
    }
}
