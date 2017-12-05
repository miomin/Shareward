package com.miomin.taobao.sampletouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final ImageView image = findViewById(R.id.img);

    final RelativeLayout.LayoutParams par
            = (RelativeLayout.LayoutParams) image.getLayoutParams();

    image.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
          case MotionEvent.ACTION_DOWN:
            break;

          case MotionEvent.ACTION_MOVE:
            int x_cord = (int) event.getRawX();
            int y_cord = (int) event.getRawY();
            par.leftMargin = x_cord - par.width / 2;
            par.topMargin = y_cord - par.height / 2;
            image.setLayoutParams(par);
            break;

          case MotionEvent.ACTION_CANCEL:
            break;
        }
        return true;
      }
    });
  }
}
