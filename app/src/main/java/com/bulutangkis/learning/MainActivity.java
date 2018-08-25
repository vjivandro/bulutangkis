package com.bulutangkis.learning;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bulutangkis.learning.about.AboutActivity;
import com.bulutangkis.learning.model.DashBoardModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        List<DashBoardModel> rowListItem = getAllItemList();

        RecyclerView rView = (RecyclerView)findViewById(R.id.recyclerview);

        DashboardViewAdapter rcAdapter = new DashboardViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
//                LinearLayoutManager.HORIZONTAL, false);

        GridLayoutManager manager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        rView.setLayoutManager(manager);
        rView.addItemDecoration(new ItemDecorationColumns(2, 2));

    }

    private List<DashBoardModel> getAllItemList(){

        List<DashBoardModel> allItems = new ArrayList<DashBoardModel>();
        allItems.add(new DashBoardModel("Materi", R.drawable.ic_materi));
        allItems.add(new DashBoardModel("Video Tutorial", R.drawable.ic_video));
        allItems.add(new DashBoardModel("Test", R.drawable.ic_test));
        allItems.add(new DashBoardModel("about", R.drawable.ic_about));

        return allItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, AboutActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class ItemDecorationColumns extends RecyclerView.ItemDecoration {
        private int mSizeGridSpacingPx;
        private int mGridSize;
        private boolean mNeedLeftSpacing = false;

        public ItemDecorationColumns(int gridSpacingPx, int gridSize) {
            mSizeGridSpacingPx = gridSpacingPx;
            mGridSize = gridSize;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int frameWidth = (int) ((parent.getWidth() - (float) mSizeGridSpacingPx * (mGridSize - 1)) / mGridSize);
            int padding = parent.getWidth() / mGridSize - frameWidth;
            int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
            if (itemPosition < mGridSize) {
                outRect.top = 0;
            } else {
                outRect.top = mSizeGridSpacingPx;
            }
            if (itemPosition % mGridSize == 0) {
                outRect.left = 0;
                outRect.right = padding;
                mNeedLeftSpacing = true;
            } else if ((itemPosition + 1) % mGridSize == 0) {
                mNeedLeftSpacing = false;
                outRect.right = 0;
                outRect.left = padding;
            } else if (mNeedLeftSpacing) {
                mNeedLeftSpacing = false;
                outRect.left = mSizeGridSpacingPx - padding;
                if ((itemPosition + 2) % mGridSize == 0) {
                    outRect.right = mSizeGridSpacingPx - padding;
                } else {
                    outRect.right = mSizeGridSpacingPx / 2;
                }
            } else if ((itemPosition + 2) % mGridSize == 0) {
                mNeedLeftSpacing = false;
                outRect.left = mSizeGridSpacingPx / 2;
                outRect.right = mSizeGridSpacingPx - padding;
            } else {
                mNeedLeftSpacing = false;
                outRect.left = mSizeGridSpacingPx / 2;
                outRect.right = mSizeGridSpacingPx / 2;
            }
            outRect.bottom = 0;
        }
    }
}
