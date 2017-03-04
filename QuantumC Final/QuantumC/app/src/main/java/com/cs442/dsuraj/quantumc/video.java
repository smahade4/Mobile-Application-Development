package com.cs442.dsuraj.quantumc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class video extends YouTubeBaseActivity  {

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;

    //  private MyPlayerStateChangeListener playerStateChangeListener;
    private MyPlaybackEventListener playbackEventListener;
    private YouTubePlayer player;
    private YouTubePlayer player1;
    TextView txtmovie;
    String videoname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

       // playerStateChangeListener = new MyPlayerStateChangeListener();
        Spinner dynamicSpinner = (Spinner) findViewById(R.id.dynamic_spinner);

        final String[] items = new String[] { "Bahubali", "Dangal", "Raees" ,"sarkar"};
        final String[] video = new String[] { "bICA1ZtU6ck", "x_7YlGv9u1g", "8iv3ksZs0hk" ,"ea9eX2QnnV0"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txtmovie=(TextView)findViewById(R.id.txtmovie);
        dynamicSpinner.setAdapter(adapter);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);

        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                     @Override
                                                     public void onItemSelected(AdapterView<?> parent, View view,
                                                                                 int position, long id) {
                                                         playbackEventListener = new MyPlaybackEventListener();
                                                            System.out.print(position);
                                                        videoname= video[position];
                                                         txtmovie.setText(items[position]);
                                                         System.out.print(videoname);

                                                         youTubeView.initialize(Config.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {
                                                             @Override
                                                             public void onInitializationSuccess(Provider arg0, YouTubePlayer arg1, boolean arg2) {
                                                                 player=arg1;
                                                                 player.cueVideo(videoname);
                                                             }

                                                             @Override
                                                             public void onInitializationFailure(Provider arg0, YouTubeInitializationResult arg1) {
                                                             }

                                                         });

                                                         if(player!=null){
                                                             System.out.println(videoname);

                                                             player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                                                             player.loadVideo(videoname);
                                                             player.play();
                                                         }

                                                     }

                                                 @Override
                                                  public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
                                                 });


        /*

            if(player1==null){
            System.out.println(videoname);

            player1.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
            player1.loadVideo(videoname);
            player1.play();
        }
        final EditText seekToText = (EditText) findViewById(R.id.seek_to_text);
        Button seekToButton = (Button) findViewById(R.id.seek_to_button);
        seekToButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int skipToSecs = Integer.valueOf(seekToText.getText().toString());
                player.seekToMillis(skipToSecs * 1000);
            }
        });*/
    }


    protected Provider getYouTubePlayerProvider() {
        return youTubeView;
    }
    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

        @Override
        public void onPlaying() {
            // Called when playback starts, either due to user action or call to play().
            showMessage("Playing");
        }

        @Override
        public void onPaused() {
            // Called when playback is paused, either due to user action or call to pause().
            showMessage("Paused");
        }

        @Override
        public void onStopped() {
            // Called when playback stops for a reason other than being paused.
            showMessage("Stopped");
        }

        @Override
        public void onBuffering(boolean b) {
            // Called when buffering starts or ends.
        }

        @Override
        public void onSeekTo(int i) {
            // Called when a jump in playback position occurs, either
            // due to user scrubbing or call to seekRelativeMillis() or seekToMillis()
        }
    }
   /*
    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

        @Override
        public void onLoading() {
            // Called when the player is loading a video
            // At this point, it's not ready to accept commands affecting playback such as play() or pause()
        }

        @Override
        public void onLoaded(String s) {
            // Called when a video is done loading.
            // Playback methods such as play(), pause() or seekToMillis(int) may be called after this callback.
        }

        @Override
        public void onAdStarted() {
            // Called when playback of an advertisement starts.
        }

        @Override
        public void onVideoStarted() {
            // Called when playback of the video starts.
        }

        @Override
        public void onVideoEnded() {
            // Called when the video reaches its end.
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {
            // Called when an error occurs.
        }
    }*/

}
