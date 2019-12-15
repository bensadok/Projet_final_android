package com.example.projet_android.recycler_view;

import com.example.projet_android.Models.Character.Character;
import com.example.projet_android.Models.Character.CharacterRootObject;
import com.example.projet_android.Models.Top;

import java.util.ArrayList;
import java.util.List;

public class Character_DataGenerator {

    /**
     * Convert the data from the api call (already converted in java) to CharacterViewModel. There we only keep the data we display in the recycler view.
     * @param chars the RootObject obtained by the retrofit request
     * @return A list of AnimeViewModel
     */
    public static List<CharacterViewModel> generateCharData(CharacterRootObject chars) {
        List<CharacterViewModel> charViewModelList = new ArrayList<>();

        for (Character c : chars.getCharacters()) {
            CharacterViewModel a = new CharacterViewModel(c.getName(),c.getRole(),c.getVoice_actors().get(0).getName(),c.getImage_url(),c.getVoice_actors().get(0).getImage_url(),c.getMal_id());
            charViewModelList.add(a);
        }
        return charViewModelList;
    }


}
