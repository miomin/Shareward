package scu.miomin.com.shareward.splash;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.scu.miomin.sharewardlib.constants.APPStatu;
import com.scu.miomin.sharewardlib.core.AppStatusTracker;
import com.scu.miomin.sharewardlib.core.BaseActivity;
import com.scu.miomin.sharewardlib.view.CirclePageIndicator;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.APPString;
import scu.miomin.com.shareward.util.SharedPreferenceUtil;
import scu.miomin.com.shareward.util.UIHelper;

/**
 * Created by 莫绪旻 on 15/7/29.
 */
public class SplashActivity extends BaseActivity {

    private Button btnHome;
    private CirclePageIndicator indicator;
    private ViewPager pager;
    private GalleryPagerAdapter adapter;
    private SimpleDraweeView guideImage;
    private int[] images = {
            R.drawable.newer01,
            R.drawable.newer02,
            R.drawable.newer03,
            R.drawable.newer04
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 将APP状态置为已正常启动
        AppStatusTracker.getInstance(getApplication()).setAppStatus(APPStatu.STATUS_ONLINE);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void getContentView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void setUpView() {
        guideImage = (SimpleDraweeView) findViewById(R.id.guideImage);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        Uri uri = Uri.parse("res://" + APPString.PACKAGE_NAME + "/" + R.drawable.welcome);
        guideImage.setImageURI(uri);

        final boolean firstTimeUse = SharedPreferenceUtil.getInstance().getBoolean("first-time-use", true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (firstTimeUse) {
                    Animation fadeOut = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fadeout);
                    fadeOut.setFillAfter(true);
                    findViewById(R.id.guideImage).startAnimation(fadeOut);
                    initGuideGallery();
                    Log.i("miomin","first");
                } else {
                    UIHelper.showHome(SplashActivity.this);
                    Log.i("miomin","first");
                }
            }
        }, 2000);
    }

    private void initGuideGallery() {
        final Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferenceUtil.getInstance().putBoolean("first-time-use", false);
                UIHelper.showHome(SplashActivity.this);
            }
        });

        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setVisibility(View.VISIBLE);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setVisibility(View.VISIBLE);

        adapter = new GalleryPagerAdapter();
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == images.length - 1) {
                    btnHome.setVisibility(View.VISIBLE);
                    btnHome.startAnimation(fadeIn);
                } else {
                    btnHome.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public class GalleryPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            SimpleDraweeView item = new SimpleDraweeView(SplashActivity.this);
            item.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Uri uri = Uri.parse("res://" + APPString.PACKAGE_NAME + "/" + images[position]);
            item.setImageURI(uri);
            container.addView(item);
            return item;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }
    }

}
