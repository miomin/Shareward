package scu.miomin.com.shareward.activity.rxjavamvp.index;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.activity.rxjavamvp.flatmap.FlatMapActivity;
import scu.miomin.com.shareward.activity.rxjavamvp.hellorx.HelloRxJavaActivity;
import scu.miomin.com.shareward.activity.rxjavamvp.retrofit.view.impl.DBTopMovieActivity;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.toolbar.ToolbarActivity;
import scu.miomin.com.shareward.widgets.recyclerview.ShareCommonAdapter;
import scu.miomin.com.shareward.widgets.recyclerview.ShareDividerItemDecoration;
import scu.miomin.com.shareward.widgets.recyclerview.ShareOnItemClickListener;
import scu.miomin.com.shareward.widgets.recyclerview.holder.ShareViewHolder;

public class SampleRxJavaActivity extends ToolbarActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_sample_rx_java, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new ShareDividerItemDecoration(this, ShareDividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        setUpTitle("Sample RxJava");
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
                        startActivity(new Intent(SampleRxJavaActivity.this, HelloRxJavaActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(SampleRxJavaActivity.this, FlatMapActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(SampleRxJavaActivity.this, DBTopMovieActivity.class));
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
        mDatas.add("HelloRxJava");
        mDatas.add("FlatMap");
        mDatas.add("Retrofit+RxJava+MVP");
    }
}
