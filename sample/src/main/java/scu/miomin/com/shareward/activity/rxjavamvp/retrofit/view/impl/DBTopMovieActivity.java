package scu.miomin.com.shareward.activity.rxjavamvp.retrofit.view.impl;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.activity.rxjavamvp.retrofit.presenter.impl.TopMoviePresenter;
import scu.miomin.com.shareward.activity.rxjavamvp.retrofit.view.interf.IDBTopMovieView;
import scu.miomin.com.shareward.mvpcore.BaseToolbarMvpActivity;

public class DBTopMovieActivity extends BaseToolbarMvpActivity<TopMoviePresenter> implements IDBTopMovieView {

    @Bind(R.id.btn)
    Button btnClick;

    @Bind(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    @Override
    public void setText(String result) {
        tvResult.setText(result);
    }

    @Override
    protected TopMoviePresenter createPresenter() {
        return new TopMoviePresenter(this);
    }

    @OnClick(R.id.btn)
    public void onBtnClick() {
        mvpPresenter.getTopMovie(0, 10);
    }
}
