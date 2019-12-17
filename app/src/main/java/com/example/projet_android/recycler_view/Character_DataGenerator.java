package com.example.projet_android.recycler_view;

import com.example.projet_android.Models.Character.Character;
import com.example.projet_android.Models.Character.CharacterRootObject;
import com.example.projet_android.Models.Character.Voice_actor;
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
                String voice_actor ="";
                String voice_actor_url="";
                String en_voice_actor="";
                for(Voice_actor v : c.getVoice_actors()){
                    if("Japanese".equals(v.getLanguage())){
                        voice_actor = v.getName();
                        voice_actor_url = v.getImage_url();
                    }
                    if("English".equals(v.getLanguage())){
                        en_voice_actor = v.getName();
                    }
                }
                if(voice_actor!=""){
                    CharacterViewModel a = new CharacterViewModel(c.getName(),c.getRole(),voice_actor,c.getImage_url(),voice_actor_url,c.getMal_id(),en_voice_actor);
                    charViewModelList.add(a);
                }

        }
        return charViewModelList;
    }


}
