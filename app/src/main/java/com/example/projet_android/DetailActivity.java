package com.example.projet_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.projet_android.Models.RootObject;
import com.example.projet_android.Models.RootObject_UniqueAnime;
import com.example.projet_android.Models.UniqueAnime.UniqueAnime;
import com.example.projet_android.Utils.AnimeCalls;
import com.example.projet_android.Utils.AnimeUniqueCall;


public class DetailActivity extends AppCompatActivity implements AnimeUniqueCall.Callbacks {


    private TextView title_textView;
    private  TextView status_textView;
    private ImageView imageView;
    private TextView rank_textView;
    private TextView synopsis_textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",0);
        setup_view();
        executeHttpRequestWithRetrofit(id);


    }


    private void executeHttpRequestWithRetrofit(int id){
        String str_id = String.valueOf(id);
        AnimeUniqueCall.get_anime_unique(this, str_id);
    }

    @Override
    public void onResponse(@Nullable RootObject_UniqueAnime anime) {
        set_view_data(anime);
    }

    @Override
    public void onFailure() {

    }


    public void setup_view(){
        this.imageView =  this.findViewById(R.id.affiche_imageview);
        this.status_textView = this.findViewById(R.id.statut_textView);
        this.rank_textView = this.findViewById(R.id.rank_textView);
        this.title_textView = this.findViewById(R.id.title_textview);
        this.synopsis_textView = this.findViewById(R.id.synopsis_textView);
    }

    public void set_view_data(RootObject_UniqueAnime anime){
        this.title_textView.setText(anime.getTitle());
        this.status_textView.setText(anime.getStatus());
        this.rank_textView.setText(String.valueOf(anime.getRank()));
        this.synopsis_textView.setText(anime.getSynopsis());
        Glide.with(this)
                .load(anime.getImage_url())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);

    }

}
