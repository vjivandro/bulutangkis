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
import com.bulutangkis.learning.model.PendidikanModel;

import java.util.List;

import static com.bulutangkis.learning.dbhelper.getAllItems.getPendidikanList;

public class PendidikanActivity extends AppCompatActivity {

    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendidikan);

        List<PendidikanModel> rowListItem = getPendidikanList();
        lLayout = new LinearLayoutManager(PendidikanActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerview);
        rView.setLayoutManager(lLayout);

        PendidikanAdapter adapter = new PendidikanAdapter(rowListItem, PendidikanActivity.this);
        rView.setAdapter(adapter);
    }

    public class PendidikanAdapter extends RecyclerView.Adapter<PendidikanAdapter.ViewHolder> {
        List<PendidikanModel> list;
        Context context;

        public PendidikanAdapter(List<PendidikanModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_pendidikan, parent, false);
            return new PendidikanAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            PendidikanModel model = list.get(position);

            holder.pendidikan.setText(model.getPendidikan());
            holder.sekolah.setText(model.getSekola());
            holder.tahun.setText("Tahun : " + model.getTahun());
            holder.ijasah.setText("Ijasah : " + model.getIjasah());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            TextView pendidikan, sekolah, tahun, ijasah;
            public ViewHolder(View itemView) {
                super(itemView);

                pendidikan = (TextView) itemView.findViewById(R.id.tv_pendidikan);
                sekolah = (TextView) itemView.findViewById(R.id.tv_sekolah);
                tahun = (TextView) itemView.findViewById(R.id.tv_th);
                ijasah = (TextView) itemView.findViewById(R.id.tv_ijasah);
            }
        }
    }
}
