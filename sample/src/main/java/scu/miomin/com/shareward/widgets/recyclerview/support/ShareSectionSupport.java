package scu.miomin.com.shareward.widgets.recyclerview.support;

/**
 * Created by 莫绪旻 on 16/6/24.
 */
public interface ShareSectionSupport<T> {
    public int sectionHeaderLayoutId();

    public int sectionTitleTextViewId();

    public String getTitle(T t);
}
