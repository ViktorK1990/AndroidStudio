package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myfirstapp.databinding.ActivityMusicPlayerBinding;

public class MusicPlayerActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    private ImageView album, play_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        ActivityMusicPlayerBinding binding = ActivityMusicPlayerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        mediaPlayer = MediaPlayer.create(MusicPlayerActivity.this,R.raw.him_the_funeral_of_hearts );


        album = findViewById(R.id.img_album);
        play_btn = findViewById(R.id.play_btn);
        album.setImageResource(R.drawable.img_album_him);

        play_btn.setOnClickListener(View -> play());
        binding.nextBtn.setOnClickListener(View -> next());
        binding.backBtn.setOnClickListener(View -> back());
    }

    public void play() {
        if (!mediaPlayer.isPlaying()) {
            play_btn.setImageResource(R.drawable.pause);
            mediaPlayer.start();
        } else {
            mediaPlayer.pause();
            play_btn.setImageResource(R.drawable.play);
        }
    }

    public void next() {
        mediaPlayer.pause();
        mediaPlayer = MediaPlayer.create(MusicPlayerActivity.this, R.raw.linkin_park_breaking_the_habit);
        album.setImageResource(R.drawable.linkin_park);
        mediaPlayer.start();
    }

    public void back() {
        mediaPlayer.pause();
        mediaPlayer = MediaPlayer.create(MusicPlayerActivity.this, R.raw.him_the_funeral_of_hearts);
        album.setImageResource(R.drawable.img_album_him);
        mediaPlayer.start();
    }

}