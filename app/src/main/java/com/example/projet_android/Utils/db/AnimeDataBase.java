package com.example.projet_android.Utils.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AnimeEntity.class}, version = 1,exportSchema = false)
public abstract class AnimeDataBase extends RoomDatabase {
    public abstract AnimeDao animeDao();
    private static AnimeDataBase instance;

    public static AnimeDataBase getInstance(Context context){
        if(instance==null){
            instance = Room.databaseBuilder(context, AnimeDataBase.class, "anime_database").allowMainThreadQueries().build();
        }
        return instance;

    }

}
