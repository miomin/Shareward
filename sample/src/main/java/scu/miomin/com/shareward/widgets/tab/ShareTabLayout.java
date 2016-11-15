package scu.miomin.com.shareward.widgets.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import scu.miomin.com.shareward.R;


/**
 * Created by 莫绪旻 on 16/4/25.
 */
public class ShareTabLayout extends LinearLayout implements View.OnClickListener {

    private ArrayList<ShareTabView.Tab> tabs;
    private OnTabClickListener onTabClickListener;
    private View selectView;
    private int tabCount;
    private int currentIndex;

    public ShareTabLayout(Context context) {
        super(context);
        setView(context);
    }

    public ShareTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setView(context);
    }

    public ShareTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView(context);
    }

    private void setView(Context context) {
        setOrientation(HORIZONTAL);
        setBackgroundResource(R.color.transparent);
    }

    public void setUpData(final ArrayList<ShareTabView.Tab> tabs, final OnTabClickListener onTabClickListener) {

        this.tabs = tabs;
        this.onTabClickListener = onTabClickListener;

        if (tabs != null && tabs.size() > 0) {
            tabCount = tabs.size();
            ShareTabView tabView = null;
            LayoutParams params = new LayoutParams(0, LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            params.weight = 1;
            for (int i = 0; i < tabs.size(); i++) {
                tabView = new ShareTabView(getContext());
                tabView.setTag(i);
                tabView.setUpData(tabs.get(i));
                tabView.setOnClickListener(this);
                addView(tabView, params);
            }
        } else {
            throw new IllegalArgumentException("tabs can't be empty");
        }
    }

    public void setCurrentTab(int i) {
        if (i < tabCount && i >= 0) {
            View view = getChildAt(i);
            onClick(view);
        }
    }

    @Override
    public void onClick(View v) {
        onTabClickListener.onTabSelected((Integer) v.getTag());

        if (currentIndex != (Integer) v.getTag())
            onTabClickListener.onTabChangeToUnSelected(currentIndex);

        currentIndex = (Integer) v.getTag();

        if (selectView != v) {
            v.setSelected(true);
            if (selectView != null) {
                selectView.setSelected(false);
            }
            selectView = v;
        }
    }

    public interface OnTabClickListener {

        /**
         * 监听切换到的tab
         */
        void onTabSelected(int index);

        /**
         * 监听被取消选中的tab
         */
        void onTabChangeToUnSelected(int index);
    }
}
