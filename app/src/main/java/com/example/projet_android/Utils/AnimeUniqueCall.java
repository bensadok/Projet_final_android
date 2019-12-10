package com.example.projet_android.Utils;

import android.support.annotation.Nullable;

import com.example.projet_android.Models.RootObject;
import com.example.projet_android.Models.RootObject_UniqueAnime;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeUniqueCall {


    // Creating a callback
    public interface Callbacks {
        void onResponse(@Nullable RootObject_UniqueAnime users);

        void onFailure();
    }


    public static void get_anime_unique(AnimeUniqueCall.Callbacks callbacks, String anime) {

        // Create a weak reference to callback (avoid memory leaks)
        final WeakReference<AnimeUniqueCall.Callbacks> callbacksWeakReference = new WeakReference<AnimeUniqueCall.Callbacks>(callbacks);

        // Get a Retrofit instance and the related endpoints
        AnimeUniqueService animeService = AnimeUniqueService.retrofit.create(AnimeUniqueService.class);

        // Create the call on Github API
        Call<RootObject_UniqueAnime> call = animeService.getAnime(anime);
        // Start the call
        call.enqueue(new Callback<RootObject_UniqueAnime>() {

            @Override
            public void onResponse(Call<RootObject_UniqueAnime> call, Response<RootObject_UniqueAnime> response) {
                // Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null)
                    callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<RootObject_UniqueAnime> call, Throwable t) {
                // Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });

    }
}
