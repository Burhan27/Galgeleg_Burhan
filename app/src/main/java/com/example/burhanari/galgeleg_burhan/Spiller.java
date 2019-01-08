package com.example.burhanari.galgeleg_burhan;

import java.util.ArrayList;

public class Spiller {

    private String navn;
    private int score;

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Spiller(String navn, int score){
        this.navn = navn;
        this.score = score;
    }

    public Spiller(Spiller s){
        Spiller spiller = new Spiller(s.getNavn(),s.getScore());
    }

    public String getNavn() {
        return navn;
    }

    public int getScore() {
        return score;
    }


}
