package com.bulutangkis.learning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bulutangkis.learning.model.GridModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private List<GridModel> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<GridModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.labelTv.setText(itemList.get(position).getTextLabel());
        holder.imageView.setImageResource(itemList.get(position).getGambar());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView labelTv;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            labelTv = (TextView) itemView.findViewById(R.id.country_name);
            imageView = (ImageView) itemView.findViewById(R.id.country_photo);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (getPosition() == 0) {
                v.getContext().startActivity(new Intent(v.getContext(), MateriActivity.class));
                Toast.makeText(v.getContext(), "Materi", Toast.LENGTH_SHORT).show();
            } else if (getPosition() == 1) {
                v.getContext().startActivity(new Intent(v.getContext(), VideoActivity.class));
                Toast.makeText(v.getContext(), "Video Tutorial", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
