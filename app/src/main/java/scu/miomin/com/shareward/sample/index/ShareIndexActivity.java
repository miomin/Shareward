package scu.miomin.com.shareward.sample.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.scu.miomin.sharewardlib.constants.ActivityType;
import com.scu.miomin.sharewardlib.toolbar.ToolbarActivity;
import com.scu.miomin.sharewardlib.widgets.recyclerview.ShareCommonAdapter;
import com.scu.miomin.sharewardlib.widgets.recyclerview.ShareDividerItemDecoration;
import com.scu.miomin.sharewardlib.widgets.recyclerview.ShareOnItemClickListener;
import com.scu.miomin.sharewardlib.widgets.recyclerview.holder.ShareViewHolder;

import java.util.ArrayList;
import java.util.List;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.home.HomePagerActivity;
import scu.miomin.com.shareward.sample.activity.SampleTabActivity;
import scu.miomin.com.shareward.sample.network.SampleNetworkActivity;
import scu.miomin.com.shareward.sample.recyclerview.SampleChatActivity;
import scu.miomin.com.shareward.sample.recyclerview.SampleRecyclerViewActivity;
import scu.miomin.com.shareward.sample.recyclerview.SampleSectionRvActivity;

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
    }
}
