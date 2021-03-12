package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

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

    @Override
    protected void onResume() {
        super.onResume();
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
    }
}