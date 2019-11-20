package com.example.projet_android.recycler_view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.projet_android.R;

import java.util.ArrayList;
import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.AnimeViewHolder> {

    public static class AnimeViewHolder extends RecyclerView.ViewHolder{
        private TextView nameTextView;
        private TextView dateTextView;
        private TextView noteTextView;
        private ImageView imageView;
        private ImageButton imageButton;
        private AnimeViewModel animeViewModel;
        private AnimeActionInterface animeActionInterface;
        private int position;
        private View v;

        public AnimeViewHolder(View v, final AnimeActionInterface animeActionInterface) {
            super(v);
            this.v = v;
            nameTextView = v.findViewById(R.id.nom_textView);
            dateTextView = v.findViewById(R.id.date_textView);
            noteTextView = v.findViewById(R.id.note_textView);
            imageView = v.findViewById(R.id.icon_imageview);
            imageButton = v.findViewById(R.id.img_btn);
            this.animeActionInterface = animeActionInterface;
            setupListeners();
            // A COMPLETER
        }

            private void setupListeners(){
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        animeActionInterface.onAnimeClick();
                    }
                });
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        animeActionInterface.onAnimeClick();
                    }
                });
            }




            void bind(AnimeViewModel animeViewModel, int position) {

                this.animeViewModel = animeViewModel;
                this.position = position;

                nameTextView.setText(animeViewModel.getName());
                dateTextView.setText(animeViewModel.getDate());
                noteTextView.setText(animeViewModel.getNote());
                Glide.with(v)
                        .load(animeViewModel.getImageUrl())
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(imageView);

            }


        }
    private List<AnimeViewModel> animeViewModelList;
    private  AnimeActionInterface animeActionInterface;

    public MyDataAdapter(AnimeActionInterface animeActionInterface){
        animeViewModelList = new ArrayList<>();
        this.animeActionInterface = animeActionInterface;
    }

    public void bindViewModels(List<AnimeViewModel> animeViewModelList) {
        this.animeViewModelList.clear();
        this.animeViewModelList.addAll(animeViewModelList);
        notifyDataSetChanged();
    }




    @Override
    public AnimeViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview, parent, false);
        AnimeViewHolder animeViewHolder = new AnimeViewHolder(v, animeActionInterface);
        return animeViewHolder;
    }


    @Override
    public void onBindViewHolder(AnimeViewHolder holder, int position) {
        holder.bind(animeViewModelList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return animeViewModelList.size();
    }













}
