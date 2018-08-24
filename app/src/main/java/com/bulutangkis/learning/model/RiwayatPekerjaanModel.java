package com.bulutangkis.learning.model;

public class RiwayatPekerjaanModel {
    String start;
    String tempat;
    String jabatan;

    public RiwayatPekerjaanModel(String start, String tempat, String jabatan) {
        this.start = start;
        this.tempat = tempat;
        this.jabatan = jabatan;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
}
