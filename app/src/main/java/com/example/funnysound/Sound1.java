package com.example.funnysound;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Sound1 extends AppCompatActivity {

    Button ofLine,onLine,nextActivity;
    MediaPlayer mediaPlayer;
    TextView textveiw;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound1);

        ofLine = findViewById(R.id.ofLine);
        onLine = findViewById(R.id.onLine);
        nextActivity = findViewById(R.id.nextActivity);
        textveiw = findViewById(R.id.textveiw);


        ofLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( mediaPlayer!= null) {
                    mediaPlayer.release();
                }

                mediaPlayer = new MediaPlayer();
                mediaPlayer = MediaPlayer.create(Sound1.this,R.raw.audio);
                mediaPlayer.start();

            }
        });

        onLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( mediaPlayer!= null) {
                    mediaPlayer.release();
                }

                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/puzzlesonline-a2563.appspot.com/o/biodynamic-impact-braam-tonal-dark-176441.mp3?alt=media&token=277d3f43-fb92-4eeb-bbe3-0c624ea38d09");
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    Toast.makeText(Sound1.this, ""+e, Toast.LENGTH_SHORT).show();
                    textveiw.setText(""+e);
                   e.printStackTrace();
                }
            }
        });

        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(Sound1.this,MainActivity.class));
            }
        });
    }
}