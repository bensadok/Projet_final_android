package com.example.projet_android.Utils.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "anime_entity")
public class AnimeEntity {

    @PrimaryKey
    @NonNull
    public int idAnime;

    @ColumnInfo(name = "anime_name")
    public String anime_name;

    @ColumnInfo(name = "image_url")
    public String image_url;

    @ColumnInfo(name= "date")
    public String date;

    @ColumnInfo(name = "note")
    public Double note;

    public int getIdAnime() {
        return idAnime;
    }

    public void setIdAnime(int idAnime) {
        this.idAnime = idAnime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }


    public String getAnime_name() {
        return anime_name;
    }

    public void setAnime_name(String anime_name) {
        this.anime_name = anime_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
