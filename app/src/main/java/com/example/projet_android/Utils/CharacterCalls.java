package com.example.projet_android.Utils;

import androidx.annotation.Nullable;

import com.example.projet_android.Models.Character.CharacterRootObject;


import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterCalls {


    // Creating a callback
    public interface Callbacks {
        void onResponse(@Nullable CharacterRootObject users);

        void onFailure();
    }


    public static void get_characters(CharacterCalls.Callbacks callbacks, String anime) {

        // Create a weak reference to callback (avoid memory leaks)
        final WeakReference<CharacterCalls.Callbacks> callbacksWeakReference = new WeakReference<CharacterCalls.Callbacks>(callbacks);

        // Get a Retrofit instance and the related endpoints
        CharacterService characterService = CharacterService.retrofit.create(CharacterService.class);

        // Create the call on Github API
        Call<CharacterRootObject> call = characterService.getCharacter(anime);
        // Start the call
        call.enqueue(new Callback<CharacterRootObject>() {

            @Override
            public void onResponse(Call<CharacterRootObject> call, Response<CharacterRootObject> response) {
                // Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null)
                    callbacksWeakReference.get().onResponse(response.body());
            }

            @Override
            public void onFailure(Call<CharacterRootObject> call, Throwable t) {
                // Call the proper callback used in controller (MainFragment)
                if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
            }
        });

    }
}
