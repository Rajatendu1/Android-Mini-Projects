package com.example.kiit.volleyfour;

import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    String myURL="https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button) findViewById(R.id.buttonapi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAP", "TAPPED");

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myURL, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                             Log.i("JSON","JSON"+jsonObject);

                                try {
                                    String info =jsonObject.getString("weather");
                                    Log.i("INFO","INFO"+info);

                                    JSONArray ar=new JSONArray(info);
                                    for (int i=0;i<ar.length();i++){
                                        JSONObject parObj=ar.getJSONObject(i);
                                        Log.i("ID","ID : "+ parObj.getString("id"));
                                        Log.i("MAIN","MAIN : "+ parObj.getString("main"));
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                               /* try {
                               String coor = jsonObject.getString("coord");
                               Log.i("COOR","COOR:" + coor);
                               JSONObject co=new JSONObject(coor);

                               String lon=co.getString("lon");
                               String lat=co.getString("lat");

                               Log.i("LON","LON:" + lon);
                               Log.i("LAT","LAT:" + lat);
                           }
                           catch(JSONException e)
                           {
                               e.printStackTrace();
                           }*/
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.i("Error","Something went wrong"+ error);
                            }
                        }

                );
                MySingleton.getInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);
            }
        });
    }
}

