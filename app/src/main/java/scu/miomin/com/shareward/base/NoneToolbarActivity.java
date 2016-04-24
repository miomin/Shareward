package scu.miomin.com.shareward.base;

import android.support.annotation.LayoutRes;

import scu.miomin.com.shareward.core.BaseActivity;

/**
 * Created by miomin on 16/4/24.
 */
public abstract class NoneToolbarActivity extends BaseActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }
}
