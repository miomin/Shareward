package scu.miomin.com.shareward.sample.photoview;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.scu.miomin.sharewardlib.constants.ActivityType;
import com.scu.miomin.sharewardlib.toolbar.ToolbarActivity;
import com.scu.miomin.sharewardlib.view.MultiTouchViewPager;

import me.relex.circleindicator.CircleIndicator;
import me.relex.photodraweeview.PhotoDraweeView;
import scu.miomin.com.shareward.R;

/**
 * Created by 莫绪旻 on 16/7/15.
 */
public class SampleViewPagerPhotoActivity extends ToolbarActivity {

    private CircleIndicator indicator;
    private MultiTouchViewPager viewPager;

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_photo_viewpager, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewPager = (MultiTouchViewPager) findViewById(R.id.view_pager);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        viewPager.setAdapter(new DraweePagerAdapter());
        indicator.setViewPager(viewPager);
    }

    public class DraweePagerAdapter extends PagerAdapter {

        private int[] mDrawables = new int[]{
                R.drawable.pager_photo1, R.drawable.pager_photo2, R.drawable.pager_photo3
        };

        @Override
        public int getCount() {
            return mDrawables.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup viewGroup, int position) {
            final PhotoDraweeView photoDraweeView = new PhotoDraweeView(viewGroup.getContext());
            PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
            controller.setUri(Uri.parse("res:///" + mDrawables[position]));
            controller.setOldController(photoDraweeView.getController());
            controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    if (imageInfo == null) {
                        return;
                    }
                    photoDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
                }
            });
            photoDraweeView.setController(controller.build());

            try {
                viewGroup.addView(photoDraweeView, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return photoDraweeView;
        }
    }
}
