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

public class CharacterAdapter  extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {


        public static class CharacterViewHolder extends RecyclerView.ViewHolder{


            private TextView nameTextView;
            private TextView roleTextView;
            private TextView doubleurTextView;
            private ImageView char_imageView;
            private ImageView doubleur_imageView;
            private ImageButton imageButton;
            private CharacterViewModel characterViewModel;
            private int position;
            private View v;

            public CharacterViewHolder(View v) {
                super(v);
                this.v = v;
                nameTextView = v.findViewById(R.id.character_nom_textView);
                roleTextView = v.findViewById(R.id.role_textView);
                doubleurTextView = v.findViewById(R.id.doubleur_textView);
                doubleur_imageView = v.findViewById(R.id.doubleur_imageview);
                imageButton = v.findViewById(R.id.character_img_btn_character);
            }





            void bind(CharacterViewModel characterViewModel, int position) {

                this.characterViewModel = characterViewModel;
                this.position = position;
                nameTextView.setText(characterViewModel.getName());
                roleTextView.setText(characterViewModel.getRole());
                doubleurTextView.setText(characterViewModel.getVoice_actor());
                Glide.with(v)
                        .load(characterViewModel.getImageUrl())
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(char_imageView);
                Glide.with(v)
                        .load(characterViewModel.getVoice_actor_imageUrl())
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(doubleur_imageView);

            }


        }

        private List<CharacterViewModel> characterViewModelsList;

    public CharacterAdapter(){
        characterViewModelsList = new ArrayList<>();
        }

        public void bindViewModels(List<CharacterViewModel> characterViewModelsList) {
            this.characterViewModelsList.clear();
            this.characterViewModelsList.addAll(characterViewModelsList);
            notifyDataSetChanged();
        }




        @Override
        public CharacterViewHolder onCreateViewHolder(ViewGroup parent,
        int viewType) {
            // create a new view
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.character_recycler_view, parent, false);
            CharacterViewHolder characterViewHolder = new CharacterViewHolder(view);
            return characterViewHolder;
        }


        @Override
        public void onBindViewHolder(CharacterViewHolder holder, int position) {
            holder.bind(characterViewModelsList.get(position), position);
        }

        @Override
        public int getItemCount() {
            return characterViewModelsList.size();
        }


    }

