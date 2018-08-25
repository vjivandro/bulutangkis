package com.bulutangkis.learning.model;

public class VideoModel {
    int photo;
    String label;

    public VideoModel(int photo, String label) {
        this.photo = photo;
        this.label = label;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
