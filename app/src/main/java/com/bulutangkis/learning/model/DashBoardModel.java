package com.bulutangkis.learning.model;

public class DashBoardModel {
    public String TextLabel;
    public int Gambar;

    public DashBoardModel(String textLabel, int gambar) {
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
