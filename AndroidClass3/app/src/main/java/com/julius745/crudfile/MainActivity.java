package com.julius745.crudfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    Button play,stop;
    Button play2,stop2;
    Button next;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (VideoView)findViewById(R.id.videoView);
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);

        play2 = (Button) findViewById(R.id.play2);
        stop2 = (Button) findViewById(R.id.stop2);

        next = (Button) findViewById(R.id.nav);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Note.class);
                startActivity(intent);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video);
                   videoView.setVideoURI(uri);
                   videoView.start();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.stopPlayback();
            }
        });
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp = MediaPlayer.create(getApplicationContext(),R.raw.music);
                mp.start();
            }
        });

        stop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
                mp.seekTo(0);
            }
        });
    }
    //public void VideoPlay(View view){
    //    Uri uri = Uri.parse("android.resource://" + getPackageName()+"/"+R.raw.video);
    //   videoView.setVideoURI(uri);
    //    videoView.start();

}