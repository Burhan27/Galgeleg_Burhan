package com.example.burhanari.galgeleg_burhan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Taber extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taber);

        TextView tekst = findViewById(R.id.taberTekst);
        tekst.setText("Du tabte desværre! tryk på knappen for at prøve igen!");
        Button rt = findViewById(R.id.proev_igen);
        rt.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent sp = new Intent(this, Spil.class );
        startActivity(sp);
    }
}
