package com.example.revathy.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {
EditText username_edt,password_edt;
Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username_edt=findViewById(R.id.username);
        password_edt=findViewById(R.id.password);
        login_btn=findViewById(R.id.login);
        login_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent4=new Intent(SignIn.this,EventName.class);
        startActivity(intent4);
    }
});
    }
}
