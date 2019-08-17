package com.example.revathy.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EventName extends AppCompatActivity {
    ListView event_name;
ArrayList list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_name);
        event_name=findViewById(R.id.events);
         list=new ArrayList();

        send();


        }
    void send() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.43.165/event.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        //tv2.setText(response);

                        try {
                            JSONArray arr = new JSONArray(response);
                            for (int i=0;i<arr.length();i++){
                                JSONObject obj=arr.getJSONObject(i);
                                list.add(obj.getString("eventname"));
                                }
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
                                    Toast.makeText(EventName.this, "test"+response, Toast.LENGTH_SHORT).show();
                                    adapter = new MyAdapter(list,EventName.this);
                                    event_name.setAdapter(adapter);
//                                }
//                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(EventName.this, "error"+error.getMessage()+error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

}
