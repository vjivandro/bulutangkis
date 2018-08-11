package com.bulutangkis.learning.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bulutangkis.learning.R;
import com.bulutangkis.learning.model.KuisModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    final static String DB_NAME = "db_bulutangkis";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_kuis(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "soal TEXT, pil_a TEXT, pil_b TEXT, pil_c TEXT, pil_d TEXT, jawaban INTEGER)";
        db.execSQL(sql);

        ContentValues values = new ContentValues();

        // soal 1
        values.put("soal", "Berapa lebar garis lapangan bulutangkis?");
        values.put("pil_a", "4,50 cm.");
        values.put("pil_b", "3,50 cm.");
        values.put("pil_c", "4,00 cm.");
        values.put("pil_d", "3,00 cm.");
        values.put("jawaban","3");
        db.insert("tbl_kuis", "soal", values);

        // soal 2
        values.put("soal", "Berapa panjang lapangan bulutangkis?");
        values.put("pil_a", "13,40 m.");
        values.put("pil_b", "13,50 m.");
        values.put("pil_c", "13,00 m.");
        values.put("pil_d", "14,00 m.");
        values.put("jawaban","1");
        db.insert("tbl_kuis", "soal", values);

        // soal 3
        values.put("soal", "Berapa lebar lapangan bulutangkis untuk permainan tunggal?");
        values.put("pil_a", "6,00 m.");
        values.put("pil_b", "5,18 m.");
        values.put("pil_c", "5.50 m.");
        values.put("pil_d", "6,15 m.");
        values.put("jawaban","2");
        db.insert("tbl_kuis", "soal", values);

        // soal 4
        values.put("soal", "Berapa lebar lapangan bulutangkis untuk permainan ganda?");
        values.put("pil_a", "6,50 m.");
        values.put("pil_b", "6,10 m.");
        values.put("pil_c", "6,00 m.");
        values.put("pil_d", "6,15 m.");
        values.put("jawaban","2");
        db.insert("tbl_kuis", "soal", values);

        // soal 5
        values.put("soal", "Berapa tinggi tiang net bulutangkis?");
        values.put("pil_a", "1,50 m.");
        values.put("pil_b", "1,40 m.");
        values.put("pil_c", "1,45 m.");
        values.put("pil_d", "1,55 m.");
        values.put("jawaban","4");
        db.insert("tbl_kuis", "soal", values);

        // soal 6
        values.put("soal", "Berapa toleransi tinggi net bulutangkis bagian tengah lapangan?");
        values.put("pil_a", "1,50 m.");
        values.put("pil_b", "1,452 m.");
        values.put("pil_c", "1,524 m.");
        values.put("pil_d", "1,525 m.");
        values.put("jawaban","3");
        db.insert("tbl_kuis", "soal", values);

        // soal 7
        values.put("soal", "Berapa lebar net bulutangkis?");
        values.put("pil_a", "760 cm.");
        values.put("pil_b", "750 cm.");
        values.put("pil_c", "740 cm.");
        values.put("pil_d", "700 cm.");
        values.put("jawaban","1");
        db.insert("tbl_kuis", "soal", values);

        // soal 8
        values.put("soal", "Bagaimana cara memasang tiang net bulutangkis?");
        values.put("pil_a", "Tiang net dipasang 0,50 m dari garis samping permainan ganda.");
        values.put("pil_b", "Tiang net dipasang tegak lurus dengan garis samping untuk ganda.");
        values.put("pil_c", "Tiang net dipasang 0,20 m dari garis samping permainan ganda.");
        values.put("pil_d", "Tiang net dipasang 0,30 m dari garis samping permainan ganda.");
        values.put("jawaban","2");
        db.insert("tbl_kuis", "soal", values);

        // soal 9
        values.put("soal", "Siapa yang mengamati pelaku servis dalam pertandingan bulutangkis?");
        values.put("pil_a", "Referee");
        values.put("pil_b", "Wasit 2");
        values.put("pil_c", "Umpire");
        values.put("pil_d", "Service judge");
        values.put("jawaban","4");
        db.insert("tbl_kuis", "soal", values);

        // soal 10
        values.put("soal", "Siapa yang mengamati penerima servis dalam permain bulutangkis?");
        values.put("pil_a", "Referee");
        values.put("pil_b", "Wasit 2");
        values.put("pil_c", "Umpire");
        values.put("pil_d", "Service judge");
        values.put("jawaban","3");
        db.insert("tbl_kuis", "soal", values);


        // soal 11
        values.put("soal", "Saat melakukan servis, pelaku servis dinyatakan salah (fault), kecuali ");
        values.put("pil_a", "saat memukul shuttle cock, kaki yang berada di depan tidak menginjak permukaan lapangan.");
        values.put("pil_b", "saat memukul shuttle cock, salah satu kaki berada pada permukaan lapangan.");
        values.put("pil_c", "saat memukul shuttle cock, kedua kaki tidak berada pada permukaan lapangan.");
        values.put("pil_d", "saat memukul shuttle cock, kedua kaki berada pada permukaan lapangan.");
        values.put("jawaban","4");
        db.insert("tbl_kuis", "soal", values);

        // soal 12
        values.put("soal", "Saat melakukan servis, pelaku servis dinyatakan salah (fault), kecuali ");
        values.put("pil_a", "pada saat memukul shuttle cock, batang raket mengarah ke bawah sedemikian rupa.");
        values.put("pil_b", "pada saat memukul shuttle cock, batang raket tidak mengarah ke bawah sedemikian rupa.");
        values.put("pil_c", "pada saat memukul shuttle cock, tangan memegang raket lebih rendah dari shuttle cock yang sedang dipukul.");
        values.put("pil_d", "pada saat memukul shuttle cock, batang raket tidak mengarah ke samping sedemikian rupa.");
        values.put("jawaban","1");
        db.insert("tbl_kuis", "soal", values);

        // soal 13
        values.put("soal", "Saat melakukan servis, pelaku servis dinyatakan benar jika");
        values.put("pil_a", "Pada saat memukul servis, shuttle cock dipukul bagian bulu, asal masuk lapangan lawan.");
        values.put("pil_b", "Pada saat memukul servis, shuttle cock boleh dipukul di bagian mana saja, asal masuk lapangan lawan.");
        values.put("pil_c", "Pada saat memukul servis, shuttle cock dipukul bagian bulu dan gabus bersama-sama.");
        values.put("pil_d", "Pada saat memukul servis, shuttle cock dipukul pada bagian gabus.");
        values.put("jawaban","4");
        db.insert("tbl_kuis", "soal", values);

        // soal 14
        values.put("soal", "Dimana letak shuttle cock di pukul oleh raket pelaku servis saat melakukan pukulan servis?");
        values.put("pil_a", "Pada saat memukul servis, keseluruhan shuttle cock harus berada di bawah pinggang pelaku servis.");
        values.put("pil_b", "Pada saat memukul servis, shuttle cock boleh dipukul di mana saja, asal masuk lapangan lawan.");
        values.put("pil_c", "Pada saat memukul servis, shuttle cock dipukul di samping dan sejajar pinggang pelaku servis.");
        values.put("pil_d", "Pada saat memukul servis, shuttle cock boleh dipukul lebih tinggi dari pinggang pelaku servis.");
        values.put("jawaban","1");
        db.insert("tbl_kuis", "soal", values);

        // soal 15
        values.put("soal", "Bagaimana seharusnya gerakan ayunan raket pelaku servis saat melakukan servis?");
        values.put("pil_a", "Untuk menipu lawan, gerakan ayunan raket pelaku servis boleh dilakukan terputus-putus ke depan maupun ke belakang.");
        values.put("pil_b", "Gerakan ayunan raket pelaku servis harus diawali gerakan ke belakang dilanjutkan ke depan berulang-ulang untuk menipu lawan.");
        values.put("pil_c", "Gerakan ayunan raket pelaku servis dinyatakan salah (fault), karena  gerakannya berkesinambungan ke depan setelah awalan servis.");
        values.put("pil_d", "Gerakan ayunan raket pelaku servis harus berkesinambungan ke depan setelah awalan servis.");
        values.put("jawaban","4");
        db.insert("tbl_kuis", "soal", values);

        // soal 16
        values.put("soal", "Bagaimana ketentuannya saat pelaku servis melakukan servis ke arah lapangan lawan?");
        values.put("pil_a", "Jika shuttle cock luput dipukul, maka servis harus diulang.");
        values.put("pil_b", "Jika shuttle cock luput dipukul, maka servis dianggap telah dilakukan.");
        values.put("pil_c", "Shuttle cock yang luput dipukul, maka servis dinyatakan benar jika tidak disengaja.");
        values.put("pil_d", "Jika disengaja shuttle cock luput dipukul, maka servis dinyatakan benar.");
        values.put("jawaban","2");
        db.insert("tbl_kuis", "soal", values);

        // soal 17
        values.put("soal", "Yang dilakukan penerima servis berikut ini tidak dianggap pelanggaran.");
        values.put("pil_a", "Bergerak lebih dahulu sebelum shuttle cock dipukul oleh pelaku servis, karena ingin segera memukul untuk mengembalikan servis.");
        values.put("pil_b", "Kaki depan penerima servis berada di permukaan lapangan dalam posisi tidak bergerak saat servis mulai dilakukan sampai servis telah dilakukan.");
        values.put("pil_c", "Penerima servis harus bergerak cepat untuk segera mematikan permainan lawan sebelum perkenaan shuttle cock dengan raket pelaku servis.");
        values.put("pil_d", "Penerima servis boleh menolak mengembalikan servis karena belum siap, dengan memberi sinyal mengangkat tangan kepada umpire.");
        values.put("jawaban", "4");
        db.insert("tbl_kuis", "soal", values);

        // soal 18
        values.put("soal", "Apa yang umpire putuskan jika pelaku servis dan penerima servis melakukan kesalahan bersamaan?");
        values.put("pil_a", "Permainan tetap dilanjutkan sampai terjadi kesalahan.");
        values.put("pil_b", "Karena bersamaan melakukan kesalahan bersamaan maka dianggap tidak terjadi kesalahan.");
        values.put("pil_c", "Umpire menyatakan “fault” kepada kedua pemain, selanjutnya menyatakan “let” dan servis diulang.");
        values.put("pil_d", "Dilakukan undian (drawing) untuk menentukan siapa yang harus melakukan servis berikutnya.");
        values.put("jawaban", "3");
        db.insert("tbl_kuis", "soal", values);

        // soal 19
        values.put("soal", "Apa keputusan umpire jika pemain A melakukan servis ke lapangan B, \n shuttle cock menyentuh bagian atas net dan selanjutnya shuttle cock jatuh masuk ke lapangan B?");
        values.put("pil_a", "Servis dianggap salah dan harus diulang.");
        values.put("pil_b", "Servis pemain A dianggap salah, servis pindah untuk pemain B.");
        values.put("pil_c", "Pemain A tidak boleh melakukan servis lagi.");
        values.put("pil_d", "Angka bertambah untuk pemain A.");
        values.put("jawaban", "4");
        db.insert("tbl_kuis", "soal", values);

        // soal 20
        values.put("soal", "Apa keputusan umpire jika pemain A melakukan servis, shuttle cock  menyentuh atap lapangan dan masuk ke lapangan B?");
        values.put("pil_a", "Servis dianggap salah dan harus diulang.");
        values.put("pil_b", "Servis pemain A dianggap salah, angka bertambah untuk pemain B.");
        values.put("pil_c", "Pemain A tidak boleh melakukan servis lagi.");
        values.put("pil_d", "Angka bertambah untuk pemain A.");
        values.put("jawaban", "2");
        db.insert("tbl_kuis", "soal", values);

        // soal 21
        values.put("soal", "Dalam permainan ganda, pelaku servis salah tempat atau salah giliran melakukan servis, maka");
        values.put("pil_a", "kesalahan harus diperbaiki, dan angka tetap dilanjutkan.");
        values.put("pil_b", "kesalahan tidak harus diperbaiki, dan angka tetap dilanjutkan.");
        values.put("pil_c", "servis dianggap gagal, dan harus diulang.");
        values.put("pil_d", "pemain yang melakukan kesalahan harus dihukum.");
        values.put("jawaban", "1");
        db.insert("tbl_kuis", "soal", values);

        // soal 22
        values.put("soal", "Pihak yang terlebih dahulu memperoleh angka 21 akan memenangkan pertandingan...");
        values.put("pil_a", "satu set.");
        values.put("pil_b", "setengah game.");
        values.put("pil_c", "setengah set.");
        values.put("pil_d", "satu pertandingan.");
        values.put("jawaban", "1");
        db.insert("tbl_kuis", "soal", values);

        // soal 23
        values.put("soal", "Dalam satu partai partandingan bulutangkis, terdiri dari “best of the three games”. Artinya ");
        values.put("pil_a", "Pemain sudah memenangkan 3 game dinyatakan menang.");
        values.put("pil_b", "Pemain sudah memenangkan 3 game paling baik.");
        values.put("pil_c", "Pemain sudah memenangkan 2 game dinyatakan menang.");
        values.put("pil_d", "Pemain sudah menang dengan baik pada game ke 3 dinyatakan menang.");
        values.put("jawaban", "3");
        db.insert("tbl_kuis", "soal", values);

        // soal 24
        values.put("soal", "Istilah yang digunakan bila terjadi angka 20-20 adalah");
        values.put("pil_a", "setting.");
        values.put("pil_b", "douce.");
        values.put("pil_c", "just.");
        values.put("pil_d", "yus.");
        values.put("jawaban", "1");
        db.insert("tbl_kuis", "soal", values);

        // soal 25
        values.put("soal", "Bagaimana untuk menentukan kemenangan jika terjadi angka 20-20?");
        values.put("pil_a", "Pihak yang memperoleh angka 21 lebih dahulu dinyatakan menang.");
        values.put("pil_b", "Pihak yang memperoleh 2 angka secara berturut-turut dinyatakan menang.");
        values.put("pil_c", "Pihak yang memperoleh angka 25 lebih dahulu dinyatakan menang.");
        values.put("pil_d", "Pihak yang memperoleh angka selisih 3 dari lawan dinyatakan menang.");
        values.put("jawaban", "2");
        db.insert("tbl_kuis", "soal", values);

        // soal 26
        values.put("soal", "Berapa angka maksimal agar pemain dinyatakan menang dalam game tersebut setelah terjadi angka 20-20?");
        values.put("pil_a", "angka 21.");
        values.put("pil_b", "angka 22.");
        values.put("pil_c", "angka 25.");
        values.put("pil_d", "angka 30.");
        values.put("jawaban", "4");
        db.insert("tbl_kuis", "soal", values);

        // soal 27
        values.put("soal", "Bilamana “game point” diucapkan umpire?");
        values.put("pil_a", "Ketika satu pihak pemain telah mencapai angka 20 pada setiap game.");
        values.put("pil_b", "Ketika satu pihak pemain telah mencapai angka 20 pada setiap game, dan ada game berikutnya yang harus dimainkan.");
        values.put("pil_c", "Ketika satu pihak pemain telah mencapai angka 20 pada setiap game, dan tidak ada game berikutnya yang harus dimainkan.");
        values.put("pil_d", "Ketika satu pihak pemain telah mencapai angka 21 pada setiap game.");
        values.put("jawaban", "2");
        db.insert("tbl_kuis", "soal", values);

        // soal 28
        values.put("soal", "Kapan umpire mengucapkan “match point” pada kedudukan skor game tertentu?");
        values.put("pil_a", "Ketika satu pihak pemain mencapai angka 20 pada game ketiga.");
        values.put("pil_b", "Ketika satu pihak pemain mencapai angka 20 pada setiap game.");
        values.put("pil_c", "Ketika satu pihak pemain telah mencapai angka 20 pada setiap game, dan ada game berikutnya yang harus dimainkan.");
        values.put("pil_d", "Ketika dua pihak pemain telah mencapai angka 20-20 pada setiap game.");
        values.put("jawaban", "1");
        db.insert("tbl_kuis", "soal", values);

        // soal 29
        values.put("soal", "Sebelum permainan dimulai, umpire harus melakukan undian (toss), ketentuannya sebagai berikut.\n Apa pertanyaan yang diajukan adalah pertama kali oleh umpire?");
        values.put("pil_a", "Pihak yang menang undian boleh memilih tempat atau melakukan servis dahulu.");
        values.put("pil_b", "Pihak yang menang undian boleh memilih servis atau menerima servis lebih dahulu.");
        values.put("pil_c", "Pihak yang kalah undian hanya boleh memilih tempat.");
        values.put("pil_d", "Pihak yang menang maupun yang kalah undian punya hak yang sama untuk memilih servis dahulu.");
        values.put("jawaban", "2");
        db.insert("tbl_kuis", "soal", values);

        // soal 30
        values.put("soal", "Bila permainan terjadi game 1 – 1, apa istilah game yang ke tiga?");
        values.put("pil_a", "The best of the three game.");
        values.put("pil_b", "Two winning set.");
        values.put("pil_c", "The best of the two game.");
        values.put("pil_d", "Rubber game.");
        values.put("jawaban", "4");
        db.insert("tbl_kuis", "soal", values);

        // soal 31
        values.put("soal", "Pada angka berapa terjadi perpindahan tempat pada game ke 3?");
        values.put("pil_a", "Angka 10 untuk pertandingan putri.");
        values.put("pil_b", "Angka 11.");
        values.put("pil_c", "Angka 15 untuk pertandingan putra.");
        values.put("pil_d", "Angka 12.");
        values.put("jawaban", "2");
        db.insert("tbl_kuis", "soal", values);

        // soal 32
        values.put("soal", "Umpire akan mengucapkan  kata “let” (ulang), kecuali");
        values.put("pil_a", "jika dalam permainan, shuttle cock rusak setelah dipukul dan gabus secara  total terpisah dari sisa shuttle cock.");
        values.put("pil_b", "pelaku servis melakukan servis sebelum penerima servis siap.");
        values.put("pil_c", "saat salah satu pemain minta pergantian shuttle cock yang rusak.");
        values.put("pil_d", "jika hakim garis tidak melihat atau ragu-ragu terhadap jatuhnya shuttle cock di dekat garis, dan umpire tidak bisa mengambil keputusan.");
        values.put("jawaban", "3");
        db.insert("tbl_kuis", "soal", values);

        // soal 33
        values.put("soal", "Jikalau dalam suatu kejadian dalam pertandingan bulutangkis umpire mengucapkan  kata “let” (ulang) terjadi, maka");
        values.put("pil_a", "permainan sejak servis terakhir angka tidak dihitung, pemain mengulang melakukan servis kembali.");
        values.put("pil_b", "permainan sejak servis terakhir angka tetap dihitung, pemain mengulang melakukan servis kembali.");
        values.put("pil_c", "permainan sejak servis terakhir boleh dihitung atau tidak dihitung, terserah keputusan umpire.");
        values.put("pil_d", "Angka yang diperoleh sebelumnya dianggap syah.");
        values.put("jawaban", "1");
        db.insert("tbl_kuis", "soal", values);

        // soal 34
        values.put("soal", "Apa keputusan umpire jika saat permainan di daerah net, seorang pemain tidak sengaja menyentuh net saat memukul shuttle cock?");
        values.put("pil_a", "Permainan dilanjutkan, karena tidak disengaja menyentuh net.");
        values.put("pil_b", "Umpire berteriak “fault”, pemain tersebut dianggap salah.");
        values.put("pil_c", "Umpire diam saja, permainan dilanjutkan.");
        values.put("pil_d", "Permainan dihentikan, jika sengaja menyentuh net, jika tidak sengaja permainan dilanjutkan. ");
        values.put("jawaban", "2");
        db.insert("tbl_kuis", "soal", values);

        // soal 35
        values.put("soal", "Pada saat terjadi permainan di daerah net, seorang pemain menyentuh tiang net dengan raketnya ketika usahanya memukul shuttle cock ke arah lawan. Apa keputusan umpire?");
        values.put("pil_a", "Permainan dilanjutkan, karena bukan kesalahan.");
        values.put("pil_b", "Umpire diam saja, karena tidak ada masalah.");
        values.put("pil_c", "Permainan dilanjutkan, tiang net bukan bagian dari net.");
        values.put("pil_d", "Umpire berteriak “fault”, pemain tersebut dianggap salah.");
        values.put("jawaban", "4");
        db.insert("tbl_kuis", "soal", values);

        // soal 36
        values.put("soal", "Apa yang dimaksud cara penghitungan sistem (scoring system) rally point dalam permainan bulutangkis?");
        values.put("pil_a", "Pihak yang menang satu pertandingan mendapat tambahan satu angka.");
        values.put("pil_b", "Pemain yang memenangkan suatu angka dalam permainan.");
        values.put("pil_c", "Pihak yang memenangkan suatu reli mendapat tambahan satu angka pada skornya.");
        values.put("pil_d", "Angka yang diperoleh seorang pemain setelah pemain lawan tidak bisa bermain lagi.");
        values.put("jawaban", "3");
        db.insert("tbl_kuis", "soal", values);

        // soal 37
        values.put("soal", "Dalam permainan ganda, pasangan A-B melawan pasangan C-D. Pemain A melakukan servis ke arah pemain C yang letaknya diagonal di lapangan seberang.\n Servis tersebut dipukul oleh pemain D dan masuk lapangan A-B? Apa keputusan umpire?");
        values.put("pil_a", "Servis harus diulang, karena yang mengembalikan servis adalah pemain D yang seharusnya pemain C.");
        values.put("pil_b", "Pasangan A-B mendapat angka tambahan.");
        values.put("pil_c", "Servis pemain A dianggap salah, karena servis dipukul kembali oleh pemain D, seharusnya pemain C. ");
        values.put("pil_d", "Pukulan D dianggap syah, dan permainan dilanjutkan.");
        values.put("jawaban", "2");
        db.insert("tbl_kuis", "soal", values);

        // soal 38
        values.put("soal", "Apa keputusan umpire, jika dalam permainan, pemain A melakukan pukulan lob melambung dan shuttle cock masuk lapangan pemain B, tetapi pukulannya menyentuh atap/plafon lapangan lebih dahulu?");
        values.put("pil_a", "Servis harus diulang, karena pemain A tidak sengaja.");
        values.put("pil_b", "Pukulan pemain A dianggap salah, dan servis harus diulang.");
        values.put("pil_c", "Pemain B mendapat angka tambahan.");
        values.put("pil_d", "Pukulan A dianggap syah, dan permainan dilanjutkan.");
        values.put("jawaban", "3");
        db.insert("tbl_kuis", "soal", values);

        // soal 39
        values.put("soal", "Apa keputusan umpire jika pada saat pukulan di atas net, perkenaan shuttle cock dengan raket terjadi di sisi lapangan pemukul,\n tetapi gerakan lanjutan raket lewat atas net dan shuttle cock masuk ke lapangan lawan?");
        values.put("pil_a", "Pukulan dianggap syah, dan permainan dilanjutkan.");
        values.put("pil_b", "Pukulan dianggap tidak syah, karena gerakan lanjutan raket lewat atas net.");
        values.put("pil_c", "Pukulan dianggap syah, meskipun shuttle cock dipukul di daerah lawan.");
        values.put("pil_d", "Karena gerakan lanjutan saat memukul raket lewat atas net, maka pukulan dianggap salah.");
        values.put("jawaban", "1");
        db.insert("tbl_kuis", "soal", values);

        // soal 40
        values.put("soal", "Apa keputusan umpire jika dalam permainan ganda, pemain A melakukan pukulan dan masuk ke lapangan lawan, tetapi sebelumnya shuttle cock menyentuh raket pasangannya lebih dahulu?");
        values.put("pil_a", "Pukulan dianggap syah, yang penting shuttle cock dapat dipukul.");
        values.put("pil_b", "Pukulan dianggap syah, dan permainan dilanjutkan.");
        values.put("pil_c", "Pukulan dianggap tidak syah, tetapi kalau shuttle cock masuk di daerah lawan dianggap syah.");
        values.put("pil_d", "Pukulan dianggap tidak syah, meskipun shuttle cock masuk di daerah lawan.");
        values.put("jawaban", "4");
        db.insert("tbl_kuis", "soal", values);

        // soal 41
        values.put("soal", "Apa keputusan umpire jika dalam permainan, pemain A melakukan pukulan tetapi salah satu kakinya masuk ke lapangan lawan?");
        values.put("pil_a", "Pukulan dianggap syah, jika tidak mengganggu pemain lawan.");
        values.put("pil_b", "Pukulan dianggap syah, dan permainan dilanjutkan.");
        values.put("pil_c", "Pukulan dianggap tidak syah.");
        values.put("pil_d", "Pukulan dianggap syah, meskipun mengganggu pemain lawan.");
        values.put("jawaban", "3");
        db.insert("tbl_kuis", "soal", values);

        // soal 42
        values.put("soal", "Hakim garis harus menunjukkan apakah shuttle cock mendarat di dalam atau di luar garis lapangan yang menjadi tugasnya.");
        values.put("pil_a", "Dalam suatu kasus hakim garis salah saat melakukan pengamatan, umpire dapat melakukan perbaikan (overrule) terhadap keputusan hakim garis.");
        values.put("pil_b", "Hakim garis memutuskan shuttle cock masuk atau keluar, meskipun keputusannya salah.");
        values.put("pil_c", "Hakim garis punya hak mutlak untuk memutuskan shuttle cock masuk atau keluar tanpa kecuali.");
        values.put("pil_d", "Jikalau shuttle cock yang jatuh di dekat garis, keputusan hakim garis adalah paling benar tidak boleh diintervensi pihak lain.");
        values.put("jawaban", "1");
        db.insert("tbl_kuis", "soal", values);

        // soal 43
        values.put("soal", "Hakim garis bertanggungjawab sepenuhnya untuk garis yang menjadi tugasnya. Maka dalam melaksanakan tugasnya hakim garis perlu memahami secara benar ketentuan-ketentuan, salah satunya sebagai berikut.");
        values.put("pil_a", "Hakim garis boleh memberikan signal meskipun shuttle cock belum menjentuh lantai, kecuali kalau sudah pasti mengetahui jatuhnya shuttle cock di lantai.");
        values.put("pil_b", "Bila tidak melihat dengan pasti, memberitahu segera kepada wasit dengan cara meletakkan kedua tangan menutupi mata.");
        values.put("pil_c", "Dalam suatu kasus kesalahan hakim garis dalam melakukan pengamatan, hakim garis minta maaf sambil mengangkat kedua tangan.");
        values.put("pil_d", "Jikalau shuttle cock yang jatuh di dekat garis, keputusan hakim garis adalah mutlak tidak boleh diintervensi pihak lain.");
        values.put("jawaban", "2");
        db.insert("tbl_kuis", "soal", values);

        // soal 44
        values.put("soal", "Hakim servis bertanggungjawab untuk memutuskan bahwa pelaku servis secara benar dalam melakukan servis.");
        values.put("pil_a", "Hakim servis punya hak mutlak dalam membuat keputusan berdasar pada pengalamannya.");
        values.put("pil_b", "Hakim servis memutuskan servis yang dilakukan pelaku servis benar berdasarkan petunjuk referee.");
        values.put("pil_c", "Dalam melakukan pengamatan, hakim servis dapat berkonsultasi lebih dahulu kepada umpire sebelum menentukan pelanggaran.");
        values.put("pil_d", "Dalam melaksanakan tugasnya hakim servis harus mengucapkan “fault” dan menggunakan signal tangan yang telah diakui untuk mengidikasikan jenis pelanggaran.");
        values.put("jawaban", "4");
        db.insert("tbl_kuis", "soal", values);

        // soal 45
        values.put("soal", "Yang dilakukan pelaku servis berikut ini adalah merupakan pelanggaran dalam melakukan servis.");
        values.put("pil_a", "Keseluruhan kepala raket secara jelas berada di bawah tangan pelaku servis yang memegang raket.");
        values.put("pil_b", "Perkenaan shuttle cock dengan raket, ada di bawah pinggang pelaku servis.");
        values.put("pil_c", "Saat melakukan servis, salah satu kaki bergeser dan sedikit diangkat untuk menghasilkan pukulan yang kuat.");
        values.put("pil_d", "Gerakan raket pelaku servis harus berkesinambungan ke depan setelah awalan servis sampai servis telah dilakukan.");
        values.put("jawaban", "3");
        db.insert("tbl_kuis", "soal", values);

        // soal 46
        values.put("soal", "Cara menguji shuttle cock dianggap standar, shuttle cock dipukul menggunakan pukulan dari bawah secara penuh dari garis belakang ke lapangan seberang.\n Shuttle cock harus dipukul secara paralel terhadap garis samping. Dan shuttle cock harus jatuh ...");
        values.put("pil_a", "tidak kurang dari 50 mm dan tidak lebih dari 90 mm dari garis belakang.");
        values.put("pil_b", "tidak kurang dari 55 cm dan tidak lebih dari 95 mm dari garis belakang.");
        values.put("pil_c", "tidak kurang dari 530 mm dan tidak lebih dari 990 mm dari garis belakang.");
        values.put("pil_d", "di antara garis belakang (back boundardy line) dan garis betas belakang servis untuk permainan ganda.");
        values.put("jawaban", "3");
        db.insert("tbl_kuis", "soal", values);

        // soal 47
        values.put("soal", "Teknik langkah kaki (foot work) yang benar harus dilakukan seperti berikut ini.");
        values.put("pil_a", "Jikalau akan melakukan pukulan backhand di daerah lapangan sudut kiri belakang (dekat garis belakang), langkah terakhir harus kaki kiri.");
        values.put("pil_b", "Apapun jenis teknik langkah kakinya, langkah terakhir harus kaki kanan (bagi pemain tidak kidal).");
        values.put("pil_c", "Jikalau akan melakukan pukulan forehand di daerah lapangan sudut kiri depan (dekat net), langkah terakhir harus kaki kiri.");
        values.put("pil_d", "Apapun jenis teknik langkah kakinya, langkah terakhir harus kaki kiri (bagi pemain tidak kidal).");
        values.put("jawaban", "2");
        db.insert("tbl_kuis", "soal", values);

        // soal 48
        values.put("soal", "Teknik pukulan forehand overhead lob yang benar harus dilakukan seperti berikut ini.");
        values.put("pil_a", "Saat perkenaan raket dengan shuttle cock, lengan pemukul harus lurus.");
        values.put("pil_b", "Bagi pemain kidal, posisi kaki kanan lebih di belakang daripada kaki kiri, dan saat memukul lengan harus lurus.");
        values.put("pil_c", "Bagi pemain tidak kidal, posisi kaki kanan lebih di depan daripada kaki kiri, dan saat memukul lengan harus lurus.");
        values.put("pil_d", "Posisi kaki kiri atau kaki kanan dimanapun tergantung pada kebiasaan pemain.");
        values.put("jawaban", "1");
        db.insert("tbl_kuis", "soal", values);

        // soal 49
        values.put("soal", "Teknik pukulan dropshot yang benar harus dilakukan seperti berikut ini.");
        values.put("pil_a", "Shuttle cock melayang setipis mungkin di atas net dan jatuh di bagian depan lapangan lawan sedekat mungkin dengan net.");
        values.put("pil_b", "Shuttle cock melambung tinggi di atas net dan jatuh di bagian depan lapangan lawan.");
        values.put("pil_c", "Shuttle cock melambung datar dan jatuh di bagian depan lapangan lawan sedekat mungkin dengan net.");
        values.put("pil_d", "Yang penting, shuttle cock jatuh di bagian depan lapangan lawan sedekat mungkin dengan net, tinggi lambungan di atas net bukan menjadi masalah.");
        values.put("jawaban", "1");
        db.insert("tbl_kuis", "soal", values);

        // soal 50
        values.put("soal", "Posisi dua pemain dalam melakukan taktik dalam permainan ganda berikut ini tidak disarankan.");
        values.put("pil_a", "Posisi dua pemain berdampingan digunakan saat menyerang.");
        values.put("pil_b", "Posisi dua pemain depan belakang digunakan saat bertahan");
        values.put("pil_c", "Posisi dua pemain berdampingan maupun depan belakang digunakan secara bergantian untuk menyerang lawan.");
        values.put("pil_d", "Posisi dua pemain berdampingan untuk bertahan, sedangkan depan belakang untuk menyerang lawan.");
        values.put("jawaban", "3");
        db.insert("tbl_kuis", "soal", values);

    }

    public List<KuisModel> getKuis(){
        List<KuisModel> listTestParser = new ArrayList<KuisModel>();
        String query = "select * from tbl_kuis";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                KuisModel kuisModel = new KuisModel();
                kuisModel.setSoal(cursor.getString(1));
                kuisModel.setPil_a(cursor.getString(2));
                kuisModel.setPil_b(cursor.getString(3));
                kuisModel.setPil_c(cursor.getString(4));
                kuisModel.setPil_d(cursor.getString(5));
                kuisModel.setJawaban(cursor.getInt(6));
                listTestParser.add(kuisModel);
            }while(cursor.moveToNext());
        }

        return listTestParser;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_kuis");
        onCreate(db);
    }
}
