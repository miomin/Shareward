package scu.miomin.com.shareward.list;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.core.BaseFragment;

/**
 * Created by 莫绪旻 on 16/06/09.
 */
public abstract class BaseListFragment<T> extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected RecyclerView mRecyclerView;
    protected BaseListAdapter adapter;
    protected ArrayList<T> dataList = new ArrayList<>();

    @Override
    protected void setUpView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) fragmentView.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.recyclerView);
    }

    @Override
    protected void setUpData() {
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
