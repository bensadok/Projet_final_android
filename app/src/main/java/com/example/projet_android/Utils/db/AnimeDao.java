package com.example.projet_android.Utils.db;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AnimeDao {

    @Query("SELECT * FROM anime_entity")
    LiveData<List<AnimeEntity>> getAll();

    @Query("SELECT * FROM anime_entity where idAnime=:anime_id")
    LiveData<AnimeEntity> getById(int anime_id);

    @Insert
    void insertAll(AnimeEntity...animeEntity);

    @Insert
    void insert(AnimeEntity animeEntity);

    @Delete
    void delete(AnimeEntity animeEntity);

}
