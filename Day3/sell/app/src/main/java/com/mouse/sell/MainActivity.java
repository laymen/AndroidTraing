package com.mouse.sell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText usrname;
    private EditText password;

    private String name;

    private GoodDao dao;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usrname = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.pwd);

        dao = new GoodDao(this);

        for (int i = 0; i < 20; i++) {
            Good g = new Good();
            g.setGname("米饭" + i);
            g.setGprice(100 + i);
            dao.addGood(g);
        }


    }

    //登录
    public void click(View v) {
        switch (v.getId()) {
            case R.id.login:
                Intent intent = new Intent(getApplication(), GoodActivity.class);
                startActivity(intent);
                break;

            case R.id.finish:
                name = usrname.getText().toString();
                if (SharedPreferencesUtils.getString(getApplication(), "name", "").equals(name)) {//存在
                    password.setText(SharedPreferencesUtils.getString(getApplication(), "pwd", ""));
                } else {
                    if (!password.getText().toString().equals("")) {
                        SharedPreferencesUtils.putString(getApplication(), "name", name);
                        SharedPreferencesUtils.putString(getApplication(), "pwd", password.getText().toString());
                    }
                }
                break;

        }
    }


}
