package com.example.burhanari.galgeleg_burhan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Highscore extends AppCompatActivity implements View.OnClickListener {


    ArrayList<Spiller> spillers = new ArrayList<Spiller>();
    ArrayList<String> highscore = new ArrayList<String>();
    Gson gson = new Gson();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.highscore);

        ImageButton back = findViewById(R.id.backarrow);
        back.setOnClickListener(this);

        SharedPreferences prefs = getSharedPreferences("Highscore",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        if(prefs.getStringSet("Highscores", null) != null){
            Set<String> temp = prefs.getStringSet("Highscores", null);
            highscore = new ArrayList<String>(temp);
            for(String s: highscore){
                Spiller spiller = gson.fromJson(s,Spiller.class);
                spillers.add(spiller);
            }
        }

        if(gson.fromJson(getIntent().getStringExtra("Spiller"),Spiller.class) != null) {
            Spiller spiller = gson.fromJson(getIntent().getStringExtra("Spiller"), Spiller.class);
            spillers.add(spiller);
            sortSpillers(spillers);

            for(Spiller s: spillers){
                String hspiller = gson.toJson(s);
                highscore.add(hspiller);
            }

            Set<String> set = new HashSet<String>();
            set.addAll(highscore);
            editor.putStringSet("Highscores", set);
            editor.commit();
        }


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.highscore_item, R.id.navn, spillers){
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);

                TextView rank = view.findViewById(R.id.rank);
                rank.setText(position+1+"");
                TextView navn = view.findViewById(R.id.navn);
                navn.setText(spillers.get(position).getNavn());
                TextView score = view.findViewById(R.id.score);
                score.setText(spillers.get(position).getScore()+"");

                return view;
            }
        };

        ListView listView = (ListView) findViewById(R.id.highscore);
        listView.setAdapter(adapter);
    }
    public ArrayList<Spiller> sortSpillers(ArrayList<Spiller> spillers){
        for(int i=spillers.size()-1; i>0; i-- ){
            if(spillers.get(i).getScore() > spillers.get(i-1).getScore()){
                Spiller temp = new Spiller(spillers.get(i-1).getNavn(),spillers.get(i-1).getScore());

                spillers.get(i-1).setNavn(spillers.get(i).getNavn());
                spillers.get(i-1).setScore(spillers.get(i).getScore());

                spillers.get(i).setNavn(temp.getNavn());
                spillers.get(i).setScore(temp.getScore());

            }
        } return spillers;
    }

    @Override
    public void onClick(View v) {
        Intent st = new Intent(this, Start.class );
        startActivity(st);
        finish();
    }
}
