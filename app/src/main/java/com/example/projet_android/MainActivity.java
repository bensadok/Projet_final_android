package com.example.projet_android;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projet_android.Models.RootObject;
import com.example.projet_android.Models.Top;
import com.example.projet_android.Utils.AnimeCalls;
import com.example.projet_android.Utils.NetworkAsyncTask;
import com.example.projet_android.recycler_view.AnimeActionInterface;
import com.example.projet_android.recycler_view.DataGenerator;
import com.example.projet_android.recycler_view.MyDataAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimeActionInterface, NetworkAsyncTask.Listeners, AnimeCalls.Callbacks {

    private MyDataAdapter myDataAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Top> l_top;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        executeHttpRequestWithRetrofit();

        setupRecyclerView();

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
     * Call the fonction get_anime from my AnimeCall class wich ll do the Api call
     */
    private void executeHttpRequestWithRetrofit(){
        AnimeCalls.get_anime(this, "bypopularity");
    }

    @Override
    public void onPreExecute() {
        this.updateUIWhenStartingHTTPRequest();
    }

    @Override
    public void doInBackground() { }

    @Override
    public void onPostExecute(String json) {
        this.updateUIWhenStopingHTTPRequest(json);
    }

    // ------------------
    //  UPDATE UI
    // ------------------

    @Override
    public void onFailure() {
        // 2.2 - When getting error, we update UI
        this.updateUIWhenStopingHTTPRequest("An error happened !");
    }

    @Override
    public void onResponse(@Nullable RootObject anime) {
        // 2.1 - When getting response, we update UI
        if (anime != null) this.updateUIWithListOfAnime(anime);
    }


    private void updateUIWhenStopingHTTPRequest(String response){
    }


    private void updateUIWhenStartingHTTPRequest(){

    }

    // 3 - Update UI showing only name of users

    private void updateUIWithListOfAnime(RootObject rootObjects){
        l_top = rootObjects.getTop() ;
        myDataAdapter.bindViewModels(DataGenerator.generateData(l_top));
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
