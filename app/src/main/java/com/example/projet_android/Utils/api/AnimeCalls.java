package com.example.projet_android.Utils.api;





import androidx.annotation.Nullable;

import com.example.projet_android.Models.RootObject;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AnimeCalls {

        // Creating a callback
        public interface Callbacks {
            void onResponse(@Nullable RootObject users);
            void onFailure();
        }



        // Public method to start fetching users following by Jake Wharton
        public static void get_anime(Callbacks callbacks, String anime){

            // Create a weak reference to callback (avoid memory leaks)
            final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

            // Get a Retrofit instance and the related endpoints
            AnimeService animeService = AnimeService.retrofit.create(AnimeService.class);

            // Create the call on the API
            Call<RootObject> call = animeService.getAnime(anime);
            // Start the call
            call.enqueue(new Callback<RootObject>() {

                @Override
                public void onResponse(Call<RootObject> call, Response<RootObject> response) {
                    // Call the proper callback used in controller (MainFragment)
                    if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
                }

                @Override
                public void onFailure(Call<RootObject> call, Throwable t) {
                    // Call the proper callback used in controller (MainFragment)
                    if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
                }
            });



        }





    }








