package scu.miomin.com.shareward.activity.rxjavamvp.retrofit.http;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import scu.miomin.com.shareward.activity.rxjavamvp.retrofit.module.DBMovieEntity;

/**
 * Created by miomin on 16/11/12.
 */

public interface DBMovieService {

    public String url = "https://api.douban.com/v2/movie/";

    @GET("top250")
    Observable<DBHttpResult<List<DBMovieEntity>>> getTopMovie(@Query("start") int start, @Query("count") int count);
}
