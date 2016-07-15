package scu.miomin.com.shareward.sample.network;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.base.toolbar.ToolbarActivity;
import scu.miomin.com.shareward.constants.ActivityType;
import scu.miomin.com.shareward.core.ShareApplication;
import scu.miomin.com.shareward.http.network.ApiRequests;
import scu.miomin.com.shareward.http.network.GsonGetRequest;
import scu.miomin.com.shareward.sample.dataModel.DummyObject;

/**
 * Demonstrates how to make a JSON Object request
 */
public class SampleJSONObjectActivity extends ToolbarActivity {

    private static final String TAG = "SampleJSONObjectActivity";

    private TextView mTitle, mBody;
    private ProgressBar mProgressBar;
    private LinearLayout mContent, mErrorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_json_object_request, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mTitle = (TextView) findViewById(R.id.my_title);
        mBody = (TextView) findViewById(R.id.my_body);
        mBody.setMovementMethod(new ScrollingMovementMethod());
        mErrorView = (LinearLayout) findViewById(R.id.error_view);
        mContent = (LinearLayout) findViewById(R.id.content);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        sendHttp();
    }

    private void sendHttp() {
        final GsonGetRequest<DummyObject> gsonGetRequest =
                ApiRequests.getDummyObject
                        (
                                new Response.Listener<DummyObject>() {
                                    @Override
                                    public void onResponse(DummyObject dummyObject) {
                                        // Deal with the DummyObject here
                                        mProgressBar.setVisibility(View.GONE);
                                        mContent.setVisibility(View.VISIBLE);
                                        setResultData(dummyObject);
                                    }
                                }
                                ,
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        // Deal with the error here
                                        mProgressBar.setVisibility(View.GONE);
                                        mErrorView.setVisibility(View.VISIBLE);
                                    }
                                }
                        );

        ShareApplication.addRequest(gsonGetRequest, TAG);
    }

    @Override
    protected void onStop() {
        ShareApplication.cancelAllRequests(TAG);
        super.onStop();
    }

    /**
     * Sets the data in the UI
     *
     * @param dummyObject is the object to get the data from
     */
    private void setResultData(@NonNull final DummyObject dummyObject) {
        mTitle.setText(dummyObject.getTitle());
        mBody.setText(dummyObject.getBody());
    }
}
