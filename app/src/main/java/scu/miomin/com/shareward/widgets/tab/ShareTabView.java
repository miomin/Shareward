package scu.miomin.com.shareward.widgets.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import scu.miomin.com.shareward.R;
import scu.miomin.com.shareward.core.BaseFragment;

/**
 * Created by miomin on 16/4/25.
 */
public class ShareTabView extends LinearLayout {

    private ImageView mTabImg;
    private TextView mTabLabel;

    public ShareTabView(Context context) {
        super(context);
        setView(context);
    }

    public ShareTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setView(context);

    }

    public ShareTabView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView(context);
    }

    private void setView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.widget_tab_view, this, true);
        setOrientation(VERTICAL);
        mTabImg = (ImageView) findViewById(R.id.mTabImg);
        mTabLabel = (TextView) findViewById(R.id.mTabLabel);
    }

    public void setUpData(Tab tab) {
        mTabImg.setBackgroundResource(tab.imgResId);
        mTabLabel.setText(tab.labelResId);
    }

    public static class Tab {
        public int imgResId;
        public int labelResId;
        public int badgeCount;
        public Class<? extends BaseFragment> targetFragmentClz;

        public Tab(int imgResId, int labelResId, Class<? extends BaseFragment> targetFragmentClz) {
            this.imgResId = imgResId;
            this.labelResId = labelResId;
            this.targetFragmentClz = targetFragmentClz;
        }
    }
}
