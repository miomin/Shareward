package scu.miomin.com.shareward.widgets.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import scu.miomin.com.shareward.R;

/**
 * Created by miomin on 16/4/25.
 */
public class TabLayout extends LinearLayout {

    private ArrayList<TabView.Tab> tabs;
    private OnTabClickListener onTabClickListener;

    public TabLayout(Context context) {
        super(context);
        setView(context);
    }

    public TabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setView(context);
    }

    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView(context);
    }

    private void setView(Context context) {
        setOrientation(HORIZONTAL);
        setBackgroundResource(R.color.whiteLight);
    }

    public void setUpData(ArrayList<TabView.Tab> tabs, final OnTabClickListener onTabClickListener) {

        this.tabs = tabs;
        this.onTabClickListener = onTabClickListener;

        if (tabs != null && tabs.size() > 0) {
            TabView tabView = null;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            params.weight = 1;
            for (int i = 0; i < tabs.size(); i++) {
                tabView = new TabView(getContext());
                tabView.setTag(i);
                tabView.setUpData(tabs.get(i));
                tabView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onTabClickListener.onTabClick((Integer) v.getTag());
                    }
                });
                addView(tabView, params);
            }
        } else {
            throw new IllegalArgumentException("tabs can't be empty");
        }
    }

    public interface OnTabClickListener {
        void onTabClick(int index);
    }
}
