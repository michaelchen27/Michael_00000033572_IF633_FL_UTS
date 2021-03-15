package umn.ac.id;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    private Button login_button;
    private EditText username;
    private EditText password;
    private TextView errormsg;
    private ProgressBar spinner;
    public static Boolean loggedIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Button login_button = (Button) findViewById(R.id.login_button);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        TextView errormsg = (TextView) findViewById(R.id.errormsg);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);

        loggedIn = false;

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean status = validate(username.getText().toString(), password.getText().toString());
                if (status) {
                    spinner.setVisibility(View.VISIBLE);
                    login_button.setText("LOGGING IN...");
                    loggedIn = true;
                    startActivity(new Intent(LoginActivity.this, MusicActivity.class));
                    finish();
                } else {
                    errormsg.setText("Invalid Credentials");
                    username.setText("");
                    password.setText("");
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView errormsg = (TextView) findViewById(R.id.errormsg);
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        errormsg.setText("");
        spinner.setVisibility(View.GONE);
    }

    private boolean validate(String username, String password) {
        return (username.equals("uasmobile")) && password.equals("uasmobilegenap");
    }

    // Back Button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
