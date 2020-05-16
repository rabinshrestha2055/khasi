package com.example.musicplayer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class READ_SONG extends AppCompatActivity {
Button btn_next,btn_previous,btn_pause;
TextView SongTextLabel;
SeekBar SongSeekBar;
String sname;
TextView currenttime;
TextView Totaltime;

static MediaPlayer mymediaPlayer;
int position;

ArrayList<File> mysongs;

 Thread UpdateseekBar;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read__song);
        btn_next=(Button)findViewById(R.id.next);
        btn_pause=(Button)findViewById(R.id.pause);
        btn_previous=(Button)findViewById(R.id.previous);

        SongTextLabel=(TextView)findViewById(R.id.songname);
        SongSeekBar=(SeekBar)findViewById(R.id.seekBar);
        currenttime = findViewById(R.id.currenttimer);
        Totaltime = findViewById(R.id.totaltimer);

         getSupportActionBar().setTitle("NOW PLAYING");
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         getSupportActionBar().setDisplayShowHomeEnabled(true);

        UpdateseekBar= new Thread(){
            @Override
            public void run() {
                    int totalduration = mymediaPlayer.getDuration();
                    int currentPosition=0;

                while (currentPosition<totalduration){
                    try{
                       sleep(500);
                       currentPosition=mymediaPlayer.getCurrentPosition();
                       SongSeekBar.setProgress(currentPosition);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        if (mymediaPlayer!=null){
            mymediaPlayer.stop();
            mymediaPlayer.release();
        }
        Intent i =getIntent();
        Bundle bundle = i.getExtras();

        mysongs=(ArrayList) bundle.getParcelableArrayList("songs");

        sname = mysongs.get(position).getName().toString();

        String songName= i.getStringExtra("songname");

        SongTextLabel.setText(songName);
        SongTextLabel.setSelected(true);

        position = bundle.getInt("pos",0);

        Uri u = Uri.parse(mysongs.get(position).toString());

        mymediaPlayer = MediaPlayer.create(getApplicationContext(),u);
        mymediaPlayer.start();

        SongSeekBar.setMax(mymediaPlayer.getDuration());
        String totaltime =  createTimerlabel(mymediaPlayer.getDuration());
        Totaltime.setText(totaltime);

        UpdateseekBar.start();
        SongSeekBar.getProgressDrawable().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
        SongSeekBar.getThumb().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        SongSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mymediaPlayer.seekTo(seekBar.getProgress());

            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SongSeekBar.setMax(mymediaPlayer.getDuration());

                if (mymediaPlayer.isPlaying()){

                    btn_pause.setBackgroundResource(R.drawable.icon_play);
                    mymediaPlayer.pause();
                }
                else{
                    btn_pause.setBackgroundResource(R.drawable.icon_pause);
                    mymediaPlayer.start();
                }
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mymediaPlayer.stop();
                mymediaPlayer.release();
                position =(position+1)%mysongs.size();
                Uri u = Uri.parse(mysongs.get(position).toString());
                mymediaPlayer = MediaPlayer.create(getApplicationContext(),u);
                sname = mysongs.get(position).toString();
                SongTextLabel.setText(sname);
                mymediaPlayer.start();

            }
        });

        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mymediaPlayer.stop();
                mymediaPlayer.release();
                position=((position-1)<0)?(mysongs.size()-1):(position-1);
                Uri u = Uri.parse(mysongs.get(position).toString());
                mymediaPlayer = MediaPlayer.create(getApplicationContext(),u);
                sname = mysongs.get(position).toString();
                SongTextLabel.setText(sname);
                mymediaPlayer.start();


            }
        });
    }
      @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

      }
      public String createTimerlabel(int duration){

        String TimeLabel = "";
          int min = duration / 1000 / 60;
          int sec = duration / 1000 % 60;

          TimeLabel += min + ":";

          if(sec<10) TimeLabel +="0";
          TimeLabel += sec;
          return TimeLabel;

      }

      private Handler handler = new Handler(){

        @Override
          public void handleMessage(Message msg){
            currenttime.setText(createTimerlabel(msg.what));

            SongSeekBar.setProgress(msg.what);
        }

      };
}

