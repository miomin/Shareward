package scu.miomin.com.shareward.sample.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.base.toolbar.ToolbarActivity;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.widgets.recyclerview.ShareCommonAdapter;
import scu.miomin.com.shareward.widgets.recyclerview.ShareDividerItemDecoration;
import scu.miomin.com.shareward.widgets.recyclerview.holder.ShareViewHolder;

public class SampleRecyclerViewActivity extends ToolbarActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_sample_recyclerview, ActivityType.MODE_TOOLBAR_BACK);
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
        mRecyclerView.setAdapter(new ShareCommonAdapter<String>(this, R.layout.item_list, mDatas) {
            @Override
            public void convert(ShareViewHolder holder, String s) {
                holder.setText(R.id.id_item_list_title, s);
            }
        });
    }

    private void initDatas() {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add((char) i + "");
        }
    }
}
