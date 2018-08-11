package com.bulutangkis.learning;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bulutangkis.learning.model.MateriModel;
import com.bulutangkis.learning.model.ProfilModel;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        List<ProfilModel> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(ProfileActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerview);
        rView.setLayoutManager(lLayout);

        ProfilAdapter adapter = new ProfilAdapter(rowListItem, ProfileActivity.this);
        rView.setAdapter(adapter);
    }

    private List<ProfilModel> getAllItemList() {
        List<ProfilModel> allItems = new ArrayList<ProfilModel>();
        allItems.add(new ProfilModel("Nama Lengkap", "Drs. Setyo Budiwanto M. Kes."));
        allItems.add(new ProfilModel("Jenis Kelamin", "Laki -Laki"));
        allItems.add(new ProfilModel("N I P", "130809383"));
        allItems.add(new ProfilModel("Instansi tempat bekerja", "Fakultas Ilmu Pendidikan Universitas Negeri Malang"));
        allItems.add(new ProfilModel("Pekerjaan", "Dosen FIP"));
        allItems.add(new ProfilModel("Jabatan Fungsional", "Lektor Kepala"));

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

            holder.key_tv.setText(model.getKey());
            holder.value_tv.setText(model.getValue());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        public class ProfilHolder extends RecyclerView.ViewHolder {

            TextView key_tv, value_tv;

            public ProfilHolder(View itemView) {
                super(itemView);

                key_tv = (TextView) itemView.findViewById(R.id.tv_key);
                value_tv = (TextView) itemView.findViewById(R.id.tv_value);
            }
        }
    }
}
