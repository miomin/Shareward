package scu.miomin.com.shareward.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.base.ToolbarActivity;
import scu.miomin.com.shareward.constants.ActivityType;


/**
 * Created by Miomin and Stay on 2/2/16.
 */
public class LoginActivity extends ToolbarActivity implements View.OnClickListener {

    private Button mLoginSubmitBtn;

    @Override
    protected void setUpView() {
        setContentView(R.layout.activity_login, ActivityType.MODE_TOOLBAR);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        setUpTitle("登录");
        mLoginSubmitBtn = (Button) findViewById(R.id.mLoginSubmitBtn);
        mLoginSubmitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, SampleTabActivity.class));
    }
}
