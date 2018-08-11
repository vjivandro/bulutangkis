package com.bulutangkis.learning.model;

public class MateriModel {
    public String judul;
    public int photo;

    public MateriModel(String judul, int photo) {
        this.judul = judul;
        this.photo = photo;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
