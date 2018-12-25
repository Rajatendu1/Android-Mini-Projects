package com.example.kiit.myweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText city;
    TextView result;

    //http://api.openweathermap.org/data/2.5/weather?q=Paris&appid=b6aa702fdb51ab69fcb0852f3e927edb

    String baseURL="https://api.openweathermap.org/data/2.5/weather?q=";
    String API="&appid=b6aa702fdb51ab69fcb0852f3e927edb";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button) findViewById(R.id.button);
        city=(EditText) findViewById(R.id.getCity);
        result=(TextView) findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((city.getText().toString().equals("Enter your city"))||(city.getText().toString().equals(""))){
                    Toast.makeText(MainActivity.this,
                            "No city entered", Toast.LENGTH_LONG).show();

                    Log.i("Null message","No city have been entered by the user and button pressed to get details");
                }

                else {

                    String myURL = baseURL + city.getText().toString() + API;
                    Log.i("URL", "URL: " + myURL);

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

                                            String myWeather=parObj.getString("main");
                                            result.setText(myWeather);
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
            }
        });




    }
}
