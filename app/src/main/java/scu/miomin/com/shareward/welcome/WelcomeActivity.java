package scu.miomin.com.shareward.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.base.NoneToolbarActivity;
import scu.miomin.com.shareward.constants.APPStatu;
import scu.miomin.com.shareward.core.AppStatusTracker;
import scu.miomin.com.shareward.sample.LoginActivity;

/**
 * Created by Miomin and Stay on 2/2/16.
 */
public class WelcomeActivity extends NoneToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 将APP状态置为已正常启动
        AppStatusTracker.getInstance(getApplication()).setAppStatus(APPStatu.STATUS_ONLINE);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        setContentView(R.layout.activity_welcome);
        handler.sendEmptyMessageDelayed(0, 1000);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
            finish();
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeMessages(0);
    }
}
