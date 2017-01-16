package scu.miomin.com.shareward.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.activity.recyclerview.SampleListSplashActivity;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.toolbar.ToolbarActivity;


/**
 * Created by 莫绪旻 on 2/2/16.
 */
public class LoginActivity extends ToolbarActivity implements View.OnClickListener {

    private FloatingActionButton fab;

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_login, ActivityType.MODE_TOOLBAR);
    }

    @Override
    protected void setUpView() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        setUpTitle("登录");
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, SampleListSplashActivity.class));
    }
}
