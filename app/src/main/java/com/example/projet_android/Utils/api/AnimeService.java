package com.example.projet_android.Utils.api;
import com.example.projet_android.Models.RootObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnimeService {


    @GET("{subtype}")
    Call<RootObject> getAnime(@Path("subtype") String username);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/top/anime/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}




