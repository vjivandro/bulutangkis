package com.bulutangkis.learning;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
import com.bulutangkis.learning.materi.SejarahBulutangkis;
import com.bulutangkis.learning.materi.StrategiBulutangkis;
import com.bulutangkis.learning.materi.TeknikServiceBulutangkis;
import com.bulutangkis.learning.model.MateriModel;
import com.bulutangkis.learning.utils.MyIntro;

import java.util.List;

import static com.bulutangkis.learning.helper.getAllItems.getMateriItem;

public class MateriActivity extends AppCompatActivity {

    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        List<MateriModel> rowListItem = getMateriItem();
        lLayout = new LinearLayoutManager(MateriActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerview);
        //rView.setLayoutManager(lLayout);

        GridLayoutManager manager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        rView.setLayoutManager(manager);

        MateriAdapter adapter = new MateriAdapter(MateriActivity.this, rowListItem);
        rView.setAdapter(adapter);
    }

    public class MateriAdapter extends RecyclerView.Adapter<MateriAdapter.ViewHolder> {
        private List<MateriModel> itemList;
        private Context context;

        public MateriAdapter(Context context, List<MateriModel> itemList) {
            this.itemList = itemList;
            this.context = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recyclevie_materi_ii, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            MateriModel model = itemList.get(position);

            holder.judulTv.setText(model.getJudul());
            holder.headerIm.setImageResource(model.getPhoto());

        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView judulTv;
            ImageView headerIm;

            public ViewHolder(View itemView) {
                super(itemView);

                judulTv = (TextView) itemView.findViewById(R.id.textView);
                headerIm = (ImageView) itemView.findViewById(R.id.imageView);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (getPosition() == 0) {
                    startActivity(new Intent(MateriActivity.this, SejarahBulutangkis.class));
                } else if (getPosition() == 1) {
                    startActivity(new Intent(MateriActivity.this, PeraturanBulutangkis.class));
                }else if (getPosition() == 2) {
                    startActivity(new Intent(MateriActivity.this, PerwasitanBulutangkis.class));
                }else if (getPosition() == 3) {
                    startActivity(new Intent(MateriActivity.this, StrategiBulutangkis.class));
                }else if (getPosition() == 4) {
                    startActivity(new Intent(MateriActivity.this, TeknikServiceBulutangkis.class));
                }
            }
        }
    }

}
