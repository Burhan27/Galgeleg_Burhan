package com.example.burhanari.galgeleg_burhan;

import android.support.v7.app.AppCompatActivity;

public class Highscore extends AppCompatActivity {
        /**implements AdapterView.OnItemClickListener {

    Spiller spiller1 = new Spiller("Jack", 190);
    Spiller spiller2 = new Spiller("Jones", 185);

    Spiller[] test = {spiller1, spiller2};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.highscore, test){
            @Override
            public View getView(int position, View cachedView, ViewGroup parent){
                View view = super.getView(position, cachedView, parent);

                TextView rank = view.findViewById(R.id.rank);
                rank.setText();
            }
        }
    }

    public int getIndex(String navn)
    {
        for(Spiller spiller : test)
        {
            if(spiller.getNavn().equals(navn))
                return test.indexOf(spiller);
        }
        return -1;
    }
    **/
}
