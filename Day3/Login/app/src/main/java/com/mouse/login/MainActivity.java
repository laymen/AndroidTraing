package com.mouse.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText usrname;
    private EditText password;

    private String name;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usrname = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.pwd);

    }

    public void click(View v) {
        name = usrname.getText().toString();
        if (SharedPreferencesUtils.getString(getApplication(), "name", "").equals(name)) {//存在
            password.setText(SharedPreferencesUtils.getString(getApplication(), "pwd", ""));
        } else {
            if (!password.getText().toString().equals("")) {
                SharedPreferencesUtils.putString(getApplication(), "name", name);
                SharedPreferencesUtils.putString(getApplication(), "pwd", password.getText().toString());
            }
        }


    }
}
