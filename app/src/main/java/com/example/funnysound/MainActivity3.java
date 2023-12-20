package com.example.funnysound;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {


    ImageView imagePlayPause;
    TextView textcurenTime,texttotalduration,textView2;
    SeekBar playerseekbar;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        imagePlayPause = findViewById(R.id.imagePlayPause);
        textcurenTime = findViewById(R.id.textcurenTime);
        texttotalduration = findViewById(R.id.texttotalduration);
        playerseekbar = findViewById(R.id.playerseekbar);
        textView2 = findViewById(R.id.textView2);


    }}