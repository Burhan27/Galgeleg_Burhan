package com.example.burhanari.galgeleg_burhan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity implements View.OnClickListener{

    Button hs, sp, hp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        hs = (Button) findViewById(R.id.hiscore);
        hs.setOnClickListener(this);
        sp = (Button) findViewById(R.id.spil);
        sp.setOnClickListener(this);
        hp = (Button) findViewById(R.id.hjælp);
        hp.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.spil){
            Intent sp = new Intent(this, MainActivity.class );
            startActivity(sp);
        } else if (v.getId() == R.id.hjælp){
            Intent hp = new Intent(this, Hjaelp.class);
            startActivity(hp);
        } else if (v.getId() == R.id.hiscore){
            Intent hs = new Intent(this, Highscore.class);
            startActivity(hs);
        }


    }


}
