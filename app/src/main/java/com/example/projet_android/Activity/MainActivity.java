package com.example.projet_android.Activity;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet_android.Models.RootObject;
import com.example.projet_android.Models.Top;
import com.example.projet_android.R;
import com.example.projet_android.Utils.api.AnimeCalls;
import com.example.projet_android.recycler_view.AnimeActionInterface;
import com.example.projet_android.recycler_view.DataGenerator;
import com.example.projet_android.recycler_view.MyDataAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimeActionInterface,  AnimeCalls.Callbacks {

    private MyDataAdapter myDataAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Top> l_top;
    private FloatingActionButton floatingActionButton;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        tv = findViewById(R.id.downloading_main);
        this.tv.setText("Downloading... Please wait !");
        executeHttpRequestWithRetrofit();

        setupRecyclerView();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    /**
     * Setup the favorite button in the menu
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_layout:
                Intent appInfo = new Intent(getApplicationContext(), FavoriteActivity.class);
                startActivity(appInfo);
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Setup le recycler view with the layout manager (who know wich layout he must use) and the then create an adapter with the current view.
     */
    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        myDataAdapter = new MyDataAdapter(this);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layoutManager instanceof GridLayoutManager) {
                    layoutManager = new LinearLayoutManager(MainActivity.this);
                    Drawable d  =  getResources().getDrawable(R.drawable.ic_view_module_black_24dp);
                    floatingActionButton.setImageDrawable(d);
                    myDataAdapter.setLayout("linear");
                } else {
                    layoutManager = new GridLayoutManager(MainActivity.this, 2);
                    Drawable d  =  getResources().getDrawable(R.drawable.ic_view_list_black_24dp);
                    floatingActionButton.setImageDrawable(d);
                    myDataAdapter.setLayout("grid");

                }
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(myDataAdapter);
            }
        });
        recyclerView.setAdapter(myDataAdapter);






    }


    /**
     * Call the fonction get_anime from my AnimeCall class wich ll do the Api call on the most popular anime
     */
    private void executeHttpRequestWithRetrofit(){
        AnimeCalls.get_anime(this, "bypopularity");
    }


    @Override
    public void onFailure() {

    }

    @Override
    public void onResponse(@Nullable RootObject anime) {
        // 2.1 - When getting response, we update UI
        tv.setVisibility(View.INVISIBLE);
        if (anime != null) this.updateUIWithListOfAnime(anime);
    }





    /**
     * @param rootObjects the root_object you get by calling the api
     */
    private void updateUIWithListOfAnime(RootObject rootObjects){
        if(rootObjects!=null) {
            l_top = rootObjects.getTop();
            myDataAdapter.bindViewModels(DataGenerator.generateData(l_top));
        }
        else{
            executeHttpRequestWithRetrofit();
        }
    }

    /**
     * When you click on an item you will open a new Activity with detail about the choosen anime.
     * @param id  the mal_id of the anime
     */
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
