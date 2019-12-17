package com.example.projet_android.Utils.db;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface AnimeDataSource {
    LiveData<List<AnimeEntity>> getAll();
    LiveData<AnimeEntity> getAnimeById(int anime_id);
    void insert(AnimeEntity animeEntity);
    void insertAll(AnimeEntity...animeEntity);
    void delete(AnimeEntity animeEntity);

}
