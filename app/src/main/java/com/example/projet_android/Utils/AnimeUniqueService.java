package com.example.projet_android.Utils;

import com.example.projet_android.Models.RootObject_UniqueAnime;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AnimeUniqueService {

    @GET("{subtype}")
    Call<RootObject_UniqueAnime> getAnime(@Path("subtype") String username);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/anime/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
