package com.miomin.taobao.samplemoveimage;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

  ImageView img;
  Button btnMoveLeft;
  Button btnMoveRight;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    img = findViewById(R.id.img);
    btnMoveLeft = findViewById(R.id.btnMoveLeft);
    btnMoveRight = findViewById(R.id.btnMoveRight);

    btnMoveLeft.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screen_width = size.x;
        int screen_height = size.y;

        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) img.getLayoutParams();
        if (lp.leftMargin - 5 > 0) {
          lp.leftMargin -= 5;
          img.setLayoutParams(lp);
        }
      }
    });

    btnMoveRight.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screen_width = size.x;
        int screen_height = size.y;

        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) img.getLayoutParams();
        if (lp.leftMargin + 5 > screen_width - lp.width) {
          lp.leftMargin += 5;
          img.setLayoutParams(lp);
        }
      }
    });
  }
}
