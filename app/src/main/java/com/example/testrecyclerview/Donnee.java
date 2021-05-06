package com.example.testrecyclerview;

public class Donnee {

    String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};
    String[] planet = {"Mercure", "Venus", "Terre", "Mars", "Jupiter", "Saturne", "Uranus", "Neptune", "Pluton"};
    int[] image = {R.drawable.mercure, R.drawable.venus,R.drawable.terre, R.drawable.mars,R.drawable.jupiter, R.drawable.saturne,R.drawable.uranus, R.drawable.neptune,R.drawable.pluton};
    com.example.testrecyclerview.MainActivity m;
    public Donnee(com.example.testrecyclerview.MainActivity mainActivity) {
        m = mainActivity;
    }

    int images;
    private String planetes;
    private String tailles;



    Donnee (String planete, String taille, int image){
        images=image;
        planetes = planete;
        tailles = taille;
    }

    public String getPlanete() {

        return planetes;
    }

    public String getTailles() {

        return tailles;
    }

    public int getImages() {
        return images;
    }

}