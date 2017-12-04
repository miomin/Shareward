package com.miomin.taobao.samplecalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  EditText et_x;
  EditText et_y;
  Button btn_add;
  TextView tv_result;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    et_x = findViewById(R.id.et_x);
    et_y = findViewById(R.id.et_y);
    btn_add = findViewById(R.id.btn_Add);
    tv_result = findViewById(R.id.tv_result);

    btn_add.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int x = Integer.parseInt(et_x.getText().toString());
        int y = Integer.parseInt(et_y.getText().toString());
        int result = x + y;
        tv_result.setText(result + "");
      }
    });
  }
}
