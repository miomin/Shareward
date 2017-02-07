package scu.miomin.com.shareward.activity.recyclerview;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.scu.miomin.shswiperefresh.core.SHSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.toolbar.ToolbarActivity;
import scu.miomin.com.shareward.widgets.recyclerview.ShareCommonAdapter;
import scu.miomin.com.shareward.widgets.recyclerview.ShareDividerItemDecoration;
import scu.miomin.com.shareward.widgets.recyclerview.holder.ShareViewHolder;

/**
 * Created by 莫绪旻 on 16/6/24.
 */
public class SampleRecyclerViewActivity extends ToolbarActivity {

    private RecyclerView mRecyclerView;
    private SHSwipeRefreshLayout swipeRefreshLayout;
    private List<String> mDatas = new ArrayList<>();

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_sample_recyclerview, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        swipeRefreshLayout = (SHSwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
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
            public void convert(ShareViewHolder holder, String text) {
                holder.setText(R.id.id_item_list_title, text);

                Uri uri = Uri.parse("https://avatars2.githubusercontent.com/u/11516748?v=3&s=460");
                SimpleDraweeView draweeView = holder.getView(R.id.item_image);
                draweeView.setImageURI(uri);
            }
        });


        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        final View view = inflater.inflate(R.layout.refresh_view, null);
        final TextView textView = (TextView) view.findViewById(R.id.title);
        swipeRefreshLayout.setFooterView(view);
        swipeRefreshLayout.setOnRefreshListener(new SHSwipeRefreshLayout.SHSOnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.finishRefresh();
                        Toast.makeText(SampleRecyclerViewActivity.this,"刷新完成",Toast.LENGTH_SHORT).show();
                    }
                },1600);
            }

            @Override
            public void onLoading() {
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.finishLoadmore();
                        Toast.makeText(SampleRecyclerViewActivity.this,"加载完成",Toast.LENGTH_SHORT).show();
                    }
                },1600);
            }

            @Override
            public void onRefreshPulStateChange(float percent, int state) {
                switch (state) {
                    case SHSwipeRefreshLayout.NOT_OVER_TRIGGER_POINT:
                        swipeRefreshLayout.setLoaderViewText("下拉刷新");
                        break;
                    case SHSwipeRefreshLayout.OVER_TRIGGER_POINT:
                        swipeRefreshLayout.setLoaderViewText("松开刷新");
                        break;
                    case SHSwipeRefreshLayout.START:
                        swipeRefreshLayout.setLoaderViewText("正在刷新");
                        break;
                }
            }

            @Override
            public void onLoadmorePullStateChange(float percent, int state) {
                switch (state) {
                    case SHSwipeRefreshLayout.NOT_OVER_TRIGGER_POINT:
                        textView.setText("上拉加载");
                        break;
                    case SHSwipeRefreshLayout.OVER_TRIGGER_POINT:
                        textView.setText("松开加载");
                        break;
                    case SHSwipeRefreshLayout.START:
                        textView.setText("正在加载...");
                        break;
                }
            }
        });
    }

    private void initDatas() {
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add((char) i + "");
        }
    }
}
