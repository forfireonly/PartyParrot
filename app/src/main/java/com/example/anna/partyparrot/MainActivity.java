package com.example.anna.partyparrot;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    private ImageView img;
    MediaPlayer ring;
    private Animation topAnim, bottonAnim;
    private TextView topText, bottomText;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topText = (TextView) findViewById(R.id.long_live);
        bottomText = findViewById(R.id.the_party_parrot);
        img = (ImageView) findViewById(R.id.img);
        img.post(new Runnable() {

            @Override
            public void run() {
                ((AnimationDrawable) img.getBackground()).start();
            }

        });
        ring = MediaPlayer.create(MainActivity.this, R.raw.gangham);
        ring.start();

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottonAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);


        //onBackPressed();

        topText.setAnimation(bottonAnim);
        bottomText.setAnimation(topAnim);
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
