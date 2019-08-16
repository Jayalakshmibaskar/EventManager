package com.example.revathy.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;

public class EventName extends AppCompatActivity {
    ListView event_name;
    String[] event={
            "SYMPOSIUM",
            "CITCOS",
            "CAREER COMPASS"
    };
    String[] desc={
            "TECHNO EVENTS",
            "SCHOOL STUDENT EVENT",
            "CAREER EVENTS"
    };
    Integer[] event_image={
            R.drawable.symp,
            R.drawable.citcos,
            R.drawable.careercompass
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_name);
        event_name = (ListView) findViewById(R.id.events);
        MyListAdapter adapter = new MyListAdapter(this,event,event_image,desc);

        event_name.setAdapter(adapter);


    }
}
