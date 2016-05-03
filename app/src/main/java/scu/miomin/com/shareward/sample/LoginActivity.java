package scu.miomin.com.shareward.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.base.toolbar.ToolbarActivity;
import scu.miomin.com.shareward.constants.ActivityType;


/**
 * Created by Miomin and Stay on 2/2/16.
 */
public class LoginActivity extends ToolbarActivity implements View.OnClickListener {

    private FloatingActionButton fab;

    @Override
    protected void setUpView() {
        setContentView(R.layout.activity_login, ActivityType.MODE_TOOLBAR);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        setUpTitle("登录");
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, SampleTabActivity.class));
    }
}
