package com.example.burhanari.galgeleg_burhan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class Vinder extends AppCompatActivity implements View.OnClickListener{

    Galgelogik gl = new Galgelogik();
    Button indsend;
    Spiller spiller;
    EditText navn;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vinder);

        int forsøg = getIntent().getIntExtra("Forsoeg", 0);
        score = getIntent().getIntExtra("Score", 0);

        TextView vinderTekst = findViewById(R.id.vinderTekst);
        vinderTekst.setText("Du gættede ordet med en score på: "+score+"\n Du gættede ordet på: " +forsøg+ " forsøg!"+
                                "\n du kan nu fortsætte med at spille eller indsende din score til highscoren!");
        Button fortsaet = findViewById(R.id.spil_igen);
        indsend = findViewById(R.id.indsend);

        fortsaet.setOnClickListener(this);
        indsend.setOnClickListener(this);

        navn = findViewById(R.id.navn);
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.spil_igen){
            Intent sp = new Intent(this, Spil.class );
            sp.putExtra("Score", score);
            startActivity(sp);
            finish();
        }
        else if(v.getId() == R.id.indsend){
            spiller = new Spiller(navn.getText().toString(), score);
            Gson gson = new Gson();
            String spillerInfo = gson.toJson(spiller);
            Intent sp = new Intent(this, Highscore.class);
            sp.putExtra("Spiller",spillerInfo);
            startActivity(sp);
            finish();
        }
    }
}
