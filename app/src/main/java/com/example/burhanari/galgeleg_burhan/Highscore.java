package com.example.burhanari.galgeleg_burhan;

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

import org.w3c.dom.Text;

public class Highscore extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.highscore);

        String[] navne= {"Simon", "Simen", "Smoune", "Simeain"};

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.highscore_item, R.id.navn, navne){
            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);

                TextView rank = view.findViewById(R.id.rank);
                rank.setText(position+1+"");

                return view;
            }
        };

        ListView listView = (ListView) findViewById(R.id.highscore);
        listView.setAdapter(adapter);
    }

}
