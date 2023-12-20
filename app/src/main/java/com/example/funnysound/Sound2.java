package com.example.funnysound;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class Sound2 extends AppCompatActivity {

    MediaPlayer player;
    Handler handler;
    Runnable runnable;
    DocumentsContract.Root root;
    SeekBar seekbar;

    ImageView play;
    Boolean isPlay;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound2);


      play = findViewById(R.id.imageView);
        seekbar = findViewById(R.id.seekbar);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    player = new MediaPlayer();
                    if (player.isPlaying()) {
                        player.reset();
                    }
                    player.setDataSource("https://file-examples.com/storage/fed2530f4765780b09aff74/2017/11/file_example_MP3_700KB.mp3");
                    player.prepare();

                    seekbar.setMax(player.getDuration());

                    if (isPlay) {
                        player.stop();
                        play.setImageResource(R.drawable.play);
                        handler.removeCallbacks(runnable);
                        isPlay = false;
                    } else {
                        player.start();

                        runnable = new Runnable() {
                            @Override
                            public void run() {
                                seekbar.setProgress(player.getCurrentPosition());
                                handler.postDelayed(this, 1000);
                            }
                        };
                        handler = new Handler();
                        handler.post(runnable);

                        play.setImageResource(R.drawable.stop);
                        isPlay = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Sound2.this, ""+e, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}