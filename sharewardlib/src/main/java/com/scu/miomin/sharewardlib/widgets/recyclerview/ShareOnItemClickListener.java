package com.scu.miomin.sharewardlib.widgets.recyclerview;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 莫绪旻 on 16/6/24.
 */
public interface ShareOnItemClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);

    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}