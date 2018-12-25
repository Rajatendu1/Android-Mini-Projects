package com.example.kiit.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int myActivePlayer=0;
    //0 for cross and 1 for circle
    //GAME_STATE
    int[] myGameState={2,2,2,2,2,2,2,2,2};
    public void imageTapped(View view)
    {
        ImageView myTapped=(ImageView) view;
        //Log.i("tag is","image number is "+myTapped.getTag().toString());
        int tappedimageTag=Integer.parseInt(myTapped.getTag().toString());
        if(myGameState[tappedimageTag]==2) {
            myGameState[tappedimageTag] = myActivePlayer;
            if (myActivePlayer == 0) {
                myTapped.setImageResource(R.drawable.icons8delete64);
                myTapped.animate().rotation(360).setDuration(1000);
                myActivePlayer = 1;
            } else {
                myTapped.setImageResource(R.drawable.icons8round64);
                myTapped.animate().rotationY(360).setDuration(1000);
                myActivePlayer = 0;

            }
        }
        else
        {
            //Log.i("msg","this place is already filled");
            Toast.makeText(MainActivity.this,
                    "This place is already filled", Toast.LENGTH_LONG).show();
        }
    }
    public void playAgain(View view)
    {
        Log.i("msg","Button is tapped");
        //Change Game state back to 2
        for(int i=0;i<myGameState.length;i++)
        myGameState[i]=2;
            //Make active player 0 again
        myActivePlayer=0;
        //change all images to ic_launcher
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.lineone);
        for(int i=0;i<linearLayout.getChildCount();i++)
        {
            ((ImageView) linearLayout.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout1=(LinearLayout) findViewById(R.id.linetwo);
        for(int i=0;i<linearLayout1.getChildCount();i++)
        {
            ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
        LinearLayout linearLayout2=(LinearLayout) findViewById(R.id.linethree);
        for(int i=0;i<linearLayout2.getChildCount();i++)
        {
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.mipmap.ic_launcher);
        }
    }
    //win logic


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
