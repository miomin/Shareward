package scu.miomin.com.shareward.widgets.recyclerview.support;

/**
 * Created by zhy on 16/4/9.
 */
public interface ShareSectionSupport<T> {
    public int sectionHeaderLayoutId();

    public int sectionTitleTextViewId();

    public String getTitle(T t);
}
