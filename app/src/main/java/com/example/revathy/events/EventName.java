package com.example.revathy.events;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventName extends AppCompatActivity {
    ListView event_name;
    FloatingActionButton btn;
    ArrayList<EventModel> list;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_name);
        event_name = findViewById(R.id.events);
        list = new ArrayList<EventModel>();

        btn=findViewById(R.id.add);
        send();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                SharedPreferences sharedpref = getApplicationContext().getSharedPreferences("EVENT", 0);
                SharedPreferences.Editor pref = sharedpref.edit();
//                pref.putString("EVENT", event_add);
                pref.commit();
            }
        });


        event_name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent_reg = new Intent(EventName.this, reg_form.class);
                startActivity(intent_reg);
            }

        });

    }
    void send() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Constants.BASE_URL+"event.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(final String response) {
                        //tv2.setText(response);
                       // Toast.makeText(EventName.this, "res"+response, Toast.LENGTH_SHORT).show();

                        try {
                            JSONArray arr = new JSONArray(response);
                            list.clear();
                            for (int i=0;i<arr.length();i++){
                                JSONObject obj=arr.getJSONObject(i);

                                list.add(new EventModel(obj.getString("eventname"),obj.getString("Desc"),obj.getString("eventid")));
                                }

                            //Toast.makeText(EventName.this, "size"+list.size(), Toast.LENGTH_SHORT).show();
                                    adapter = new MyAdapter(list,EventName.this);
                                    event_name.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(EventName.this, "error"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                8000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        );
        Volley.newRequestQueue(this).add(stringRequest);

    }
    void send1(final String event_add){
        StringRequest sr1 = new StringRequest(Request.Method.POST, Constants.BASE_URL +"dialog.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(EventName.this, "Registered successfully"+response, Toast.LENGTH_SHORT).show();
                        send();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EventName.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", event_add);

                return params;
            }

        };
        RequestQueue queue = Volley.newRequestQueue(EventName.this);
        queue.add(sr1);    }
    @SuppressLint("NewApi")
    private void showDialog(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(EventName.this);
        View dialogView=getLayoutInflater().inflate(R.layout.dialog,null,false);
        dialog.setView(dialogView);
        final EditText et=dialogView.findViewById(R.id.ed_dialog);
        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              String  event_add=et.getText().toString();
              send1(event_add);

//                list.add(event_add);
//                event_name.setAdapter(adapter);
            }
        });
        dialog.show();
    }
}
