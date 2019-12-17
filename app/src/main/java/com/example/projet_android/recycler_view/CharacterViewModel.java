package com.example.projet_android.recycler_view;

public class CharacterViewModel {

        private String name;
        private String role;
        private String imageUrl;
        private int mal_id;
        private String voice_actor;
        private String en_voice_actor;
        private String voice_actor_imageUrl;

        public CharacterViewModel(String name, String role, String voice_actor, String imageUrl, String voice_actor_imageUrl, int mal_id,String en_voice_actor){
            this.name = name;
            this.role = role;
            this.imageUrl = imageUrl;
            this.voice_actor = voice_actor;
            this.mal_id = mal_id;
            this.voice_actor_imageUrl = voice_actor_imageUrl;
            this.en_voice_actor = en_voice_actor;
        }

    public String getEn_voice_actor() {
        return en_voice_actor;
    }

    public void setEn_voice_actor(String en_voice_actor) {
        this.en_voice_actor = en_voice_actor;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMal_id() {
        return mal_id;
    }

    public void setMal_id(int mal_id) {
        this.mal_id = mal_id;
    }

    public String getVoice_actor() {
        return voice_actor;
    }

    public void setVoice_actor(String voice_actor) {
        this.voice_actor = voice_actor;
    }

    public String getVoice_actor_imageUrl() {
        return voice_actor_imageUrl;
    }

    public void setVoice_actor_imageUrl(String voice_actor_imageUrl) {
        this.voice_actor_imageUrl = voice_actor_imageUrl;
    }
}
