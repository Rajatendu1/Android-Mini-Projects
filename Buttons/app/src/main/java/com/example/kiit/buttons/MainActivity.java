package com.example.kiit.buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void signUp(View view)
    {
        Log.i("Sign Up","sign up tapped");

    }
    public void signin(View view)
    {
       Log.i("Sign in","sign in tapped");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
