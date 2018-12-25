package com.example.kiit.mystack;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    public class SetupFetch extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {

            URL url;
            String page="";
            HttpsURLConnection urlConnection=null;

            try{
                url=new URL(strings[0]);

                urlConnection=(HttpsURLConnection) url.openConnection();

                InputStream input=urlConnection.getInputStream();

                InputStreamReader read=new InputStreamReader(input);

                 int data=read.read();

                 while(data!=-1){
                     char storeData=(char) data;
                     page+=storeData;
                     data=read.read();
                 }
                 return page;
            }

            catch (Exception e){
                e.printStackTrace();
                return  "Cannot fetch web page";
            }


        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetupFetch request = new SetupFetch();

        String page=null;

        try{
            page = request.execute("https://www.hiteshchoudhary.com/").get();
            Log.i("Done","Done");
        }

       catch (Exception e){
            e.printStackTrace();
       }
       Log.i("Hitesh",page);
        Log.i("Done","Done");
    }
}
