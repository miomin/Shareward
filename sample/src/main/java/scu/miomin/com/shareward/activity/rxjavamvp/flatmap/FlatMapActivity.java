package scu.miomin.com.shareward.activity.rxjavamvp.flatmap;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.toolbar.ToolbarActivity;

public class FlatMapActivity extends ToolbarActivity {

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_flat_map);
    }

    @Override
    protected void setUpView() {

    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        query("Miomin")
                .flatMap(new Func1<List<String>, Observable<String>>() {
                    @Override
                    public Observable<String> call(List<String> urls) {
                        return Observable.from(urls);
                    }
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s != null && !s.equals("");
                    }
                })
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String s) {
                        return getTitle(s);
                    }
                })
                .take(5)
                .doOnNext(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        // 输出前做一些事
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Toast.makeText(FlatMapActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public Observable<List<String>> query(String text) {
        return Observable.create(new Observable.OnSubscribe<List<String>>() {
            @Override
            public void call(Subscriber<? super List<String>> subscriber) {
                List<String> list = new ArrayList<String>();
                list.add("1");
                list.add("2");
                list.add("");
                list.add(null);
                list.add("4");
                subscriber.onNext(list);
                subscriber.onCompleted();
            }
        });
    }

    public Observable<String> getTitle(final String text) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Title " + text);
                subscriber.onCompleted();
            }
        });
    }
}
