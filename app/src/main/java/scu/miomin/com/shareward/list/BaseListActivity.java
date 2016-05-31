package scu.miomin.com.shareward.list;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.base.toolbar.ToolbarActivity;


/**
 * Created by Miomin and Stay on 2/2/16.
 */
public abstract class BaseListActivity extends ToolbarActivity implements SwipeRefreshLayout.OnRefreshListener {

    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected RecyclerView mRecyclerView;
    protected ShareAdapter adapter;

    @Override
    protected void setUpView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        mRecyclerView.setLayoutManager(getLayoutManager());
        adapter = new ShareAdapter();
        mRecyclerView.setAdapter(adapter);
    }

    protected void setRefreshing() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }

    /**
     * 指定RecyclerView的布局方式
     */
    protected abstract RecyclerView.LayoutManager getLayoutManager();

    /**
     * SampleListAdapter
     */
    public class ShareAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return getViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            onBindHolder(holder, position);
        }

        @Override
        public int getItemCount() {
            return getDataCount();
        }
    }

    protected abstract int getDataCount();

    protected abstract void onBindHolder(RecyclerView.ViewHolder holder, int position);

    protected abstract RecyclerView.ViewHolder getViewHolder(ViewGroup parent, int viewType);
}
