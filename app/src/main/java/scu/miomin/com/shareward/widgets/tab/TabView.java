package scu.miomin.com.shareward.widgets.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import scu.miomin.com.shareward.R;

/**
 * Created by miomin on 16/4/25.
 */
public class TabView extends LinearLayout implements View.OnClickListener {

    private ImageView mTabImg;
    private TextView mTabLabel;

    public TabView(Context context) {
        super(context);
        setView(context);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setView(context);

    }

    public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView(context);
    }

    private void setView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_tab_view, this, true);
        setOrientation(VERTICAL);
        mTabImg = (ImageView) findViewById(R.id.mTabImg);
        mTabLabel = (TextView) findViewById(R.id.mTabLabel);

        setOnClickListener(this);
    }

    public void setUpData(Tab tab) {
        mTabImg.setBackgroundResource(tab.imgResId);
        mTabLabel.setText(tab.labelResId);
    }

    @Override
    public void onClick(View v) {

    }

    public static class Tab {
        public int imgResId;
        public int labelResId;
        public int badgeCount;

        public Tab(int imgResId, int labelResId) {
            this.imgResId = imgResId;
            this.labelResId = labelResId;
        }

        public Tab(int badgeCount, int imgResId, int labelResId) {
            this.badgeCount = badgeCount;
            this.imgResId = imgResId;
            this.labelResId = labelResId;
        }
    }
}
