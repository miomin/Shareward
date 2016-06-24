package scu.miomin.com.shareward.widgets.recyclerview;

public interface ShareMultiItemTypeSupport<T> {
    int getLayoutId(int itemType);

    int getItemViewType(int position, T t);
}