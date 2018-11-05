package com.example.burhanari.galgeleg_burhan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Hjaelp extends AppCompatActivity {

    TextView instr;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hjaelp);

        instr = (TextView) findViewById(R.id.instrukser);
        instr.setText("Instrukser for spillet \n 1. Indtast et bogstav i gættefeltet. \n 2. Tryk på Gær knappen" +
                "\n 3. Se om du har gættet korrekt \n 4.fortsæt indtil spillet er slut. \n 4.5 spillet sluttes når du har gættet " +
                "6 bogstaver forkert eller når du har gættet ordet.");


    }
}
