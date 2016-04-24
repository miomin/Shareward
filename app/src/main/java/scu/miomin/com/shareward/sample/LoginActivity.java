package scu.miomin.com.shareward.sample;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.core.BaseActivity;
import scu.miomin.com.shareward.home.HomeActivity;


/**
 * Created by Miomin and Stay on 2/2/16.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private Button mLoginSubmitBtn;

    @Override
    protected void setUpData() {
        setContentView(R.layout.activity_login, ActivityType.MODE_TOOLBAR);
        mLoginSubmitBtn = (Button) findViewById(R.id.mLoginSubmitBtn);
        mLoginSubmitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        AppStatusTracker.getInstance().setAppStatus(APPAction.STATUS_ONLINE);
        startActivity(new Intent(this, HomeActivity.class));
    }
}
