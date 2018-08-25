package com.bulutangkis.learning.video;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bulutangkis.learning.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class FirstPlayerActivity extends YouTubeBaseActivity {
    public static final String API_KEY = "AIzaSyC7mWspoPyAIvcErI9A-EgYKSAOgLaxIDI";
    public static final  String VIDEO_ID = "MTF7T1Nw5OU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_player);

        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(API_KEY,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.
                        youTubePlayer.cueVideo(VIDEO_ID);
                        // or to play immediately
                        // youTubePlayer.loadVideo("5xVh-7ywKpE");
                    }
                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {
                        Toast.makeText(FirstPlayerActivity.this, "Youtube Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
