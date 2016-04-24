package scu.miomin.com.shareward.home;

import android.content.Intent;
import android.widget.Button;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.APPAction;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.core.BaseActivity;


/**
 * Created by Miomin and Stay on 2/2/16.
 */
public class HomeActivity extends BaseActivity {

    private Button mHomeProfileBtn;

    /**
     * 代替onCreate
     */
    @Override
    protected void setUpData() {
        setContentView(R.layout.activity_home, ActivityType.MODE_TOOLBAR_BACK);
        mHomeProfileBtn = (Button) findViewById(R.id.mHomeProfileBtn);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int action = intent.getIntExtra(APPAction.KEY_HOME_ACTION, APPAction.ACTION_BACK_TO_HOME);
        switch (action) {
            case APPAction.ACTION_KICK_OUT:
                break;
            case APPAction.ACTION_LOGOUT:
                break;
            case APPAction.ACTION_RESTART_APP:
                protectApp();
                break;
            case APPAction.ACTION_BACK_TO_HOME:
                break;
        }
    }
}
