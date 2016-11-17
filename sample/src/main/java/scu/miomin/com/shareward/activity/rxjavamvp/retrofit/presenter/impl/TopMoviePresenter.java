package scu.miomin.com.shareward.activity.rxjavamvp.retrofit.presenter.impl;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;

import rx.Subscriber;
import scu.miomin.com.shareward.activity.rxjavamvp.retrofit.http.DBHttpMethods;
import scu.miomin.com.shareward.activity.rxjavamvp.retrofit.module.DBMovieEntity;
import scu.miomin.com.shareward.activity.rxjavamvp.retrofit.presenter.interf.ITopMoviePresenter;
import scu.miomin.com.shareward.activity.rxjavamvp.retrofit.view.interf.IDBTopMovieView;
import scu.miomin.com.shareward.mvpcore.BasePresenter;

/**
 * Created by miomin on 16/11/16.
 */

public class TopMoviePresenter extends BasePresenter<IDBTopMovieView> implements ITopMoviePresenter {

    public TopMoviePresenter(IDBTopMovieView dbTopMovieView) {
        attachView(dbTopMovieView);
    }

    @Override
    public void getTopMovie(int start, int count) {
        mvpView.showLoading("请稍后", "正在加载中...");

        Subscriber<List<DBMovieEntity>> getTopMovieSubscriber = new Subscriber<List<DBMovieEntity>>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
                mvpView.showToast("Get Top Movie Completed");
                mvpView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                if (e instanceof SocketTimeoutException) {
                    mvpView.showToast("网络中断，请检查您的网络状态");
                } else if (e instanceof ConnectException) {
                    mvpView.showToast("网络中断，请检查您的网络状态");
                } else {
                    mvpView.showToast("error:" + e.getMessage());
                }
                mvpView.hideLoading();
            }

            @Override
            public void onNext(List<DBMovieEntity> httpResult) {
                mvpView.setText(httpResult.toString());
            }
        };

        addSubscription(DBHttpMethods.getInstance().getTopMovie(0, 10), getTopMovieSubscriber);
    }
}
