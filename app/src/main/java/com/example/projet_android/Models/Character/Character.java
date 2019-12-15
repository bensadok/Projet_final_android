package com.example.projet_android.Models.Character;

import java.util.List;

public class Character
{
    private int mal_id;
    private String url;
    private String image_url;
    private String name;
    private String role;
    private List<Voice_actor> voice_actors;

    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public void setRole(String role) {
        this.role = role;
    }

    public List<Voice_actor> getVoice_actors() {
        return voice_actors;
    }

    public void setVoice_actors(List<Voice_actor> voice_actors) {
        this.voice_actors = voice_actors;
    }
}