package com.bulutangkis.learning.model;

public class ProfilModel {
    int photo;
    String value;

    public ProfilModel(int photo, String value) {
        this.photo = photo;
        this.value = value;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
