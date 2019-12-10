package com.example.projet_android.recycler_view;

import com.example.projet_android.Models.Top;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    /**
     * Convert the data from the api call (already converted in java) to AnimeViewModel. There we only keep the data we display in the recycler view.
     * @param top the list of all the anime.
     * @return A list of AnimeViewModel
     */
    public static List<AnimeViewModel> generateData(List<Top> top) {
        List<AnimeViewModel> animeViewModelList = new ArrayList<>();

        for (Top t : top) {
            String d = Double.toString(t.getScore());
            AnimeViewModel a = new AnimeViewModel(t.getTitle(),t.getStart_date(), d,t.getImage_url(),t.getMal_id());
            animeViewModelList.add(a);
        }
        return animeViewModelList;
    }
}
