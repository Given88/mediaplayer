package com.gtworld.simplemediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private TextView resView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        resView = findViewById(R.id.resView);
        mediaPlayer = MediaPlayer.create(this, R.raw.we_are_the_world);
        //used MediaPlayer.create(this, R.raw.we_are_the_world) because it allows a faster simple access to the resource
        //but it has limitations which I cannot fully configure the data file
        //no need to prepare the audio
    }

    public void playbtnClicked(View view) {
       //Start playing the music
mediaPlayer.start();//start playing
resView.setText("Playing...");

    }
    public void pausebtnClicked(View view) {
       //pauses the music
mediaPlayer.pause();
        resView.setText("Paused...");
    }
}