package scu.miomin.com.shareward.activity.rxjavamvp.hellorx;

import android.os.Bundle;
import android.widget.Toast;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.toolbar.ToolbarActivity;

public class HelloRxJavaActivity extends ToolbarActivity {

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_hello_rx_java);
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

        Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Hello RxJava");
                        subscriber.onCompleted();
                    }
                })
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + "-Miomin";
                    }
                })
                .map(new Func1<String, Integer>() {
                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer s) {
                        Toast.makeText(HelloRxJavaActivity.this, Integer.toString(s), Toast.LENGTH_SHORT).show();
                    }
                });

        // 如果只发出一个时间可以用just
//        Observable<String> myObservable = Observable.just("Hello RxJava");
    }
}
