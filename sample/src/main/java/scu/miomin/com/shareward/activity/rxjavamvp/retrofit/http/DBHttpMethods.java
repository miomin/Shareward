package scu.miomin.com.shareward.activity.rxjavamvp.retrofit.http;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import scu.miomin.com.shareward.activity.rxjavamvp.retrofit.module.DBMovieEntity;

/**
 * Created by liukun on 16/3/9.
 */
public class DBHttpMethods {

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private DBMovieService movieService;

    private static DBHttpMethods INSTANCE;

    //构造方法私有
    private DBHttpMethods() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(DBMovieService.url)
                .build();

        movieService = retrofit.create(DBMovieService.class);
    }

    //获取单例
    public static DBHttpMethods getInstance() {

        if (INSTANCE == null) {
            synchronized (DBHttpMethods.class) {
                if (INSTANCE == null)
                    INSTANCE = new DBHttpMethods();
            }
        }

        return INSTANCE;
    }

    /**
     * 用于获取豆瓣电影Top250的数据
     *
     * @param start 起始位置
     * @param count 获取长度
     */
    public Observable<List<DBMovieEntity>> getTopMovie(int start, int count) {

        return movieService.getTopMovie(start, count)
                .map(new HttpResultFunc<List<DBMovieEntity>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    private class HttpResultFunc<T> implements Func1<DBHttpResult<T>, T> {

        @Override
        public T call(DBHttpResult<T> httpResult) {
            if (httpResult.getCount() == 0) {
                throw new DBApiException(100);
            }
            return httpResult.getSubjects();
        }
    }

}
