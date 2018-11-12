package com.example.burhanari.galgeleg_burhan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Vinder extends AppCompatActivity implements View.OnClickListener{

    Galgelogik gl = new Galgelogik();
    Button indsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vinder);

        int forsøg = getIntent().getIntExtra("Forsoeg", 0);
        int score = getIntent().getIntExtra("Score", 0);

        TextView vinderTekst = findViewById(R.id.vinderTekst);
        vinderTekst.setText("Du gættede ordet med en score på: "+score+"\n Du gættede ordet på: " +forsøg+ " forsøg!"+
                                "\n du kan nu fortsætte med at spilde eller indsende din score til highscoren!");
        Button fortsaet = findViewById(R.id.spil_igen);
        indsend = findViewById(R.id.indsend);

        fortsaet.setOnClickListener(this);
        indsend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.spil_igen){
            Intent sp = new Intent(this, Spil.class );
            startActivity(sp);
        }
        else if(v.getId() == R.id.indsend){
            indsend.setText("Coming soon!");
        }
    }
}
