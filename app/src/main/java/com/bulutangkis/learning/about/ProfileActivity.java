package com.bulutangkis.learning.about;

import android.content.Context;
import android.content.Intent;
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

import com.bulutangkis.learning.R;
import com.bulutangkis.learning.model.ProfilModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private LinearLayoutManager lLayout;
    private TextView nama_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        List<ProfilModel> rowListItem = getProfileItemList();
        lLayout = new LinearLayoutManager(ProfileActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerview);
        GridLayoutManager manager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        rView.setLayoutManager(manager);

        ProfilAdapter adapter = new ProfilAdapter(rowListItem, ProfileActivity.this);
        rView.setAdapter(adapter);

        nama_tv = (TextView) findViewById(R.id.tv_nama);
    }

    private List<ProfilModel> getProfileItemList() {
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
        allItems.add(new ProfilModel(R.drawable.ic_assignment_ind, "Sertifikat"));
        allItems.add(new ProfilModel(R.drawable.ic_android, "Mobile Developer"));

        return allItems;
    }


    private class ProfilAdapter extends RecyclerView.Adapter<ProfilAdapter.ProfilHolder>{

        private List<ProfilModel> itemList;
        private Context context;

        public ProfilAdapter(List<ProfilModel> itemList, Context context) {
            this.itemList = itemList;
            this.context = context;
        }

        @Override
        public ProfilHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_profil, parent, false);
            return new ProfilHolder(view);
        }

        @Override
        public void onBindViewHolder(ProfilHolder holder, int position) {
            ProfilModel model = itemList.get(position);

            holder.imageView.setImageResource(model.getPhoto());
            holder.value_tv.setText(model.getValue());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class ProfilHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            ImageView imageView;
            TextView value_tv;

            public ProfilHolder(View itemView) {
                super(itemView);

                imageView = (ImageView) itemView.findViewById(R.id.image);
                value_tv = (TextView) itemView.findViewById(R.id.tv_value);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                String value = value_tv.getText().toString();

                if (getPosition() == 0) {
                    startActivity(new Intent(itemView.getContext(), IdentitasActivity.class));
                } else if (getPosition() == 1) {
                    startActivity(new Intent(itemView.getContext(), PendidikanActivity.class));
                } else if (getPosition() == 2) {
                    startActivity(new Intent(itemView.getContext(), RiwayatPekerjaanActivity.class));
                } else if (getPosition() == 3) {

                } else if (getPosition() == 4) {

                } else if (getPosition() == 5) {

                }
            }
        }
    }
}
