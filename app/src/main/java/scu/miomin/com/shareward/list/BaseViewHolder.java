package scu.miomin.com.shareward.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by miomin on 16/6/5.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBindData(int position);
}
