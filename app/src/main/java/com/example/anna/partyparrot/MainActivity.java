package com.example.anna.partyparrot;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.widget.ImageView;


public class MainActivity extends Activity {

    private ImageView img;

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
        MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.gangham);
        ring.start();

    }
}
