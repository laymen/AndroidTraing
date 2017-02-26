package com.mouse.car;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class FirstActivity extends AppCompatActivity {
    private Spinner spinner1;
    private ArrayAdapter adapter;
    private String[] data={"北京","上海","广州","深圳","成都","郑州","湖北"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_main);
        spinner1=(Spinner)findViewById(R.id.spinner1);
        adapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,data);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(FirstActivity.this, "你点击的是:" + data[position], Toast.LENGTH_SHORT).show();
                //跳转到下一个activity
                Intent intent=new Intent(getApplication(),SecondActivity.class);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
