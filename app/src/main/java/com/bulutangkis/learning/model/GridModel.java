package com.bulutangkis.learning;

public class GridModel {
    public String tesxt;
    public int image;
    public String color;

    public GridModel(String tesxt, int image, String color) {
        this.tesxt = tesxt;
        this.image = image;
        this.color = color;
    }

    public String getTesxt() {
        return tesxt;
    }

    public void setTesxt(String tesxt) {
        this.tesxt = tesxt;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
