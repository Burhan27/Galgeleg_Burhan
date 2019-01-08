package com.example.burhanari.galgeleg_burhan;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Spil extends AppCompatActivity implements View.OnClickListener{

    Galgelogik gl= new Galgelogik();
    TextView ord;
    ImageView glg;
    Button gk;
    EditText gb;
    int score;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spil);

        ord = (TextView) findViewById(R.id.ordText);

        new AsyncTask(){
            @Override
            protected Object doInBackground(Object... arg0){
                try {
                    gl.hentOrdFraDr();
                    return "Ordene er hentet";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "Fejl!";
                }
            }

            @Override
            protected void onPostExecute(Object resultat){
                gl.nulstil();
                ord.setText("Gæt ordet: " +gl.getSynligtOrd());
            }

        }.execute();

        score = getIntent().getIntExtra("Score", 0);
        gl.setScore(score);
        glg = (ImageView) findViewById(R.id.Galge);
        gk= (Button) findViewById(R.id.gætKnap);
        gk.setOnClickListener(this);
        gb= (EditText) findViewById(R.id.gætBox);
    }

    @Override
    public void onClick(View v) {
        spil();
        gb.setText("");
        gl.logStatus();
    }

    public void spil(){

        gl.gætBogstav(gb.getText().toString());
        ord.setText("Gæt ordet: " +gl.getSynligtOrd());
        ord.append("\n\n Du har gættet " +gl.getAntalForkerteBogstaver()+" bogstaver forkert"+"\n du har gættet følgende bogstaver: " +gl.getBrugteBogstaver() +"\n Din score =" +gl.getScore() );


        if(gl.getAntalForkerteBogstaver() == 1){
            glg.setImageResource(R.drawable.forkert1);
        }
        else if(gl.getAntalForkerteBogstaver() == 2){
            glg.setImageResource(R.drawable.forkert2);
        }
        else if(gl.getAntalForkerteBogstaver() == 3){
            glg.setImageResource(R.drawable.forkert3);
        }
        else if(gl.getAntalForkerteBogstaver() == 4){
            glg.setImageResource(R.drawable.forkert5);
        }
        else if(gl.getAntalForkerteBogstaver() == 5){
            glg.setImageResource(R.drawable.forkert5);
        }
        else if(gl.getAntalForkerteBogstaver() == 6){
            glg.setImageResource(R.drawable.forkert6);
            gl.erSpilletTabt();
            gl.setScore(0);
            Intent taber= new Intent(this,Taber.class);
            startActivity(taber);

        }
        if(gl.erSpilletVundet()){
            Intent vinder = new Intent(this, Vinder.class);
            vinder.putExtra("Forsoeg", gl.getBrugteBogstaver().size());
            vinder.putExtra("Score", gl.getScore());
            startActivity(vinder);

        }
    }





}
