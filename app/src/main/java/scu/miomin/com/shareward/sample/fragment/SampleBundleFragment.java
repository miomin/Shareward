package scu.miomin.com.shareward.sample.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.core.BaseFragment;

/**
 * Created by 莫绪旻 on 16/2/29.
 */
public class SampleBundleFragment extends BaseFragment {

    // fragment的布局
    private ProgressDialog dialog;
    private Button btn_query;

    private String title;

    public static SampleBundleFragment newInstance(String title) {
        SampleBundleFragment fragment = new SampleBundleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("title");
    }

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    protected void setUpView() {
        btn_query = (Button) fragmentView.findViewById(R.id.btn_query);
    }

    @Override
    protected void setUpData() {
        dialog = new ProgressDialog(getActivity());
        dialog.setMessage(getResources().getString(R.string.app_name));

        btn_query.setText(title);
        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
            }
        });
    }

    public void query() {
        dialog.show();
        dialog.dismiss();
    }
}
