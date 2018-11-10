package com.example.burhanari.galgeleg_burhan;


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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spil);

        ord = (TextView) findViewById(R.id.ordText);

        new Thread(new Runnable() {
            public void run(){
                try {
                    gl.hentOrdFraDr();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        ord.setText("Gæt ordet: " +gl.getSynligtOrd());
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
            ord.setText("Du har tabt..");
        }
        if(gl.erSpilletVundet()){
            ord.setText("Du har vundet!");
        }
    }





}
