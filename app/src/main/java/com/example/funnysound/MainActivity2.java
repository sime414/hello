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
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ImageView imagePlayPause;
    TextView textcurenTime,texttotalduration,textView2;
    SeekBar playerseekbar;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imagePlayPause = findViewById(R.id.imagePlayPause);
        textcurenTime = findViewById(R.id.textcurenTime);
        texttotalduration = findViewById(R.id.texttotalduration);
        playerseekbar = findViewById(R.id.playerseekbar);
        textView2 = findViewById(R.id.textView2);

        playerseekbar.setMax(100);


        imagePlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    imagePlayPause.setImageResource(R.drawable.play);
                }else {
                    mediaPlayer.start();
                    imagePlayPause.setImageResource(R.drawable.pause);
                    updateseekbar();
                }
            }
        });

        prepareMediaplayer();
    }

    private void prepareMediaplayer(){
        try {
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/puzzlesonline-a2563.appspot.com/o/biodynamic-impact-braam-tonal-dark-176441.mp3?alt=media&token=277d3f43-fb92-4eeb-bbe3-0c624ea38d09");
            mediaPlayer.prepare();
            texttotalduration.setText(millisecondToTime(mediaPlayer.getDuration()));
        }catch (Exception exception){
            Toast.makeText(this, "error"+exception, Toast.LENGTH_SHORT).show();
            textView2.setText(""+exception);
        }
    }
    private Runnable updater =  new Runnable(){
        @Override
        public void run() {
            updateseekbar();
            long currentDuration = mediaPlayer.getCurrentPosition();
            textcurenTime.setText(millisecondToTime(currentDuration));


        }
    };

    public void updateseekbar(){
       if ( mediaPlayer.isPlaying()){
           playerseekbar.setProgress((int) (((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) *100));
           handler.postDelayed( updater,1000);
       }
    }

    private String millisecondToTime(long milliSecond){
        String timerString = "";
        String secondsString;
         int hours = (int) (milliSecond / (1000 * 60 * 60));
         int minits = (int) (milliSecond % (1000 * 60 * 60)) / (1000 * 60);
         int seconds = (int) ((milliSecond % (1000 * 60 * 60)) % (1000 * 60) / 1000) ;

         if (hours >0){
             timerString = hours+":";

         }

         if (seconds<10){
             secondsString ="0"+ seconds;
         }else {
             secondsString =""+ seconds;
         }

         timerString = timerString+minits+ ":"+ secondsString;

         return timerString;
    }
}