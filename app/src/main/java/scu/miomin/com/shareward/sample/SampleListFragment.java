package scu.miomin.com.shareward.sample;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.list.BaseListFragment;
import scu.miomin.com.shareward.list.BaseViewHolder;

/**
 * Created by 莫绪旻 on 16/2/29.
 */
public class SampleListFragment extends BaseListFragment<String> {

    public static SampleListFragment newInstance() {
        SampleListFragment fragment = new SampleListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_sample_list, container, false);
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity().getApplicationContext());
    }

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ShareViewHolder(view);
    }

    @Override
    public void onRefresh() {
        dataList.clear();
        for (int i = 0; i < 50; i++) {
            dataList.add("sample list item " + Math.random());
        }
        adapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    class ShareViewHolder extends BaseViewHolder {

        TextView mItemLabel;

        public ShareViewHolder(View itemView) {
            super(itemView);
            mItemLabel = (TextView) itemView.findViewById(R.id.text);
        }

        @Override
        public void onBindData(int position) {
            mItemLabel.setText(dataList.get(position));
        }
    }
}
