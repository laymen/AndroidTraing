package com.homework.dday3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.homework.dday2.R;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
public class UserActivity extends Activity {
    private  UserDao dao;
    private EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_main);
        dao=new UserDao(this);
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);

    }
    public  void click(View v){
        switch (v.getId()){
            case R.id.save:
                User u=new User();
                u.setName(name.getText().toString());
                u.setAge(Integer.valueOf(age.getText().toString()) );
                dao.addUser(u);
                break;

        }

    }
}
