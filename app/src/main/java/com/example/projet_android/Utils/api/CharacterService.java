package com.example.projet_android.Utils.api;

import com.example.projet_android.Models.Character.CharacterRootObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CharacterService {

    @GET("{subtype}/characters_staff")
    Call<CharacterRootObject> getCharacter(@Path("subtype") String username);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v3/anime/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
