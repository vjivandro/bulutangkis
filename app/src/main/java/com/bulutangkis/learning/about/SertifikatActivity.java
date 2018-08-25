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
import com.bulutangkis.learning.model.SertifikatModel;

import java.util.List;

import static com.bulutangkis.learning.dbhelper.getAllItems.getPendidikanList;
import static com.bulutangkis.learning.dbhelper.getAllItems.getSertifikatItem;

public class SertifikatActivity extends AppCompatActivity {
    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendidikan);

        List<SertifikatModel> rowListItem = getSertifikatItem();
        lLayout = new LinearLayoutManager(SertifikatActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerview);
        rView.setLayoutManager(lLayout);

        SertifikatAdapter adapter = new SertifikatAdapter(rowListItem, this);
        rView.setAdapter(adapter);
    }

    public class SertifikatAdapter extends RecyclerView.Adapter<SertifikatAdapter.SertifikatHolder> {

        List<SertifikatModel> list;
        Context context;

        public SertifikatAdapter(List<SertifikatModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public SertifikatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_sertifikat, parent, false);
            return new SertifikatHolder(view);
        }

        @Override
        public void onBindViewHolder(SertifikatHolder holder, int position) {
            SertifikatModel model = list.get(position);

            holder.sertifikat.setText(model.getSertifikat());
            holder.lembaga.setText(model.getLembaga());
            holder.pejabat.setText(model.getPejabat());
            holder.tgltahun.setText(model.getTgltahun());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class SertifikatHolder extends RecyclerView.ViewHolder {
            TextView sertifikat, lembaga, pejabat, tgltahun;

            public SertifikatHolder(View itemView) {
                super(itemView);

                sertifikat = (TextView) itemView.findViewById(R.id.tv_sertifikat);
                lembaga = (TextView) itemView.findViewById(R.id.tv_lembaga);
                pejabat = (TextView) itemView.findViewById(R.id.tv_pejabat);
                tgltahun = (TextView) itemView.findViewById(R.id.tv_tgltahn);
            }
        }
    }
}
