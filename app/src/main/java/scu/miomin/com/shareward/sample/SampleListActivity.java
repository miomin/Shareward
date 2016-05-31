package scu.miomin.com.shareward.sample;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.list.BaseListActivity;

/**
 * Created by 莫绪旻 on 16/2/29.
 */
public class SampleListActivity extends BaseListActivity implements SwipeRefreshLayout.OnRefreshListener {

    private ArrayList<String> dataList = new ArrayList<>();

    @Override
    protected void setUpView() {
        setContentView(R.layout.activity_sample_list, ActivityType.MODE_TOOLBAR);
        super.setUpView();
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        super.setUpData(savedInstanceState);
        setRefreshing();
        setUpTitle("SampleList");
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getApplicationContext());
    }

    @Override
    protected int getDataCount() {
        return dataList.size();
    }

    @Override
    protected void onBindHolder(RecyclerView.ViewHolder holder, int position) {
        ((ShareViewHolder) holder).mItemLabel.setText(dataList.get(position));
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ShareViewHolder(view);
    }

    @Override
    public void onRefresh() {
        dataList.clear();
        for (int i = 0; i < 1000; i++) {
            dataList.add("sample list item " + Math.random());
        }
        adapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    class ShareViewHolder extends RecyclerView.ViewHolder {

        TextView mItemLabel;

        public ShareViewHolder(View itemView) {
            super(itemView);
            mItemLabel = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
