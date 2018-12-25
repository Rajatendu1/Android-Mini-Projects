package com.example.kiit.myvideoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Basic video
        //1.get video view
        VideoView videoView=(VideoView) findViewById(R.id.videoView);
        //2.point to video source
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.introvideo);
        //add media control
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        //3.run it
        videoView.start();
    }
}
