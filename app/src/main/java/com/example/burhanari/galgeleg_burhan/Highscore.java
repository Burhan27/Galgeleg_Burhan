package com.example.burhanari.galgeleg_burhan;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class Highscore extends AppCompatActivity {

    RecyclerView hs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);

        hs =(RecyclerView) findViewById(R.id.highscore);



    }
}
