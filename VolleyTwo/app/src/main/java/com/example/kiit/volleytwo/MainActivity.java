package com.example.kiit.volleytwo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String myURL="https://is4-ssl.mzstatic.com/image/thumb/Purple71/v4/a2/40/1a/a2401ae5-f5a7-29ed-41b8-cda9d6e36623/source/256x256bb.jpg";
        final ImageView imageView=(ImageView) findViewById(R.id.imageView);
        Button myButton =(Button) findViewById(R.id.button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest imageRequest=new ImageRequest(myURL, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageView.setImageBitmap(response);
                    }
                }, 0, 0, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Error","Error");
                    }
                }
                );
                 MySingleton.getInstance(MainActivity.this).addToRequestQue(imageRequest);
            }
        });
    }
}
