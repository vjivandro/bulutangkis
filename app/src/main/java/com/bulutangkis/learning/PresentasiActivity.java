package com.bulutangkis.learning;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bulutangkis.learning.materi.PeraturanBulutangkis;
import com.bulutangkis.learning.materi.PerwasitanBulutangkis;
import com.bulutangkis.learning.materi.Presentasi01;
import com.bulutangkis.learning.materi.Presentasi02;
import com.bulutangkis.learning.materi.Presentasi03;
import com.bulutangkis.learning.materi.Presentasi04;
import com.bulutangkis.learning.materi.Presentasi05;
import com.bulutangkis.learning.materi.Presentasi06;
import com.bulutangkis.learning.materi.Presentasi07;
import com.bulutangkis.learning.materi.Presentasi08;
import com.bulutangkis.learning.materi.Presentasi09;
import com.bulutangkis.learning.materi.Presentasi10;
import com.bulutangkis.learning.materi.SejarahBulutangkis;
import com.bulutangkis.learning.materi.StrategiBulutangkis;
import com.bulutangkis.learning.materi.TeknikServiceBulutangkis;
import com.bulutangkis.learning.model.MateriModel;
import com.bulutangkis.learning.model.PresentasiModel;

import java.util.List;

import static com.bulutangkis.learning.helper.getAllItems.getMateriItem;
import static com.bulutangkis.learning.helper.getAllItems.getPresentasi;

public class PresentasiActivity extends AppCompatActivity {

    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentasi);

        List<PresentasiModel> rowListItem = getPresentasi();
        lLayout = new LinearLayoutManager(PresentasiActivity.this);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerview);
        rView.setLayoutManager(lLayout);

//        GridLayoutManager manager = new GridLayoutManager(this, 2,
//                GridLayoutManager.VERTICAL, false);
//        rView.setLayoutManager(manager);

        PresentasiAdapter presensiAdapter = new PresentasiAdapter(PresentasiActivity.this, rowListItem);
        rView.setAdapter(presensiAdapter);
    }


    private class PresentasiAdapter extends RecyclerView.Adapter<PresentasiAdapter.ViewHolder> {
        List<PresentasiModel> list;
        Context context;

        public PresentasiAdapter(Context context, List<PresentasiModel> list) {
            this.list = list;
            this.context = context;
        }

        @Override
        public PresentasiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_presentasi, parent, false);
            return new PresentasiAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(PresentasiAdapter.ViewHolder holder, int position) {
            PresentasiModel model = list.get(position);

            holder.judulTv.setText(model.getJudul());
            holder.headerIm.setImageResource(model.getPhoto());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView judulTv;
            ImageView headerIm;

            public ViewHolder(View itemView) {
                super(itemView);

                judulTv = (TextView) itemView.findViewById(R.id.tv_label);
                headerIm = (ImageView) itemView.findViewById(R.id.image);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (getPosition() == 0) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi01.class));
                } else if (getPosition() == 1) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi02.class));
                }else if (getPosition() == 2) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi03.class));
                }else if (getPosition() == 3) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi04.class));
                }else if (getPosition() == 4) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi05.class));
                }else if (getPosition() == 5) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi06.class));
                }else if (getPosition() == 6) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi07.class));
                }else if (getPosition() == 7) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi08.class));
                }else if (getPosition() == 8) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi09.class));
                }else if (getPosition() == 9) {
                    startActivity(new Intent(PresentasiActivity.this, Presentasi10.class));
                }
            }
        }
    }
}
