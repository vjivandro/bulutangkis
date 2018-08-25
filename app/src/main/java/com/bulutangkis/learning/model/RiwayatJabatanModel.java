package com.bulutangkis.learning.model;

public class RiwayatJabatanModel {
    String jabatan;
    String pangkat;
    String golongan;
    String tglth;

    public RiwayatJabatanModel(String jabatan, String pangkat, String golongan, String tglth) {
        this.jabatan = jabatan;
        this.pangkat = pangkat;
        this.golongan = golongan;
        this.tglth = tglth;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getPangkat() {
        return pangkat;
    }

    public void setPangkat(String pangkat) {
        this.pangkat = pangkat;
    }

    public String getGolongan() {
        return golongan;
    }

    public void setGolongan(String golongan) {
        this.golongan = golongan;
    }

    public String getTglth() {
        return tglth;
    }

    public void setTglth(String tglth) {
        this.tglth = tglth;
    }
}
