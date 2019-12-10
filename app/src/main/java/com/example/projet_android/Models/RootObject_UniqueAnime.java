package com.example.projet_android.Models;

import com.example.projet_android.Models.UniqueAnime.Aired;
import com.example.projet_android.Models.UniqueAnime.Genre;
import com.example.projet_android.Models.UniqueAnime.Licensor;
import com.example.projet_android.Models.UniqueAnime.Producer;
import com.example.projet_android.Models.UniqueAnime.Related;
import com.example.projet_android.Models.UniqueAnime.Studio;

import java.util.List;

public class RootObject_UniqueAnime {

    public String request_hash;
    public Boolean request_cached;
    public int request_cache_expiry;
    public int mal_id;
    public String url;
    public String image_url;
    public String trailer_url;
    public String title;
    public String title_english;
    public String title_japanese;
    public List<Object> title_synonyms;
    public String type;
    public String source;
    public int episodes;
    public String status;
    public Boolean airing;
    public Aired aired;
    public String duration;
    public String rating;
    public double score;
    public int scored_by;
    public int rank;
    public int popularity;
    public int members;
    public int favorites;
    public String synopsis;
    public String background;
    public String premiered;
    public String broadcast;
    public Related related;
    public List<Producer> producers;
    public List<Licensor> licensors;
    public List<Studio> studios;
    public List<Genre> genres;
    public List<String> opening_themes;
    public List<String> ending_themes;

    public String getRequest_hash() {
        return request_hash;
    }

    public void setRequest_hash(String request_hash) {
        this.request_hash = request_hash;
    }

    public Boolean getRequest_cached() {
        return request_cached;
    }

    public void setRequest_cached(Boolean request_cached) {
        this.request_cached = request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public void setRequest_cache_expiry(int request_cache_expiry) {
        this.request_cache_expiry = request_cache_expiry;
    }

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

    public String getTrailer_url() {
        return trailer_url;
    }

    public void setTrailer_url(String trailer_url) {
        this.trailer_url = trailer_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_english() {
        return title_english;
    }

    public void setTitle_english(String title_english) {
        this.title_english = title_english;
    }

    public String getTitle_japanese() {
        return title_japanese;
    }

    public void setTitle_japanese(String title_japanese) {
        this.title_japanese = title_japanese;
    }

    public List<Object> getTitle_synonyms() {
        return title_synonyms;
    }

    public void setTitle_synonyms(List<Object> title_synonyms) {
        this.title_synonyms = title_synonyms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAiring() {
        return airing;
    }

    public void setAiring(Boolean airing) {
        this.airing = airing;
    }

    public Aired getAired() {
        return aired;
    }

    public void setAired(Aired aired) {
        this.aired = aired;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getScored_by() {
        return scored_by;
    }

    public void setScored_by(int scored_by) {
        this.scored_by = scored_by;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPremiered() {
        return premiered;
    }

    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public Related getRelated() {
        return related;
    }

    public void setRelated(Related related) {
        this.related = related;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    public List<Licensor> getLicensors() {
        return licensors;
    }

    public void setLicensors(List<Licensor> licensors) {
        this.licensors = licensors;
    }

    public List<Studio> getStudios() {
        return studios;
    }

    public void setStudios(List<Studio> studios) {
        this.studios = studios;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<String> getOpening_themes() {
        return opening_themes;
    }

    public void setOpening_themes(List<String> opening_themes) {
        this.opening_themes = opening_themes;
    }

    public List<String> getEnding_themes() {
        return ending_themes;
    }

    public void setEnding_themes(List<String> ending_themes) {
        this.ending_themes = ending_themes;
    }
}
