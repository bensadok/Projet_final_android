package com.example.projet_android.recycler_view;

import com.example.projet_android.Models.Top;
import com.example.projet_android.Utils.db.AnimeEntity;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    /**
     * Convert the data from the api call (already converted in java) to AnimeViewModel.
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

    /**
     * Convert the data from the local database to AnimeViewModel.
     * @param list_entity the list of all the anime in the local database.
     * @return A list of AnimeViewModel
     */
    public static List<AnimeViewModel> generateData_entity(List<AnimeEntity> list_entity) {
        List<AnimeViewModel> animeViewModelList = new ArrayList<>();

        for (AnimeEntity t : list_entity) {
            String d = Double.toString(t.getNote());
            AnimeViewModel a = new AnimeViewModel(t.getAnime_name(),t.getDate(), d,t.getImage_url(),t.getIdAnime());
            animeViewModelList.add(a);
        }
        return animeViewModelList;
    }
}
