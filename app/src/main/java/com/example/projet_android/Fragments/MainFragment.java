package com.example.projet_android.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.projet_android.Models.RootObject;
import com.example.projet_android.Models.Top;
import com.example.projet_android.R;
import com.example.projet_android.Utils.AnimeCalls;
import com.example.projet_android.Utils.NetworkAsyncTask;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment implements NetworkAsyncTask.Listeners, AnimeCalls.Callbacks {

    @BindView(R.id.fragment_main_textview) TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    // -----------------
    // ACTIONS
    // -----------------

    @OnClick(R.id.fragment_main_button)
    public void submit(View view) {
        this.executeHttpRequestWithRetrofit();
    }

    // ------------------
    //  HTTP REQUEST
    // ------------------



    private void executeHttpRequestWithRetrofit(){
        this.textView.setText("Downloading...");
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
        this.textView.setText(response);
    }


    private void updateUIWhenStartingHTTPRequest(){
        this.textView.setText("Downloading...");
    }

    // 3 - Update UI showing only name of users
    private void updateUIWithListOfUsers(RootObject rootObjects){
        List<Top> l_top = rootObjects.getTop() ;
        StringBuilder stringBuilder = new StringBuilder();
        for (Top user : l_top){
            stringBuilder.append("-"+user.getTitle()+"\n");
        }
        updateUIWhenStopingHTTPRequest(stringBuilder.toString());
    }

}