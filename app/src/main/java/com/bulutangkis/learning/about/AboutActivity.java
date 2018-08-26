package com.bulutangkis.learning.about;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import java.util.List;

import static com.bulutangkis.learning.helper.getAllItems.getProfileItemList;

public class AboutActivity extends AppCompatActivity {

    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        List<ProfilModel> rowListItem = getProfileItemList();
        lLayout = new LinearLayoutManager(AboutActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerview);
        GridLayoutManager manager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        rView.setLayoutManager(manager);

        ProfilAdapter adapter = new ProfilAdapter(rowListItem, AboutActivity.this);
        rView.setAdapter(adapter);


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
                    startActivity(new Intent(itemView.getContext(), RiwayatJabatanActivity.class));
                } else if (getPosition() == 4) {
                    startActivity(new Intent(itemView.getContext(), SertifikatActivity.class));
                } else if (getPosition() == 5) {
                    startActivity(new Intent(itemView.getContext(), FipWebviewActivity.class));
                } else if (getPosition() == 6) {
                    startActivity(new Intent(itemView.getContext(), UMWebviewActivity.class));
                } else if (getPosition() == 7) {
                    startActivity(new Intent(itemView.getContext(), InformasiActivity.class));
                } else if (getPosition() == 8) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AboutActivity.this);
                    builder.setTitle("Mobile Developer");
                    builder.setIcon(R.drawable.ic_android);
                    builder.setMessage("Juris Vassa Ivandro, S.Kom\n082143594666\nvjivandro77@gmail.com");
                    builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //getActivity().finish();
                        }
                    });
                    builder.show();
                }
            }
        }
    }
}
