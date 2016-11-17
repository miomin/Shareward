package scu.miomin.com.shareward.core;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import scu.miomin.com.shareward.constants.APPStatu;
import scu.miomin.com.shareward.util.progress.PDMessage;
import scu.miomin.com.shareward.util.progress.ProgressDialogHandler;


/**
 * Created by 莫绪旻 and Stay on 2/2/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected ProgressDialogHandler mProgressDialogHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("miomin", getClass().getSimpleName() + " oncreate");
        super.onCreate(savedInstanceState);
        getContentView();
        // 添加一个Activity实例到AppStatusTracker
        AppStatusTracker.getInstance(getApplication()).addActivity(this);
        switch (AppStatusTracker.getInstance(getApplication()).getAppStatus()) {
            // 若果App从后台恢复，且被kill掉
            case APPStatu.STATUS_FORCE_KILLED:
                Log.i("miomin", "protectApp");
                protectApp();
                break;
            // 如果APP正常启动
            case APPStatu.STATUS_ONLINE:
                setUpView();
                setUpData(savedInstanceState);
                break;
        }

        mProgressDialogHandler = new ProgressDialogHandler(this, true);
    }

    protected abstract void getContentView();

    protected abstract void setUpView();

    @Override
    protected void onDestroy() {
        Log.i("miomin", getClass().getSimpleName() + " destory");
        super.onDestroy();
        // 从AppStatusTracker中删除被销毁的activity实例
        AppStatusTracker.getInstance(getApplication()).removeActivity(this);
        mProgressDialogHandler = null;
    }

    @Override
    protected void onPause() {
        dismissProgressDialog();
        super.onPause();
    }

    /**
     * 正常启动
     */
    protected abstract void setUpData(Bundle savedInstanceState);

    /**
     * 如果App被kill掉了，应该回到welcomeActivity（singtask），重新进入APP正常的启动流程
     */
    protected void protectApp() {
        AppStatusTracker.getInstance(getApplication()).protectApp(this);
    }

    public void showProgressDialog(String title, String message) {
        if (mProgressDialogHandler != null) {
            Message msg = mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG);
            PDMessage pdmessage = new PDMessage(title, message);
            msg.obj = pdmessage;
            msg.sendToTarget();
        }
    }

    public void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
        }
    }
}
