package com.example.revathy.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    EditText name_edt, password_edt, email_edt;
    Button signup_btn;
    String name_str;
    String password_str;
    String email_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name_edt = findViewById(R.id.name);
        password_edt = findViewById(R.id.password);
        email_edt = findViewById(R.id.email);
        signup_btn = findViewById(R.id.signup);
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_str = name_edt.getText().toString().trim();
                password_str = password_edt.getText().toString().trim();
                email_str = email_edt.getText().toString().trim();
                String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
                Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
                Matcher matcher = pattern.matcher(password_str);
                if (Patterns.EMAIL_ADDRESS.matcher(email_str).matches() && matcher.matches()) {

                    StringRequest sr = new StringRequest(Request.Method.POST, Constants.BASE_URL+"login_info.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(SignUp.this, "signup successful", Toast.LENGTH_SHORT).show();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(SignUp.this, "Login failed", Toast.LENGTH_SHORT).show();
                                }
                            }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
                                params.put("username", name_str);
                                params.put("password", password_str);
                                params.put("email", email_str);
                                return params;
                            }

                            };
                    RequestQueue queue = Volley.newRequestQueue(SignUp.this);
                    queue.add(sr);
                   Intent intent3 = new Intent(SignUp.this, SignIn.class);
                   startActivity(intent3);
                } else {
                    Toast.makeText(SignUp.this, "Enter valid data", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
