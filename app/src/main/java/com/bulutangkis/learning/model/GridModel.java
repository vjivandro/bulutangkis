package com.bulutangkis.learning.model;

public class GridModel {
    public String TextLabel;
    public int Gambar;

    public GridModel(String textLabel, int gambar) {
        TextLabel = textLabel;
        Gambar = gambar;
    }

    public String getTextLabel() {
        return TextLabel;
    }

    public void setTextLabel(String textLabel) {
        TextLabel = textLabel;
    }

    public int getGambar() {
        return Gambar;
    }

    public void setGambar(int gambar) {
        Gambar = gambar;
    }
}
