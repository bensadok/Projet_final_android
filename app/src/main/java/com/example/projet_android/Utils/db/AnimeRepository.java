package com.example.projet_android.Utils.db;

import java.util.List;

import androidx.lifecycle.LiveData;

public class AnimeRepository implements AnimeDataSource{

    private AnimeDataSource animeDataSource;

    public AnimeRepository(AnimeDataSource animeDataSource){
        this.animeDataSource = animeDataSource;
    }

    private  static AnimeRepository instance;

    public static AnimeRepository getInstance(AnimeDataSource animeDataSource){
        if(instance==null){
            instance = new AnimeRepository(animeDataSource);
        }
        return instance;
    }

    @Override
    public LiveData<List<AnimeEntity>> getAll() {
        return animeDataSource.getAll();
    }

    @Override
    public LiveData<AnimeEntity> getAnimeById(int anime_id) {
        return animeDataSource.getAnimeById(anime_id);
    }

    @Override
    public void insertAll(AnimeEntity... animeEntity) {
        animeDataSource.insertAll(animeEntity);

    }

    @Override
    public void insert(AnimeEntity animeEntity){
        animeDataSource.insert(animeEntity);
    }

    @Override
    public void delete(AnimeEntity animeEntity) {
        animeDataSource.delete(animeEntity);
    }
}
