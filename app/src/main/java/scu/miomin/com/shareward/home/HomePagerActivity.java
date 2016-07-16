package scu.miomin.com.shareward.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.scu.miomin.sharewardlib.constants.ActivityType;
import com.scu.miomin.sharewardlib.toolbar.ToolbarActivity;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.sample.fragment.SampleBundleFragment;


/**
 * Created by 莫绪旻 on 16/5/2.
 */
public class HomePagerActivity extends ToolbarActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mHomepager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_home_pager, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        mHomepager = (ViewPager) findViewById(R.id.mHomepager);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        mHomepager.setOffscreenPageLimit(3);
        mHomepager.setOnPageChangeListener(this);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mHomepager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * viewpager适配器
     */
    static class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return SampleBundleFragment.newInstance("Page:" + position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void setPrimaryItem(ViewGroup container, int position, Object object) {
            super.setPrimaryItem(container, position, object);
        }
    }
}
