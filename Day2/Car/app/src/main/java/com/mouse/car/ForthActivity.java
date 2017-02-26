package com.mouse.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Mouse on 2017/2/21.
 */
public class ForthActivity  extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forth_main);
        tv=(TextView)findViewById(R.id.detail);
        Intent intent=getIntent();
        tv.setText("对第"+intent.getIntExtra("kind",0)+"的介绍");

    }
}
