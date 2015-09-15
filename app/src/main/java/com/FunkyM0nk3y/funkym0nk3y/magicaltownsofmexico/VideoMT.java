package com.FunkyM0nk3y.funkym0nk3y.magicaltownsofmexico;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

/**
 * Created by FunkyM0nk3y on 9/13/15.
 */
public class VideoMT extends ActionBarActivity implements YouTubePlayer.OnInitializedListener{
    private YouTubePlayerFragment youTubePlayerFragment;
    private YouTubePlayer youTubePlayer;
    private String KEY = "AIzaSyAKH6LtOVWdH5TlcY0USYFUuux32qIgwnc";
    private String VIDEO = "BxQO6TFMmuo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_video);

        loadYouTubeFragment();
    }

    private void loadYouTubeFragment() {
        youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentByTag("youtube");

        if (youTubePlayerFragment == null || !youTubePlayerFragment.isInLayout()) {
            youTubePlayerFragment = new YouTubePlayerFragment();
            FragmentTransaction tr = getFragmentManager().beginTransaction();
            tr.replace(R.id.container, youTubePlayerFragment);
            tr.commit();
        }
        youTubePlayerFragment.initialize(KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(VIDEO);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_about:
                Intent about = new Intent(this, About.class);
                about.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(about);
                return true;
            case R.id.action_home:
                Intent main = new Intent(this, MainActivity.class);
                main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                return true;
            case R.id.action_video:
                Intent video = new Intent(this, VideoMT.class);
                video.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(video);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
