package com.bulutangkis.learning.model;

public class KuisModel {
    private String Soal;
    private String pil_a;
    private String pil_b;
    private String pil_c;
    private String pil_d;
    private int jawaban;

    public String getSoal() {
        return Soal;
    }

    public void setSoal(String soal) {
        Soal = soal;
    }

    public String getPil_a() {
        return pil_a;
    }

    public void setPil_a(String pil_a) {
        this.pil_a = pil_a;
    }

    public String getPil_b() {
        return pil_b;
    }

    public void setPil_b(String pil_b) {
        this.pil_b = pil_b;
    }

    public String getPil_c() {
        return pil_c;
    }

    public void setPil_c(String pil_c) {
        this.pil_c = pil_c;
    }

    public String getPil_d() {
        return pil_d;
    }

    public void setPil_d(String pil_d) {
        this.pil_d = pil_d;
    }

    public int getJawaban() {
        return jawaban;
    }

    public void setJawaban(int jawaban) {
        this.jawaban = jawaban;
    }
}
