package com.bulutangkis.learning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bulutangkis.learning.model.MateriModel;
import com.bulutangkis.learning.model.VideoModel;
import com.bulutangkis.learning.video.FirstPlayerActivity;

import java.util.List;

import static com.bulutangkis.learning.dbhelper.getAllItems.getMateriItem;
import static com.bulutangkis.learning.dbhelper.getAllItems.getVideoItems;

public class VideoActivity extends AppCompatActivity {
    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        List<VideoModel> rowListItem = getVideoItems();
        lLayout = new LinearLayoutManager(VideoActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerview);
        rView.setLayoutManager(lLayout);

        VideoAdapter adapter = new VideoAdapter(rowListItem, this);
        rView.setAdapter(adapter);
    }


    private class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder>{
        List<VideoModel> list;
        Context context;

        public VideoAdapter(List<VideoModel> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public VideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.recycleview_video, parent, false);
            return new VideoHolder(view);
        }

        @Override
        public void onBindViewHolder(VideoHolder holder, int position) {
            VideoModel model = list.get(position);

            holder.icon.setImageResource(model.getPhoto());
            holder.label.setText(model.getLabel());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class VideoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            ImageView icon;
            TextView label;

            public VideoHolder(View itemView) {
                super(itemView);

                icon = (ImageView) itemView.findViewById(R.id.image);
                label = (TextView) itemView.findViewById(R.id.tv_label);

                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                if (getPosition() == 0) {
                    startActivity(new Intent(itemView.getContext(), FirstPlayerActivity.class));
                } else if (getPosition() == 1) {

                }
            }
        }
    }
}
