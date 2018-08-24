package com.bulutangkis.learning.model;

public class PendidikanModel {
    String pendidikan;
    String sekola;
    String tahun;
    String ijasah;

    public PendidikanModel(String pendidikan, String sekola, String tahun, String ijasah) {
        this.pendidikan = pendidikan;
        this.sekola = sekola;
        this.tahun = tahun;
        this.ijasah = ijasah;
    }


    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getSekola() {
        return sekola;
    }

    public void setSekola(String sekola) {
        this.sekola = sekola;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getIjasah() {
        return ijasah;
    }

    public void setIjasah(String ijasah) {
        this.ijasah = ijasah;
    }
}
