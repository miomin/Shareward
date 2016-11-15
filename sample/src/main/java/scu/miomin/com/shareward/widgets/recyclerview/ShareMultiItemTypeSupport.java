package scu.miomin.com.shareward.widgets.recyclerview;

/**
 * Created by 莫绪旻 on 16/6/24.
 */
public interface ShareMultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}