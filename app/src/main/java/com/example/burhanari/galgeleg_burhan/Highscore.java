package com.example.burhanari.galgeleg_burhan;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Highscore extends AppCompatActivity {

    ArrayList<Spiller> spillers = new ArrayList<Spiller>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.highscore);

        Gson gson = new Gson();
        if(gson.fromJson(getIntent().getStringExtra("Spiller"),Spiller.class) != null) {
            Spiller spiller = gson.fromJson(getIntent().getStringExtra("Spiller"), Spiller.class);
            spillers.add(spiller);
            sortSpillers(spillers);
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
}
