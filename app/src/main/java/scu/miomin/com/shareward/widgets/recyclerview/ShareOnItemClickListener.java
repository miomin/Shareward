package scu.miomin.com.shareward.widgets.recyclerview;

import android.view.View;
import android.view.ViewGroup;

public interface ShareOnItemClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);

    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}