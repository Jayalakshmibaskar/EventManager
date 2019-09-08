package com.example.revathy.events;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class reg_form extends AppCompatActivity {
    TextView reg_tv;
    EditText name_edt, email_edt, mobile_edt, dept_edt, year_edt, college_edt;
    Button register;
    String name_str, email_str, mobile_str, dept_str, year_str, college_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form);
        reg_tv = findViewById(R.id.form_reg);
        name_edt = findViewById(R.id.form_name);
        email_edt = findViewById(R.id.form_email);
        mobile_edt = findViewById(R.id.form_mobile);
        dept_edt = findViewById(R.id.form_dept);
        year_edt = findViewById(R.id.form_year);
        college_edt = findViewById(R.id.form_college);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_str = name_edt.getText().toString().trim();
                email_str = email_edt.getText().toString().trim();
                mobile_str = mobile_edt.getText().toString().trim();
                college_str = college_edt.getText().toString().trim();
                dept_str = dept_edt.getText().toString().trim();
                year_str = year_edt.getText().toString().trim();
                if (Patterns.EMAIL_ADDRESS.matcher(email_str).matches()) {

                    StringRequest sr = new StringRequest(Request.Method.POST, Constants.BASE_URL +"registrationform.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(reg_form.this, "Registered successfully"+response, Toast.LENGTH_SHORT).show();
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(reg_form.this, "Error", Toast.LENGTH_SHORT).show();
                                }
                            }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("username", name_str);
                            params.put("email", email_str);
                            params.put("mobile",mobile_str);
                            params.put("college",college_str);
                            params.put("dept",dept_str);
                            params.put("year",year_str);
                            return params;
                        }

                    };
                    RequestQueue queue = Volley.newRequestQueue(reg_form.this);
                    queue.add(sr);
                } else {
                    Toast.makeText(reg_form.this, "Enter valid data", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
