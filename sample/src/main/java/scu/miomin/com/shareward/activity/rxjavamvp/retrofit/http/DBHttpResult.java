package scu.miomin.com.shareward.activity.rxjavamvp.retrofit.http;

/**
 * Created by miomin on 16/11/12.
 */

public class DBHttpResult<T> {

    private int count;
    private int start;
    private int total;
    private String title;
    private T subjects;

    public T getSubjects() {
        return subjects;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "DBHttpResult{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
