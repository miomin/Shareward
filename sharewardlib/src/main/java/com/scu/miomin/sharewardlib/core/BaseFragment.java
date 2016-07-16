package com.scu.miomin.sharewardlib.core;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 莫绪旻 on 22/10/15.
 */
public abstract class BaseFragment extends Fragment {

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

    protected abstract View getContentView(LayoutInflater inflater, ViewGroup container);

    protected abstract void setUpView();

    protected abstract void setUpData();
}
