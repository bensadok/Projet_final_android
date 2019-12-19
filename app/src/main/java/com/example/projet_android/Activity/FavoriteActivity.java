package com.example.projet_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projet_android.Models.RootObject;
import com.example.projet_android.R;
import com.example.projet_android.Utils.db.AnimeEntity;
import com.example.projet_android.Utils.db.Common;
import com.example.projet_android.Utils.db.AnimeDataBase;
import com.example.projet_android.Utils.db.AnimeDataSourceImpl;
import com.example.projet_android.Utils.db.AnimeRepository;
import com.example.projet_android.recycler_view.DataGenerator;
import com.example.projet_android.recycler_view.MyDataAdapter;

import android.content.Intent;


import com.example.projet_android.Models.Top;
import com.example.projet_android.recycler_view.AnimeActionInterface;

import java.util.List;

public class FavoriteActivity extends AppCompatActivity implements AnimeActionInterface {

    private MyDataAdapter myDataAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<AnimeEntity> l_anime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        init_db();
        binding_with_localbase();
        setupRecyclerView();
    }

    /**
     * Initiate the database
     */
    private void init_db() {
        Common.animeDataBase = AnimeDataBase.getInstance(this);
        Common.animeRepository = AnimeRepository.getInstance(AnimeDataSourceImpl.getInstance(Common.animeDataBase.animeDao()));
    }

    /**
     * Setup le recycler view with the layout manager (who know wich layout he must use) and the then create an adapter with the current view.
     */
    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.favorite_recyclerview);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        myDataAdapter = new MyDataAdapter(this);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myDataAdapter);
    }


    /**
     * function who get all the anime in the database.
     */
    private void binding_with_localbase(){
        Common.animeRepository.getAll().observe(this, new Observer<List<AnimeEntity>>() {
            @Override
            public void onChanged(List<AnimeEntity> list) {
                if (list != null) {
                    myDataAdapter.bindViewModels(DataGenerator.generateData_entity(list));
                    l_anime = list;
                }
            }
        });
    }

    /**
     * Open the detail of the anime clicked on
     * @param id the id of the anime clicked on
     */
    @Override
    public void onAnimeClick(int id) {
        for (AnimeEntity t : l_anime){
            if (t.getIdAnime()==id){
                Intent appInfo = new Intent(getApplicationContext(), DetailActivity.class);
                appInfo.putExtra("id", t.getIdAnime());
                startActivity(appInfo);
            }
        }
    }
}
