package scu.miomin.com.shareward.core;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.APPAction;
import scu.miomin.com.shareward.constants.APPStatu;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.welcome.WelcomeActivity;


/**
 * Created by Miomin and Stay on 2/2/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    private TextView toolbar_title;
    protected ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 添加一个Activity实例到AppStatusTracker
        AppStatusTracker.getInstance(getApplication()).addActivity(this);
        switch (AppStatusTracker.getInstance(getApplication()).getAppStatus()) {
            // 若果App从后台恢复，且被kill掉
            case APPStatu.STATUS_FORCE_KILLED:
                protectApp();
                break;
            // 如果APP正常启动
            case APPStatu.STATUS_ONLINE:
                setUpData();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 从AppStatusTracker中删除被销毁的activity实例
        AppStatusTracker.getInstance(getApplication()).removeActivity(this);
    }

    /**
     * 正常启动
     */
    protected abstract void setUpData();

    /**
     * 如果App被kill掉了，应该回到welcomeActivity（singtask），重新进入APP正常的启动流程
     */
    protected void protectApp() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra(APPAction.KEY_HOME_ACTION, APPAction.ACTION_RESTART_APP);
        startActivity(intent);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        // 默认为MODE_NONE_TOOLBAR类型
        setContentView(layoutResID, ActivityType.MODE_NONE_TOOLBAR);
    }

    /**
     * 根据Activity类型确定Toolbar需要做哪些初始化
     */
    public void setContentView(@LayoutRes int layoutResID, int mode) {
        super.setContentView(layoutResID);

        if (mode == ActivityType.MODE_NONE_TOOLBAR) {
            return;
        } else {
            setToolbar(mode);
        }
    }

    /**
     * 设置Toolbar
     */
    private void setToolbar(int mode) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();

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
    public void setTitle(String title, int gravity, int titleSize, int titleColor) {

        if (toolbar == null || toolbar_title == null) {
            return;
        }

        toolbar_title.setText(title);
        toolbar_title.setGravity(gravity);
        toolbar_title.setTextSize(titleSize);
        toolbar_title.setTextColor(titleColor);
    }

    /**
     * 设置Toolbar标题
     */
    public void setTitle(String title) {

        if (toolbar == null || toolbar_title == null) {
            return;
        }

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
