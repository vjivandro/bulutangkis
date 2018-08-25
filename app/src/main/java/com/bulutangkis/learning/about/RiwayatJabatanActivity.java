package com.bulutangkis.learning.about;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bulutangkis.learning.R;
import com.bulutangkis.learning.model.RiwayatJabatanModel;

import java.util.List;

import static com.bulutangkis.learning.utils.getAllItems.getJabatanItem;

public class RiwayatJabatanActivity extends AppCompatActivity {
    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendidikan);

        List<RiwayatJabatanModel> rowListItem = getJabatanItem();
        lLayout = new LinearLayoutManager(RiwayatJabatanActivity.this);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recyclerview);
        rView.setLayoutManager(lLayout);

        RiwayatJabatanAdapter adapter = new RiwayatJabatanAdapter(rowListItem, this);
        rView.setAdapter(adapter);
    }

    public class RiwayatJabatanAdapter extends RecyclerView.Adapter<RiwayatJabatanAdapter.ViewHolder> {

        List<RiwayatJabatanModel> list;
        Context context;

        public RiwayatJabatanAdapter(List<RiwayatJabatanModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_jabatan, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            RiwayatJabatanModel model = list.get(position);

            holder.jabatan.setText(model.getJabatan());
            holder.pangkat.setText("Pangkat : " + model.getPangkat() + ", ");
            holder.golongan.setText("Golongan : " + model.getGolongan());
            holder.tahunmulai.setText("Terhitung Mulai Tanggal/Tahun : " + model.getTglth());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView jabatan, pangkat, golongan, tahunmulai;

            public ViewHolder(View itemView) {
                super(itemView);

                jabatan = (TextView) itemView.findViewById(R.id.tv_jabatan);
                pangkat = (TextView) itemView.findViewById(R.id.tv_pangkat);
                golongan = (TextView) itemView.findViewById(R.id.tv_golongan);
                tahunmulai = (TextView) itemView.findViewById(R.id.tv_thmulai);
            }
        }
    }
}
