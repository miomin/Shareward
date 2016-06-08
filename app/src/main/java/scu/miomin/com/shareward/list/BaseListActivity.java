package scu.miomin.com.shareward.list;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.base.toolbar.ToolbarActivity;


/**
 * Created by Miomin and Stay on 2/2/16.
 */
public abstract class BaseListActivity<T> extends ToolbarActivity implements SwipeRefreshLayout.OnRefreshListener {

    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected RecyclerView mRecyclerView;
    protected BaseListAdapter adapter;
    protected ArrayList<T> dataList = new ArrayList<>();


    @Override
    protected void setUpView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        mRecyclerView.setLayoutManager(getLayoutManager());
        adapter = new BaseListAdapter();
        mRecyclerView.setAdapter(adapter);
        setRefreshing();
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
    public class BaseListAdapter extends RecyclerView.Adapter<BaseViewHolder> {

        @Override
        public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return getViewHolder(parent, viewType);
        }

        @Override
        public void onBindViewHolder(BaseViewHolder holder, int position) {
            holder.onBindData(position);
        }

        @Override
        public int getItemCount() {
            return dataList != null ? dataList.size() : 0;
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }
    }

    protected abstract BaseViewHolder getViewHolder(ViewGroup parent, int viewType);
}