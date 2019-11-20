package com.example.projet_android.recycler_view;

public class AnimeViewModel {
    private String name;
    private String date;
    private String note;
    private String imageUrl;

    public AnimeViewModel(String name, String date, String note, String imageUrl){
        this.name = name;
        this.date = date;
        this.imageUrl = imageUrl;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



}
