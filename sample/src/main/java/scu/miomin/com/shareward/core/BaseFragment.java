package scu.miomin.com.shareward.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 莫绪旻 on 22/10/15.
 */
public abstract class BaseFragment extends Fragment {

    public Activity mActivity;
    private CompositeSubscription mCompositeSubscription;

    // fragment的布局
    protected View fragmentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 获取Fragment的布局
        fragmentView = getContentView(inflater, container);
        setUpView();
        setUpData();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mActivity = getActivity();
    }

    public void toastShow(int resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }

    public void toastShow(String resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        onUnsubscribe();
    }

    public void onUnsubscribe() {
        //取消注册，以避免内存泄露
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Subscription subscription) {
        mCompositeSubscription = new CompositeSubscription();
        mCompositeSubscription.add(subscription);
    }

    protected abstract View getContentView(LayoutInflater inflater, ViewGroup container);

    protected abstract void setUpView();

    protected abstract void setUpData();
}
