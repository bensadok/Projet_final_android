package com.example.projet_android.recycler_view;

import com.example.projet_android.Models.Top;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public static List<AnimeViewModel> generateData(List<Top> top) {
        List<AnimeViewModel> animeViewModelList = new ArrayList<>();

        for (Top t : top) {
            String d = Double.toString(t.getScore());
            AnimeViewModel a = new AnimeViewModel(t.getTitle(),t.getStart_date(), d,t.getImage_url());
            animeViewModelList.add(a);
        }
        return animeViewModelList;
    }
}
