package com.example.projet_android.Utils.db;

import java.util.List;

import androidx.lifecycle.LiveData;

public class AnimeDataSourceImpl implements AnimeDataSource {

    private AnimeDao animeDao;
    private static AnimeDataSourceImpl instance;


    public AnimeDataSourceImpl(AnimeDao animeDao){
        this.animeDao = animeDao;
    }

    public static AnimeDataSourceImpl getInstance(AnimeDao animeDao){
        if(instance ==null){
            instance = new AnimeDataSourceImpl(animeDao);
        }
        return instance;
    }

    @Override
    public LiveData<List<AnimeEntity>> getAll() {
        return animeDao.getAll();
    }

    @Override
    public LiveData<AnimeEntity> getAnimeById(int anime_id) {
        return animeDao.getById(anime_id);
    }

    @Override
    public void insertAll(AnimeEntity... animeEntity) {
        animeDao.insertAll(animeEntity);
    }

    @Override
    public void insert(AnimeEntity animeEntity) {
        animeDao.insert(animeEntity);
    }


    @Override
    public void delete(AnimeEntity animeEntity) {
        animeDao.delete(animeEntity);
    }
}
