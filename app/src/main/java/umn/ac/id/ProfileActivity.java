package umn.ac.id;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        TextView ref1 = (TextView) findViewById(R.id.ref1);
        TextView ref2 = (TextView) findViewById(R.id.ref2);
        TextView ref3 = (TextView) findViewById(R.id.ref3);
        TextView ref4 = (TextView) findViewById(R.id.ref4);
        TextView ref5 = (TextView) findViewById(R.id.ref5);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());
        ref2.setMovementMethod(LinkMovementMethod.getInstance());
        ref3.setMovementMethod(LinkMovementMethod.getInstance());
        ref4.setMovementMethod(LinkMovementMethod.getInstance());
        ref5.setMovementMethod(LinkMovementMethod.getInstance());
    }

    //Back Button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
