package scu.miomin.com.shareward.sample;

import android.os.Bundle;

import java.util.ArrayList;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.base.ToolbarActivity;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.core.BaseFragment;
import scu.miomin.com.shareward.widgets.tab.TabLayout;
import scu.miomin.com.shareward.widgets.tab.TabView;

public class SampleTabActivity extends ToolbarActivity {

    private TabLayout mTabLayout;
    private BaseFragment fragment;

    @Override
    protected void setUpView() {
        setContentView(R.layout.activity_sample_tab, ActivityType.MODE_TOOLBAR_BACK);
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        final ArrayList<TabView.Tab> tabs = new ArrayList<>();
        tabs.add(new TabView.Tab(R.drawable.tab_main_msg_def, R.string.tab_label_msg, SampleFragment.class));
        tabs.add(new TabView.Tab(R.drawable.tab_main_home_def, R.string.tab_label_home, SampleFragment.class));
        tabs.add(new TabView.Tab(R.drawable.tab_main_setting_def, R.string.tab_label_setting, SampleFragment.class));
        mTabLayout.setUpData(tabs, new TabLayout.OnTabClickListener() {
            @Override
            public void onTabClick(int index) {
                try {
                    fragment = tabs.get(index).targetFragmentClz.newInstance();
                    getSupportFragmentManager().beginTransaction().replace(R.id.mFragmentContainerLayout, fragment).commitAllowingStateLoss();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
