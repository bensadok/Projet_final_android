package com.example.projet_android.Models.Character;

import java.util.List;

public class Character
{
    private int mal_id;
    private String image_url;
    private String name;
    private String role;
    private List<Voice_actor> voice_actors;

    public int getMal_id() {
        return mal_id;
    }


    public String getImage_url() {
        return image_url;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }


    public List<Voice_actor> getVoice_actors() {
        return voice_actors;
    }

    public void setVoice_actors(List<Voice_actor> voice_actors) {
        this.voice_actors = voice_actors;
    }
}