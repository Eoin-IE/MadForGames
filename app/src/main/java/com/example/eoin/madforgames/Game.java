package com.example.eoin.madforgames;

public class Game {
    public int id;
    public String name;
    public String rating;
    public int icon;

    public String summary;

    public Game(String inputName, String inputRating,int inputIcon) {
        name = inputName;
        rating = inputRating;
        icon = inputIcon;
    }

    public Game(String inputName, String inputRating) {
        name = inputName;
        rating = inputRating;
    }

    public String getSummary() {
        return summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public int getIcon() {
        return icon;
    }
}

