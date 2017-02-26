package com.homework.dday3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.homework.dday2.R;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
public class SharedPreferencesDemo extends Activity {
    private EditText name;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharepre_main);
        name=(EditText)findViewById(R.id.edit);
        tv=(TextView)findViewById(R.id.tv);
//        getAssets().

    }

    public void click(View v){
        switch (v.getId()){
            case R.id.save:
                SharedPreferences preferences=this.getSharedPreferences("preferences",MODE_WORLD_READABLE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("mouse","laymen"); //key-value
                editor.commit();
                break;
            case R.id.read:
                SharedPreferences preference=this.getSharedPreferences("preferences",MODE_WORLD_READABLE);
                String name=preference.getString("mouse","").toString();
                tv.setText(name);
                break;
            default:
        }

    }
}
