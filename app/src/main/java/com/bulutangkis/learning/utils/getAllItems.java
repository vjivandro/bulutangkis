package com.bulutangkis.learning.utils;

import com.bulutangkis.learning.R;
import com.bulutangkis.learning.model.PendidikanModel;
import com.bulutangkis.learning.model.ProfilModel;
import com.bulutangkis.learning.model.RiwayatJabatanModel;
import com.bulutangkis.learning.model.RiwayatPekerjaanModel;

import java.util.ArrayList;
import java.util.List;

public class getAllItems {

    // profile
    public static List<ProfilModel> getProfileItemList() {
        List<ProfilModel> allItems = new ArrayList<ProfilModel>();
//        allItems.add(new ProfilModel(R.drawable.ic_phone, "0341 - 460975"));
//        allItems.add(new ProfilModel(R.drawable.ic_accessibility, "Laki -Laki"));
//        allItems.add(new ProfilModel(R.drawable.ic_portrait, "130809383"));
//        allItems.add(new ProfilModel(R.drawable.ic_work, "Fakultas Ilmu Pendidikan"));
//        allItems.add(new ProfilModel(R.drawable.ic_account_balance, "Universitas Negeri Malang"));
//        allItems.add(new ProfilModel(R.drawable.ic_assignment_ind, "Dosen FIP"));
//        allItems.add(new ProfilModel(R.drawable.ic_event_seat, "Lektor Kepala"));

        allItems.add(new ProfilModel(R.drawable.ic_account_circle, "Identitas"));
        allItems.add(new ProfilModel(R.drawable.ic_account_balance, "Pendidikan"));
        allItems.add(new ProfilModel(R.drawable.ic_work, "Riwayat Pekerjaan"));
        allItems.add(new ProfilModel(R.drawable.ic_timeline, " Riwayat Jabatan, Pangkat, Golongan"));
        allItems.add(new ProfilModel(R.drawable.ic_branding_watermark, "Sertifikat"));
        allItems.add(new ProfilModel(R.drawable.ic_language, "Fakultas Ilmu Pendidikan"));
        allItems.add(new ProfilModel(R.drawable.ic_language_green, "Universitas Negeri Malang"));
        allItems.add(new ProfilModel(R.drawable.ic_android, "Mobile Developer"));

        return allItems;
    }

    // identitas
    public static List<ProfilModel> getIdentitasItemList() {
        List<ProfilModel> allItems = new ArrayList<ProfilModel>();
        allItems.add(new ProfilModel(R.drawable.ic_phone, "0341 - 460975"));
        allItems.add(new ProfilModel(R.drawable.ic_accessibility, "Laki -Laki"));
        allItems.add(new ProfilModel(R.drawable.ic_portrait, "130809383"));
        allItems.add(new ProfilModel(R.drawable.ic_work, "Fakultas Ilmu Pendidikan"));
        allItems.add(new ProfilModel(R.drawable.ic_account_balance, "Universitas Negeri Malang"));
        allItems.add(new ProfilModel(R.drawable.ic_assignment_ind, "Dosen FIP"));
        allItems.add(new ProfilModel(R.drawable.ic_event_seat, "Lektor Kepala"));

        return allItems;
    }

    // pendidikan
    public static List<PendidikanModel> getPendidikanList() {
        List<PendidikanModel> allItems = new ArrayList<PendidikanModel>();
        allItems.add(new PendidikanModel("Sekolah Dasar", "SDN Purworejo I, Kec. Pakem, Kab. Sleman, Daerah Istimewa Yogyakarta", "1959 –1965","SD"));
        allItems.add(new PendidikanModel("SLTP", "SMP IKIP II Yogyakarta", "1965–1968","SMP"));
        allItems.add(new PendidikanModel("SLTA", "SMA IKIP II Yogyakarta", "1968–1971","SMA"));
        allItems.add(new PendidikanModel("Sarjana Muda", "Sekolah Tinggi Olahraga Yogyakarta", "1972–1975","Sarjana Muda"));
        allItems.add(new PendidikanModel("Sarjana", "Fakultas Pendidikan Ilmu Keolah-ragaan  IKIP Yogyakarta (Universitas Negeri Yogyakarta)", "1976–1979","Sarjana Pendidikan Olahraga Prestasi"));
        allItems.add(new PendidikanModel("Magister", "Program Studi Ilmu Kesehatan Olahraga Universitas Airlangga Surabaya", "1997–2000","Magister Kesehatan"));

        return allItems;
    }

    // riwayat pekerjaan
    public static List<RiwayatPekerjaanModel> getRiwayatList() {
        List<RiwayatPekerjaanModel> allitems = new ArrayList<RiwayatPekerjaanModel>();
        allitems.add(new RiwayatPekerjaanModel("1980 - Sampai sekarang","Fakultas Ilmu Pendidikan Universitas Negeri Malang","Pegawai Negeri Sipil"));
        allitems.add(new RiwayatPekerjaanModel("1986-1989","Program Pendidikan Olahraga dan Kesehatan FIP IKIP Malang","Sekretaris Program   "));
        allitems.add(new RiwayatPekerjaanModel("1990-1995","Proyek P2T IKIP Malang.","Bendahara Proyek "));
        return allitems;
    }

    // riwayat jabatan
    public static List<RiwayatJabatanModel> getJabatanItem() {
        List<RiwayatJabatanModel> allitems = new ArrayList<RiwayatJabatanModel>();
        allitems.add(new RiwayatJabatanModel("Asisten Ahli Madya", "Penata Muda", "III/a", "01-02-1980"));
        allitems.add(new RiwayatJabatanModel("Asisten Ahli", "Penata Muda Tingkat I", "III/b", "01-10-1982"));
        allitems.add(new RiwayatJabatanModel("Lektor Muda", "Penata", "III/c", "01-10-1984"));
        allitems.add(new RiwayatJabatanModel("Lektor Madya", "Penata Tingkat I", "III/d", "01-10-1986"));
        allitems.add(new RiwayatJabatanModel("Lektor", "Pembina", "IV/a", "01-04-1990"));
        allitems.add(new RiwayatJabatanModel("Lektor Kepala Madya", "Pembina Tingkat I", "IV/b", "01-10-1995"));
        allitems.add(new RiwayatJabatanModel("Lektor Kepala", "Pembina Utama Muda", "IV/c", "01-10-2002"));
        return allitems;
    }
}
