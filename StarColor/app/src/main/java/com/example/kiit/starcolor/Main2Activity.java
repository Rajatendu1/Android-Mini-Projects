package com.example.kiit.starcolor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ImageView imageView=(ImageView) findViewById(R.id.imageView);

        Intent intent=getIntent();
        Toast.makeText(this,intent.getStringExtra("name"),Toast.LENGTH_SHORT).show();
        imageView.setImageResource(R.drawable.red);

        String col=intent.getStringExtra("name");

        imageView.setImageResource(getImageId(this,col));

    }
}
