package com.scu.miomin.sharewardlib.widgets.recyclerview;

import android.content.Context;
import android.view.ViewGroup;

import com.scu.miomin.sharewardlib.widgets.recyclerview.holder.ShareViewHolder;

import java.util.List;


/**
 * Created by 莫绪旻 on 16/6/24.
 */
public abstract class ShareMultiItemCommonAdapter<T> extends ShareCommonAdapter<T> {

    protected ShareMultiItemTypeSupport<T> mMultiItemTypeSupport;

    public ShareMultiItemCommonAdapter(Context context, List<T> datas,
                                       ShareMultiItemTypeSupport<T> multiItemTypeSupport) {
        super(context, -1, datas);
        mMultiItemTypeSupport = multiItemTypeSupport;
    }

    @Override
    public int getItemViewType(int position) {
        return mMultiItemTypeSupport.getItemViewType(position, mDatas.get(position));
    }

    @Override
    public ShareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = mMultiItemTypeSupport.getLayoutId(viewType);
        ShareViewHolder holder = ShareViewHolder.get(mContext, null, parent, layoutId, -1);
        setListener(parent, holder, viewType);
        return holder;
    }
}
