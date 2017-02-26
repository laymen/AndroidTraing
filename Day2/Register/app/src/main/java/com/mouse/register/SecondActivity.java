package com.mouse.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Mouse on 2017/2/21.
 */
public class SecondActivity extends AppCompatActivity {
    private TextView username;
    private  TextView pwd;
    private TextView sex;
    private TextView hobby;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        //初始化控件
        username=(TextView)findViewById(R.id.first);
        pwd=(TextView)findViewById(R.id.second);
        sex=(TextView)findViewById(R.id.third);
        hobby=(TextView)findViewById(R.id.forth);

        Bundle bundle=this.getIntent().getExtras();
        username.setText("用户名 ："+bundle.getString("username"));
        pwd.setText("密码 ："+bundle.getString("password"));
        sex.setText("性别 :"+bundle.getString("sex"));
        hobby.setText("爱好："+bundle.getString("hobby"));

    }
}
