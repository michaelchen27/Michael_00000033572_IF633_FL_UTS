package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import static umn.ac.id.LoginActivity.loggedIn;

public class MainActivity extends AppCompatActivity {
    private Button profile_button;
    private Button login_button;
    public static Activity fa;
    private ProgressBar spinner;

    public MainActivity() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fa = this;
        loggedIn = false;

        randomizeBg();

        Button profile_button = (Button) findViewById(R.id.profile_button);
        Button login_button = (Button) findViewById(R.id.login_button);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);


        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loggedIn) {
                    spinner.setVisibility(View.VISIBLE);
                    startActivity(new Intent(MainActivity.this, MusicActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        });
    }

    protected void randomizeBg() {
        int[] photos = {R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4, R.drawable.bg5, R.drawable.bg6, R.drawable.bg7, R.drawable.bg8, R.drawable.bg9, R.drawable.bg10};
        ImageView imageView = findViewById(R.id.home_bg);

        Random ran = new Random();
        int i = ran.nextInt(photos.length);
        imageView.setImageResource(photos[i]);
    }

    @Override
    protected void onResume() {
        super.onResume();
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
        randomizeBg();
    }
}