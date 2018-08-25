package com.bulutangkis.learning.model;

public class SertifikatModel {
    String sertifikat;
    String lembaga;
    String pejabat;
    String tgltahun;

    public SertifikatModel(String sertifikat, String lembaga, String pejabat, String tgltahun) {
        this.sertifikat = sertifikat;
        this.lembaga = lembaga;
        this.pejabat = pejabat;
        this.tgltahun = tgltahun;
    }

    public String getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(String sertifikat) {
        this.sertifikat = sertifikat;
    }

    public String getLembaga() {
        return lembaga;
    }

    public void setLembaga(String lembaga) {
        this.lembaga = lembaga;
    }

    public String getPejabat() {
        return pejabat;
    }

    public void setPejabat(String pejabat) {
        this.pejabat = pejabat;
    }

    public String getTgltahun() {
        return tgltahun;
    }

    public void setTgltahun(String tgltahun) {
        this.tgltahun = tgltahun;
    }
}
