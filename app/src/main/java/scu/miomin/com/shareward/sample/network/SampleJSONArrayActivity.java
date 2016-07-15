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

import java.util.ArrayList;

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
        sendHttp();
    }

    private void sendHttp() {
        final GsonGetRequest<ArrayList<DummyObject>> gsonGetRequest =
                ApiRequests.getDummyObjectArray
                        (
                                new Response.Listener<ArrayList<DummyObject>>() {
                                    @Override
                                    public void onResponse(ArrayList<DummyObject> dummyObjectArrayList) {
                                        // Deal with the DummyObject here
                                        mProgressBar.setVisibility(View.GONE);
                                        mContent.setVisibility(View.VISIBLE);
                                        setResultData(dummyObjectArrayList);
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
     * @param dummyObjectArrayList is the object's array to get the data from
     */
    private void setResultData(@NonNull final ArrayList<DummyObject> dummyObjectArrayList) {
        mTitle.setText(dummyObjectArrayList.get(0).getTitle());
        mBody.setText(dummyObjectArrayList.get(0).getBody());
        mSecondTitle.setText(dummyObjectArrayList.get(1).getTitle());
        mSecondBody.setText(dummyObjectArrayList.get(1).getBody());
    }
}
