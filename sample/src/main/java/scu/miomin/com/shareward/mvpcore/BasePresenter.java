package scu.miomin.com.shareward.mvpcore;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by miomin on 2016/11/14.
 */
public abstract class BasePresenter<V extends IBaseView> {

    /**
     * Presenter需要持有View引用，用于通知Activity更新UI
     */
    public V mvpView;

    /**
     * RxJava的Subscribe池子
     */
    private CompositeSubscription mCompositeSubscription;

    /**
     * 生命周期开始，创建出View
     * @param mvpView
     */
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    /**
     * 生命周期结束，View被销毁
     */
    public void detachView() {
        this.mvpView = null;
        /**
         * 需要销毁RxJava的生命周期
         */
        onUnsubscribe();
    }

    /**
     * RXjava取消注册，以避免内存泄露
     */
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    /**
     * 添加一个RxJava的subscriber
     * @param observable
     * @param subscriber
     */
    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
