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
    private List<Top> l_top;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        init_db();
        binding_with_localbase();
        setupRecyclerView();
    }

    private void init_db() {
        Common.animeDataBase = AnimeDataBase.getInstance(this);
        Common.animeRepository = AnimeRepository.getInstance(AnimeDataSourceImpl.getInstance(Common.animeDataBase.animeDao()));
    }

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


    private void binding_with_localbase(){
        Common.animeRepository.getAll().observe(this, new Observer<List<AnimeEntity>>() {
            @Override
            public void onChanged(List<AnimeEntity> list) {
                if (list != null) {
                    myDataAdapter.bindViewModels(DataGenerator.generateData_entity(list));
                }
            }
        });
    }


    @Override
    public void onAnimeClick(int id) {
        for (Top t : l_top){
            if (t.getMal_id()==id){
                Intent appInfo = new Intent(getApplicationContext(), DetailActivity.class);
                appInfo.putExtra("id", t.getMal_id());
                startActivity(appInfo);
            }
        }
    }
}
