package com.bulutangkis.learning.about;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bulutangkis.learning.R;
import com.bulutangkis.learning.model.RiwayatPekerjaanModel;

import java.util.List;

import static com.bulutangkis.learning.utils.getAllItems.getRiwayatList;

public class RiwayatPekerjaanActivity extends AppCompatActivity {

    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_pekerjaan);

        List<RiwayatPekerjaanModel> rowListItem = getRiwayatList();
        lLayout = new LinearLayoutManager(RiwayatPekerjaanActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerview);
        rView.setLayoutManager(lLayout);

        RiwayatPekerjaanAdapter adapter = new RiwayatPekerjaanAdapter(rowListItem, RiwayatPekerjaanActivity.this);
        rView.setAdapter(adapter);
    }

    public class RiwayatPekerjaanAdapter extends RecyclerView.Adapter<RiwayatPekerjaanAdapter.ViewHolder> {
        List<RiwayatPekerjaanModel> list;
        Context context;

        public RiwayatPekerjaanAdapter(List<RiwayatPekerjaanModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_riwayat, parent, false);
            return new RiwayatPekerjaanAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            RiwayatPekerjaanModel model = list.get(position);

            holder.tempat.setText(model.getTempat());
            holder.start.setText("Tahun Mulai : " + model.getStart());
            holder.jabatan.setText("Jabatan : " + model.getJabatan());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView tempat, start, jabatan;

            public ViewHolder(View itemView) {
                super(itemView);

                tempat = (TextView) itemView.findViewById(R.id.tv_tempat);
                start = (TextView) itemView.findViewById(R.id.tv_start);
                jabatan = (TextView) itemView.findViewById(R.id.tv_jabatan);
            }
        }
    }
}
