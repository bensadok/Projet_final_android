package com.example.projet_android.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.projet_android.Utils.db.AnimeDataBase;
import com.example.projet_android.Utils.db.AnimeDataSourceImpl;
import com.example.projet_android.Utils.db.AnimeRepository;
import com.example.projet_android.Utils.db.Common;
import com.example.projet_android.Models.RootObject_UniqueAnime;
import com.example.projet_android.R;
import com.example.projet_android.Utils.api.AnimeUniqueCall;
import com.example.projet_android.Utils.db.AnimeEntity;

import java.util.List;

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
    private TextView downloading;
    private RootObject_UniqueAnime rootObject_uniqueAnime;
    private Button button_database;
    public boolean in_bdd =false ;




    public void setup_view(){
        this.imageView =  rootView.findViewById(R.id.affiche_imageview);
        this.imageView.setVisibility(View.INVISIBLE);

        this.status_textView = rootView.findViewById(R.id.statut_textView);
        this.status_textView.setVisibility(View.INVISIBLE);

        this.imageView.setVisibility(View.INVISIBLE);

        this.rank_textView = rootView.findViewById(R.id.rank_textView);
        this.rank_textView.setVisibility(View.INVISIBLE);

        this.title_textView = rootView.findViewById(R.id.title_textview);
        this.title_textView.setVisibility(View.INVISIBLE);

        this.synopsis_textView = rootView.findViewById(R.id.synopsis_textView);
        this.synopsis_textView.setVisibility(View.INVISIBLE);

        this.synopsis = rootView.findViewById(R.id.button_synopsis);
        this.synopsis.setVisibility(View.INVISIBLE);

        this.downloading = rootView.findViewById(R.id.downloading_detail);
        this.downloading.setText("Downloading... Please wait !");

        this.nb_episode_textview = rootView.findViewById(R.id.nb_episode_textView);
        this.nb_episode_textview.setVisibility(View.INVISIBLE);

        this.button_database = rootView.findViewById(R.id.button_db);
        this.button_database.setVisibility(View.INVISIBLE);

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

    public void set_view_data(final RootObject_UniqueAnime anime){
        if(anime!=null) {
            this.title_textView.setText(anime.getTitle());
            this.title_textView.setVisibility(View.VISIBLE);

            this.status_textView.setText(anime.getStatus());
            this.status_textView.setVisibility(View.VISIBLE);

            this.rank_textView.setText(String.valueOf("Ranked : " + anime.getRank()));
            this.rank_textView.setVisibility(View.VISIBLE);

            this.nb_episode_textview.setText(anime.getEpisodes() + " épisodes");
            this.nb_episode_textview.setVisibility(View.VISIBLE);

            this.synopsis.setVisibility(View.VISIBLE);
            this.synopsis_textView.setText("");
            this.synopsis_textView.setVisibility(View.VISIBLE);

            Glide.with(this)
                    .load(anime.getImage_url())
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageView);

            this.imageView.setVisibility(View.VISIBLE);
            this.downloading.setVisibility(View.INVISIBLE);

            this.button_database.setVisibility(View.VISIBLE);
            if (!this.in_bdd) {
                this.button_database.setText("Ajouter aux favoris");
            } else {
                this.button_database.setText("Retirer des favoris");
            }
            final RootObject_UniqueAnime final_anime = anime;
            final Fragment_Detail ft = this;
            Common.animeRepository.getAll().observe(ft, new Observer<List<AnimeEntity>>() {
                @Override
                public void onChanged(List<AnimeEntity> list) {
                    System.out.println(list.size() + " taille list");
                    if (list != null) {
                        for (AnimeEntity e : list) {
                            if (e.getIdAnime() == final_anime.mal_id) {
                                System.out.println(e.getIdAnime());
                                in_bdd = true;
                                button_database.setText("Retirer des favoris");
                            }
                        }
                    }
                }
            });
            this.button_database.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    if (in_bdd) {
                        System.out.println(in_bdd);
                        button_database.setText("Ajouter des favoris");
                        AnimeEntity animeEntity = new AnimeEntity();
                        System.out.println(final_anime.getTitle() + "TITLTEEEEE_DELLLL");
                        animeEntity.setAnime_name(final_anime.getTitle());
                        animeEntity.setDate(final_anime.getPremiered());
                        animeEntity.setNote(final_anime.getScore());
                        animeEntity.setIdAnime(final_anime.mal_id);
                        animeEntity.setImage_url(final_anime.image_url);
                        Toast.makeText(ft.getContext(), "Retirer des favoris !", Toast.LENGTH_SHORT).show();
                        Common.animeRepository.delete(animeEntity);
                        in_bdd = false;
                    } else {
                        button_database.setText("Retirer des favoris");
                        AnimeEntity animeEntity = new AnimeEntity();
                        System.out.println(final_anime.getTitle() + "TITLTEEEEE");
                        animeEntity.setAnime_name(final_anime.getTitle());
                        animeEntity.setDate(final_anime.getPremiered());
                        animeEntity.setNote(final_anime.getScore());
                        animeEntity.setIdAnime(final_anime.mal_id);
                        animeEntity.setImage_url(final_anime.image_url);
                        Common.animeRepository.insert(animeEntity);
                        Toast.makeText(ft.getContext(), "Ajouter aux favoris !", Toast.LENGTH_SHORT).show();
                        in_bdd = true;
                    }
                }
            });


        }



    }



    public Fragment_Detail() {
        this.synopsis_displayed = false;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        init_db(rootView);
        setup_view();
        Intent intent = getActivity().getIntent();
        int id = intent.getIntExtra("id",0);
        executeHttpRequestWithRetrofit(id);


        return rootView;
    }

    private void init_db(View v) {
        Common.animeDataBase = AnimeDataBase.getInstance(v.getContext());
        Common.animeRepository = AnimeRepository.getInstance(AnimeDataSourceImpl.getInstance(Common.animeDataBase.animeDao()));
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
