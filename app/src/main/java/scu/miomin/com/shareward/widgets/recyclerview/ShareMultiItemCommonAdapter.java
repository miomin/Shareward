package scu.miomin.com.shareward.widgets.recyclerview;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

import scu.miomin.com.shareward.widgets.recyclerview.holder.ShareViewHolder;

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
