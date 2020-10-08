package com.example.anna.partyparrot;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.widget.ImageView;


public class MainActivity extends Activity {

    private ImageView img;
    MediaPlayer ring;

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);
        img.post(new Runnable() {

            @Override
            public void run() {
                ((AnimationDrawable) img.getBackground()).start();
            }

        });
        ring= MediaPlayer.create(MainActivity.this,R.raw.gangham);
        ring.start();


        //onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if(ring.isPlaying()){
            ring.stop();
        }
        ring.release();
        super.onBackPressed();
    }
    
}
