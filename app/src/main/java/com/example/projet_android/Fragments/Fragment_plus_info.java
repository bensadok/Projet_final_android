package com.example.projet_android.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet_android.Models.Character.CharacterRootObject;
import com.example.projet_android.R;
import com.example.projet_android.Utils.api.CharacterCalls;
import com.example.projet_android.recycler_view.CharacterAdapter;
import com.example.projet_android.recycler_view.Character_DataGenerator;

public class Fragment_plus_info extends Fragment implements  CharacterCalls.Callbacks{

    public static final String TAB_NAME = "Personnages";


    private View rootView;
    private CharacterAdapter characterAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    public Fragment_plus_info() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.character_activity, container, false);
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("id",0);


        executeHttpRequestWithRetrofit(id);
        System.out.println("test2");

        setupRecyclerView();
        System.out.println("test3");

        return rootView;
    }





    /**
     * Setup le recycler view with the layout manager (who know wich layout he must use) and the then create an adapter with the current view.
     */
    private void setupRecyclerView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.character_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        characterAdapter = new CharacterAdapter();
        recyclerView.setAdapter(characterAdapter);

    }



    private void executeHttpRequestWithRetrofit(int id){
        String string_id = String.valueOf(id);
        System.out.println(id);
        CharacterCalls.get_characters(this, string_id);
    }




    @Override
    public void onResponse(@Nullable CharacterRootObject chars){
        if (chars != null) this.updateUIWithListOfChar(chars);
        else System.out.println("null");
    }

    @Override
    public void onFailure() {
        System.out.println("errorrr");
    }


    private void updateUIWithListOfChar(CharacterRootObject rootObjects){

        characterAdapter.bindViewModels(Character_DataGenerator.generateCharData(rootObjects));
    }


}
