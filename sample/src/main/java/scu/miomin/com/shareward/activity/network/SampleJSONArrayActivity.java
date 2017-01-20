package scu.miomin.com.shareward.activity.network;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.toolbar.ToolbarActivity;

/**
 * Demonstrates how to make a JSON Object request
 */
public class SampleJSONArrayActivity extends ToolbarActivity {

    private static final String TAG = "SampleJSONArrayActivity";

    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;
    private TextView mTitle, mBody, mSecondTitle, mSecondBody;

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_json_array_request, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTitle = (TextView) findViewById(R.id.my_title);
        mBody = (TextView) findViewById(R.id.my_body);
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mSecondTitle = (TextView) findViewById(R.id.my_title_2);
        mSecondBody = (TextView) findViewById(R.id.my_body_2);
        mSecondBody.setMovementMethod(new ScrollingMovementMethod());
        mErrorView = (LinearLayout) findViewById(R.id.error_view);
        mContent = (LinearLayout) findViewById(R.id.content);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }
}
