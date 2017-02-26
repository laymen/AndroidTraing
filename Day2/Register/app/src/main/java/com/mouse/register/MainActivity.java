package com.mouse.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText account;//用户名
    private EditText pwd;//密码
    private RadioGroup groupSex;//性别

    private List<CheckBox> checkBoxList = new ArrayList<CheckBox>();
    private CheckBox checkBox_ball;//打球
    private CheckBox checkBox_sing;//唱歌
    private CheckBox checkBox_dance;//跳舞

    private Button button_Register;

    //临时存放信息
    private String sex;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//初始化控件
        account=(EditText)findViewById(R.id.account);
        pwd=(EditText)findViewById(R.id.pwd);
        button_Register=(Button)findViewById(R.id.login);




        groupSex=(RadioGroup)findViewById(R.id.sex);
        groupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //获取变更后的选择中的id
                int radioButton=group.getCheckedRadioButtonId();
                //根据id获得RadioButton的实例
                RadioButton rb=(RadioButton)MainActivity.this.findViewById(radioButton);
               // Toast.makeText(getApplication(),rb.getText()+"",Toast.LENGTH_SHORT).show();
                sex=rb.getText().toString();
            }
        });

        //初始化checkBox控件
        checkBox_ball=(CheckBox)findViewById(R.id.checkBox_ball);
        checkBox_sing=(CheckBox)findViewById(R.id.checkBox_sing);
        checkBox_dance=(CheckBox)findViewById(R.id.checkBox_dance);
        //将所有的checkBox放进一个集合中
        checkBoxList.add(checkBox_ball);
        checkBoxList.add(checkBox_sing);
        checkBoxList.add(checkBox_dance);
        button_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb=new StringBuffer();
                //遍历集合中的checkBox，判断是否选择，获取选中的文本
                for (CheckBox checkbox:checkBoxList){
                    if(checkbox.isChecked())
                        sb.append(checkbox.getText().toString()+" ");
                }
                if(sb!=null&&"".equals(sb.toString())){
                    Toast.makeText(getApplicationContext(), "请至少选择一个爱好", Toast.LENGTH_SHORT).show();
                }else{
                    if (account.getText().toString()==null){
                        Toast.makeText(getApplicationContext(), "请填写用户名", Toast.LENGTH_SHORT).show();
                    }else if(pwd.getText().toString()==null){
                        Toast.makeText(getApplicationContext(), "请填写密码", Toast.LENGTH_SHORT).show();
                    }else if(sex==null){
                        Toast.makeText(getApplicationContext(), "请选择性别", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent=new Intent(getApplication(),SecondActivity.class);
                        Bundle bundle=new Bundle();
                        bundle.putString("username",account.getText().toString());
                        bundle.putString("password",pwd.getText().toString());
                        bundle.putString("sex",sex.toString());
                        bundle.putString("hobby",sb.toString());
                        intent.putExtras(bundle);
                        startActivity(intent);

                    }
                }
            }

        });


    }
}
