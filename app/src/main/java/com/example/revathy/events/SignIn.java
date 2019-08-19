package com.example.revathy.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignIn extends AppCompatActivity {
    EditText username_edt, password_edt;
    Button login_btn;
    String user_str;
    String pwd_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username_edt = findViewById(R.id.username);
        password_edt = findViewById(R.id.password);
        login_btn = findViewById(R.id.login);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          user_str=username_edt.getText().toString().trim();
          pwd_str=password_edt.getText().toString().trim();
          String username="Jayalakshmi";
          String password="Jaya@1999";
          if(user_str.equals(username)&&pwd_str.equals(password)) {
              Intent intent4 = new Intent(SignIn.this, EventName.class);
              startActivity(intent4);
          }
          else{
              Toast.makeText(SignIn.this,"Username does not exist",Toast.LENGTH_SHORT).show();
          }
            }
        });
    }
}