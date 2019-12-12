package com.example.projet_android.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

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
                        animeActionInterface.onAnimeClick(animeViewModel.getMal_id());
                    }
                });
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        animeActionInterface.onAnimeClick(animeViewModel.getMal_id());
                    }
                });
            }




            void bind(AnimeViewModel animeViewModel, int position) {

                this.animeViewModel = animeViewModel;
                this.position = position;
                if(animeViewModel.getName().length() > 23)
                    nameTextView.setText(animeViewModel.getName().substring(0,23)+"...");
                else
                    nameTextView.setText(animeViewModel.getName());
                dateTextView.setText(animeViewModel.getDate());
                noteTextView.setText( "Rated : " + animeViewModel.getNote() +"/10");
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
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);
        AnimeViewHolder animeViewHolder = new AnimeViewHolder(view, animeActionInterface);
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
