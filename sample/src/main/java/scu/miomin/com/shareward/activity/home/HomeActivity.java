package scu.miomin.com.shareward.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.APPAction;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.toolbar.ToolbarActivity;


/**
 * Created by 莫绪旻 and Stay on 2/2/16.
 */
public class HomeActivity extends ToolbarActivity {

    private Button mHomeProfileBtn;

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_home, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        mHomeProfileBtn = (Button) findViewById(R.id.mHomeProfileBtn);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        
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
