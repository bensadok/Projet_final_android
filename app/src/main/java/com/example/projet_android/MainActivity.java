package com.example.projet_android;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.projet_android.Fragments.MainFragment;
import com.example.projet_android.Models.RootObject;
import com.example.projet_android.Models.Top;
import com.example.projet_android.Utils.AnimeCalls;
import com.example.projet_android.Utils.NetworkAsyncTask;
import com.example.projet_android.recycler_view.AnimeActionInterface;
import com.example.projet_android.recycler_view.DataGenerator;
import com.example.projet_android.recycler_view.MyDataAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimeActionInterface, NetworkAsyncTask.Listeners, AnimeCalls.Callbacks {

    private MainFragment mainFragment;
    private MyDataAdapter myDataAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        executeHttpRequestWithRetrofit();

        setupRecyclerView();

    }







    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        layoutManager = new LinearLayoutManager(MainActivity.this);


        myDataAdapter = new MyDataAdapter(this);
        recyclerView.setAdapter(myDataAdapter);




    }







    private void executeHttpRequestWithRetrofit(){
        System.out.println("test");
        AnimeCalls.fetchUserFollowing(this, "bypopularity");
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
    public void onResponse(@Nullable RootObject users) {
        // 2.1 - When getting response, we update UI
        if (users != null) this.updateUIWithListOfUsers(users);
    }


    private void updateUIWhenStopingHTTPRequest(String response){
    }


    private void updateUIWhenStartingHTTPRequest(){

    }

    // 3 - Update UI showing only name of users
    private void updateUIWithListOfUsers(RootObject rootObjects){
        List<Top> l_top = rootObjects.getTop() ;
        myDataAdapter.bindViewModels(DataGenerator.generateData(l_top));
    }




























    // -------------------
    // CONFIGURATION
    // -------------------

    private void configureAndShowMainFragment(){

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.activity_main_frame_layout);

        if (mainFragment == null) {
            mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main_frame_layout, mainFragment)
                    .commit();
        }
    }
















    @Override
    public void onAnimeClick() {
    }
}
