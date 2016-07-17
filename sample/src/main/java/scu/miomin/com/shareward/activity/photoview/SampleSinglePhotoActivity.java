package scu.miomin.com.shareward.activity.photoview;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.scu.miomin.sharewardlib.constants.ActivityType;
import com.scu.miomin.sharewardlib.toolbar.ToolbarActivity;

import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;
import scu.miomin.com.shareward.R;

/**
 * Created by 莫绪旻 on 16/7/15.
 */
public class SampleSinglePhotoActivity extends ToolbarActivity {

    private PhotoDraweeView mPhotoDraweeView;

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_photo_single, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        mPhotoDraweeView = (PhotoDraweeView) findViewById(R.id.photo_drawee_view);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
        controller.setUri(Uri.parse("res:///" + R.drawable.single_photo));
        controller.setOldController(mPhotoDraweeView.getController());
        // You need setControllerListener
        controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                if (imageInfo == null || mPhotoDraweeView == null) {
                    return;
                }
                mPhotoDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
            }
        });
        mPhotoDraweeView.setController(controller.build());
        mPhotoDraweeView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                Toast.makeText(view.getContext(), "onPhotoTap :  x =  " + x + ";" + " y = " + y,
                        Toast.LENGTH_SHORT).show();
            }
        });
        mPhotoDraweeView.setOnViewTapListener(new OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                Toast.makeText(view.getContext(), "onViewTap", Toast.LENGTH_SHORT).show();
            }
        });

        mPhotoDraweeView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(), "onLongClick", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
