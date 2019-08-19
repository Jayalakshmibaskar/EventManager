package com.example.revathy.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class reg_form extends AppCompatActivity {
    TextView reg_tv;
    EditText name_edt,email_edt,mobile_edt,dept_edt,year_edt,college_edt;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form);
        reg_tv=findViewById(R.id.form_reg);
        name_edt=findViewById(R.id.form_name);
        email_edt=findViewById(R.id.form_email);
        mobile_edt=findViewById(R.id.form_mobile);
        dept_edt=findViewById(R.id.form_dept);
        year_edt=findViewById(R.id.form_year);
        college_edt=findViewById(R.id.form_college);
        register=findViewById(R.id.register);
    }
}
