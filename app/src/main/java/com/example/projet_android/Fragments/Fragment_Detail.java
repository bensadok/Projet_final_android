package com.example.projet_android.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.projet_android.Models.RootObject_UniqueAnime;
import com.example.projet_android.R;
import com.example.projet_android.Utils.AnimeUniqueCall;

public class Fragment_Detail extends Fragment implements AnimeUniqueCall.Callbacks {

    public static final String TAB_NAME = "Détail";


    private View rootView;
    private TextView title_textView;
    private  TextView status_textView;
    private ImageView imageView;
    private TextView rank_textView;
    private TextView synopsis_textView;
    private TextView nb_episode_textview;
    private Button synopsis;
    private Boolean synopsis_displayed;

    private RootObject_UniqueAnime rootObject_uniqueAnime;






    public void setup_view(){
        this.imageView =  rootView.findViewById(R.id.affiche_imageview);
        this.status_textView = rootView.findViewById(R.id.statut_textView);
        this.rank_textView = rootView.findViewById(R.id.rank_textView);
        this.title_textView = rootView.findViewById(R.id.title_textview);
        this.synopsis_textView = rootView.findViewById(R.id.synopsis_textView);
        this.synopsis = rootView.findViewById(R.id.button_synopsis);
        this.nb_episode_textview = rootView.findViewById(R.id.nb_episode_textView);
        synopsis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!synopsis_displayed){
                    synopsis_textView.setText(rootObject_uniqueAnime.getSynopsis());
                    synopsis_displayed = true;
                    synopsis.setText("Hide Synopsis");
                }
                else{
                    synopsis_textView.setText("");
                    synopsis_displayed = false;
                    synopsis.setText("Display Synopsis");

                }
            }
        });
    }

    public void set_view_data(RootObject_UniqueAnime anime){
        this.title_textView.setText(anime.getTitle());
        this.status_textView.setText(anime.getStatus());
        this.rank_textView.setText(String.valueOf("Ranked : "+anime.getRank()));
        this.nb_episode_textview.setText(anime.getEpisodes()+" épisodes");
        this.synopsis_textView.setText("");
        Glide.with(this)
                .load(anime.getImage_url())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }



    public Fragment_Detail() {
        this.synopsis_displayed = false;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        setup_view();
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("id",0);
        executeHttpRequestWithRetrofit(id);


        return rootView;
    }



    private void executeHttpRequestWithRetrofit(int id){
        String str_id = String.valueOf(id);
        AnimeUniqueCall.get_anime_unique(this, str_id);
    }

    @Override
    public void onResponse(@Nullable RootObject_UniqueAnime anime) {
        this.rootObject_uniqueAnime = anime;
        set_view_data(anime);
    }

    @Override
    public void onFailure() {

    }




}
