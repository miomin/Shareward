package scu.miomin.com.shareward.activity.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.toolbar.ToolbarActivity;

/**
 * Created by 莫绪旻 on 16/6/24.
 */
public class SampleListSplashActivity extends ToolbarActivity implements View.OnClickListener {

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_list_splash, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        setUpTitle("SampleList");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Intent intent = new Intent(SampleListSplashActivity.this, SampleChatActivity.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                intent = new Intent(SampleListSplashActivity.this, SampleRecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn3:
                intent = new Intent(SampleListSplashActivity.this, SampleSectionRvActivity.class);
                startActivity(intent);
                break;
        }
    }
}
