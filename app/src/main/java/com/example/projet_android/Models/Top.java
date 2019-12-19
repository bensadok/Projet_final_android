package com.example.projet_android.Models;

public class Top {

    private int mal_id;
    private String title;
    private String image_url;
    private String start_date;
    private double score;

    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }



    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }



    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
