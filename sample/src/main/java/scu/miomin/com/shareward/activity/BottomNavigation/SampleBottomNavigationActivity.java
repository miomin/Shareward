package scu.miomin.com.shareward.activity.BottomNavigation;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;
import com.scu.miomin.sharewardlib.constants.ActivityType;
import com.scu.miomin.sharewardlib.toolbar.ToolbarActivity;

import scu.miomin.com.shareward.R;

public class SampleBottomNavigationActivity extends ToolbarActivity {

    private com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView bottomNavigationView;
    private TextView textView;
    private Button button;

    int[] image = {R.drawable.ic_mic_black_24dp, R.drawable.ic_favorite_black_24dp,
            R.drawable.ic_book_black_24dp, R.drawable.ic_github_circle_24dp};

    @Override
    protected void getContentView() {
        setContentView(R.layout.activity_bottom_navigation, ActivityType.MODE_TOOLBAR_BACK);
    }

    @Override
    protected void setUpView() {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        bottomNavigationView = (com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView) findViewById(R.id.bottomNavigation);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {
        if (bottomNavigationView != null) {
            bottomNavigationView.isWithText(true);
            bottomNavigationView.isColoredBackground(false);
            bottomNavigationView.setTextActiveSize(40);
            bottomNavigationView.setTextInactiveSize(36);
            bottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.colorPrimary));
//            bottomNavigationView.setFont(Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Noh_normal.ttf"));
        }

        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem
                ("Record", R.color.colorPrimary, image[0]);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                ("Like", R.color.colorPrimary, image[1]);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem
                ("Books", R.color.colorPrimary, image[2]);
        BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem
                ("GitHub", R.color.colorPrimary, image[3]);


        bottomNavigationView.addTab(bottomNavigationItem);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.addTab(bottomNavigationItem2);
        bottomNavigationView.addTab(bottomNavigationItem3);

        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                switch (index) {
                    case 0:
                        textView.setText("Record");
                        break;
                    case 1:
                        textView.setText("Like");
                        break;
                    case 2:
                        textView.setText("Books");
                        break;
                    case 3:
                        textView.setText("GitHub");
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.selectTab(2);
            }
        });
    }
}
