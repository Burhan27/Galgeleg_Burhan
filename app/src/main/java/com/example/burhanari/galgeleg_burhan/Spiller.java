package com.example.burhanari.galgeleg_burhan;

public class Spiller {

    private String navn;
    private int score;

    public Spiller(String navn, int score){
        this.navn = navn;
        this.score = score;
    }

    public String getNavn() {
        return navn;
    }

    public int getScore() {
        return score;
    }

}
