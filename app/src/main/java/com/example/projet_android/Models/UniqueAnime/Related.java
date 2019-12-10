package com.example.projet_android.Models.UniqueAnime;

import java.util.List;

public class Related {
    private List<Adaptation> adaptations;
    private List<AlternativeVersion> alternativeVersions;
    private List<SideStory> sideStories;
    private List<SpinOff> spinOffs;

    public List<Adaptation> getAdaptations() {
        return adaptations;
    }

    public void setAdaptations(List<Adaptation> adaptations) {
        this.adaptations = adaptations;
    }

    public List<AlternativeVersion> getAlternativeVersions() {
        return alternativeVersions;
    }

    public void setAlternativeVersions(List<AlternativeVersion> alternativeVersions) {
        this.alternativeVersions = alternativeVersions;
    }

    public List<SideStory> getSideStories() {
        return sideStories;
    }

    public void setSideStories(List<SideStory> sideStories) {
        this.sideStories = sideStories;
    }

    public List<SpinOff> getSpinOffs() {
        return spinOffs;
    }

    public void setSpinOffs(List<SpinOff> spinOffs) {
        this.spinOffs = spinOffs;
    }
}
