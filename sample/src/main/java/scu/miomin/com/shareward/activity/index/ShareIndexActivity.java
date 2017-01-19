package scu.miomin.com.shareward.activity.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.activity.BottomNavigation.SampleBottomNavigationActivity;
import scu.miomin.com.shareward.activity.db.SampleDBActivity;
import scu.miomin.com.shareward.activity.home.HomePagerActivity;
import scu.miomin.com.shareward.activity.home.SampleTabActivity;
import scu.miomin.com.shareward.activity.network.SampleNetworkActivity;
import scu.miomin.com.shareward.activity.photoview.SampleSinglePhotoActivity;
import scu.miomin.com.shareward.activity.photoview.SampleViewPagerPhotoActivity;
import scu.miomin.com.shareward.activity.recyclerview.SampleChatActivity;
import scu.miomin.com.shareward.activity.recyclerview.SampleRecyclerViewActivity;
import scu.miomin.com.shareward.activity.recyclerview.SampleSectionRvActivity;
import scu.miomin.com.shareward.activity.rxjavamvp.index.SampleRxJavaActivity;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.toolbar.ToolbarActivity;
import scu.miomin.com.shareward.widgets.recyclerview.ShareCommonAdapter;
import scu.miomin.com.shareward.widgets.recyclerview.ShareDividerItemDecoration;
import scu.miomin.com.shareward.widgets.recyclerview.ShareOnItemClickListener;
import scu.miomin.com.shareward.widgets.recyclerview.holder.ShareViewHolder;

/**
 * Created by 莫绪旻 on 16/6/24.
 */
public class ShareIndexActivity extends ToolbarActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_index, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new ShareDividerItemDecoration(this, ShareDividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        setUpTitle("SampleRecyclerView");
        initDatas();

        ShareCommonAdapter<String> commonAdapter = new ShareCommonAdapter<String>(this, R.layout.item_index, mDatas) {
            @Override
            public void convert(ShareViewHolder holder, String text) {
                holder.setText(R.id.id_item_list_title, text);
            }
        };

        commonAdapter.setOnItemClickListener(new ShareOnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(ShareIndexActivity.this, SampleTabActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(ShareIndexActivity.this, HomePagerActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(ShareIndexActivity.this, SampleChatActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(ShareIndexActivity.this, SampleRecyclerViewActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(ShareIndexActivity.this, SampleSectionRvActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(ShareIndexActivity.this, SampleNetworkActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(ShareIndexActivity.this, SampleSinglePhotoActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(ShareIndexActivity.this, SampleViewPagerPhotoActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(ShareIndexActivity.this, SampleDBActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(ShareIndexActivity.this, SampleBottomNavigationActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(ShareIndexActivity.this, SampleRxJavaActivity.class));
                        break;
                }
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });

        mRecyclerView.setAdapter(commonAdapter);

    }

    private void initDatas() {
        mDatas.add("TabBar");
        mDatas.add("HomePager");
        mDatas.add("Chat");
        mDatas.add("RecyclerView");
        mDatas.add("SectionRecyclerView");
        mDatas.add("NewWorkSample");
        mDatas.add("SinglePhotoView");
        mDatas.add("PagerPhotoView");
        mDatas.add("SQLiteHelper");
        mDatas.add("BottomNavigation");
        mDatas.add("RxJava");
    }
}
