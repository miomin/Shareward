package scu.miomin.com.shareward.activity.recyclerview;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scu.miomin.sharewardlib.constants.ActivityType;
import com.scu.miomin.sharewardlib.toolbar.ToolbarActivity;
import com.scu.miomin.sharewardlib.widgets.recyclerview.ShareDividerItemDecoration;
import com.scu.miomin.sharewardlib.widgets.recyclerview.ShareOnItemClickListener;
import com.scu.miomin.sharewardlib.widgets.recyclerview.holder.ShareViewHolder;
import com.scu.miomin.sharewardlib.widgets.recyclerview.support.ShareSectionAdapter;
import com.scu.miomin.sharewardlib.widgets.recyclerview.support.ShareSectionSupport;

import java.util.ArrayList;
import java.util.List;

import scu.miomin.com.shareward.R;

/**
 * Created by 莫绪旻 on 16/6/24.
 */
public class SampleSectionRvActivity extends ToolbarActivity {

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

        setUpTitle("SectionRecyclerView");
        initDatas();

        ShareSectionSupport<String> sectionSupport = new ShareSectionSupport<String>() {
            @Override
            public int sectionHeaderLayoutId() {
                return R.layout.item_header;
            }

            @Override
            public int sectionTitleTextViewId() {
                return R.id.id_header_title;
            }

            @Override
            public String getTitle(String s) {
                return s.substring(0, 1);
            }
        };

        ShareSectionAdapter adapter = new ShareSectionAdapter<String>(this, R.layout.item_section_list, mDatas, sectionSupport) {

            @Override
            public void convert(ShareViewHolder holder, String s) {
                holder.setText(R.id.id_item_list_title, s);
            }
        };

        adapter.setOnItemClickListener(new ShareOnItemClickListener<String>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, String o, int position) {
                Toast.makeText(SampleSectionRvActivity.this, "Click:" + position + " => " + o, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, String o, int position) {
                return false;
            }
        });

        mRecyclerView.setAdapter(adapter);
    }

    private void initDatas() {
        for (int i = 1; i < 3; i++) {
            mDatas.add("A" + i);
        }

        for (int i = 1; i < 6; i++) {
            mDatas.add("B" + i);
        }

        for (int i = 1; i < 7; i++) {
            mDatas.add("C" + i);
        }

        for (int i = 1; i < 9; i++) {
            mDatas.add("D" + i);
        }
    }
}
