package scu.miomin.com.shareward.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import scu.miomin.com.shareward.constants.APPAction;
import scu.miomin.com.shareward.constants.APPStatu;
import scu.miomin.com.shareward.welcome.WelcomeActivity;


/**
 * Created by 莫绪旻 and Stay on 2/2/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getContentView();
        Log.i("miomin", getClass().getSimpleName());
        // 添加一个Activity实例到AppStatusTracker
        AppStatusTracker.getInstance(getApplication()).addActivity(this);
        switch (AppStatusTracker.getInstance(getApplication()).getAppStatus()) {
            // 若果App从后台恢复，且被kill掉
            case APPStatu.STATUS_FORCE_KILLED:
                protectApp();
                break;
            // 如果APP正常启动
            case APPStatu.STATUS_ONLINE:
                setUpView();
                setUpData(savedInstanceState);
                break;
        }
    }

    protected abstract void getContentView();

    protected abstract void setUpView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 从AppStatusTracker中删除被销毁的activity实例
        AppStatusTracker.getInstance(getApplication()).removeActivity(this);
    }

    /**
     * 正常启动
     */
    protected abstract void setUpData(Bundle savedInstanceState);

    /**
     * 如果App被kill掉了，应该回到welcomeActivity（singtask），重新进入APP正常的启动流程
     */
    protected void protectApp() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra(APPAction.KEY_HOME_ACTION, APPAction.ACTION_RESTART_APP);
        startActivity(intent);
    }
}
