package com.example.android.androidlibraryjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);


        String joke = getIntent().getStringExtra("Joke");


        TextView DisplayJoke = (TextView)findViewById(R.id.textJoke);

        DisplayJoke.setText(joke);

    }
}
