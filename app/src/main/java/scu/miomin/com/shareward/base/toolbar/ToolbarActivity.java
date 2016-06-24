package scu.miomin.com.shareward.base.toolbar;

import android.os.Build;
import android.support.annotation.LayoutRes;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.core.BaseActivity;
import scu.miomin.com.shareward.log.MyLogger;

/**
 * Created by 莫绪旻 on 16/4/24.
 */
public abstract class ToolbarActivity extends BaseActivity {

    protected Toolbar toolbar;
    private TextView toolbar_title;
    protected ActionBar actionBar;
    private ToolBarHelper mToolBarHelper ;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(layoutResID, ActivityType.MODE_TOOLBAR);
    }

    /**
     * 根据Activity类型确定Toolbar需要做哪些初始化
     */
    protected void setContentView(@LayoutRes int layoutResID, int mode) {
        setToolbar(mode,layoutResID);
    }

    /**
     * 设置Toolbar
     */
    private void setToolbar(int mode,@LayoutRes int layoutResID) {

        mToolBarHelper = new ToolBarHelper(this,layoutResID) ;
        toolbar = mToolBarHelper.getToolBar() ;
        setContentView(mToolBarHelper.getContentView());
        setSupportActionBar(toolbar);
        toolbar.setContentInsetsRelative(0,0);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        toolbar_title = (TextView) findViewById(R.id.toolbar_title);

        switch (mode) {
            case ActivityType.MODE_TOOLBAR:
                break;
            case ActivityType.MODE_TOOLBAR_BACK:
                // 显示回退键
                if (actionBar != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    if (NavUtils.getParentActivityName(this) != null) {
                        actionBar.setDisplayHomeAsUpEnabled(true);
                    }
                }
                break;
            case ActivityType.MODE_TOOLBAR_DRAWER:
                // TODO 初始化Drawer
                break;
        }
    }

    /**
     * 设置Toolbar标题
     */
    public void setUpTitle(String title, int gravity, int titleSize, int titleColor) {

        if (toolbar == null || toolbar_title == null) {
            return;
        }

        toolbar.setTitle("");
        toolbar_title.setText(title);
        toolbar_title.setGravity(gravity);
        toolbar_title.setTextSize(titleSize);
        toolbar_title.setTextColor(titleColor);
    }

    /**
     * 设置Toolbar标题
     */
    public void setUpTitle(String title) {

        if (toolbar == null || toolbar_title == null) {
            MyLogger.Log_dev1(getApplicationContext()).i("notitle");
            return;
        }

        toolbar.setTitle("");
        MyLogger.Log_dev1(getApplicationContext()).i("setuptitle");
        toolbar_title.setText(title);
    }

    /**
     * 设置Title对齐方式
     */
    public void setTitleTextGravity(int gravity) {

        if (toolbar == null || toolbar_title == null) {
            return;
        }

        toolbar_title.setGravity(gravity);
    }

    /**
     * 设置Title字体
     */
    public void setTitleTextSize(int titleSize) {

        if (toolbar == null || toolbar_title == null) {
            return;
        }

        toolbar_title.setTextSize(titleSize);
    }

    /**
     * 设置Title颜色
     */
    public void setTitleTextColor(int titleColor) {

        if (toolbar == null || toolbar_title == null) {
            return;
        }

        toolbar_title.setTextColor(titleColor);
    }
}
