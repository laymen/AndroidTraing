package com.mouse.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mouse on 2017/2/21.
 */
public class ThridActivty extends AppCompatActivity {
    private ListView lv;
    private  List<Car>data;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_main);

        lv=(ListView)findViewById(R.id.lv);
        data=new ArrayList<>();
        Car car=new Car();
        car.setCarname("车1");
        car.setIncon(R.drawable.asidun1);
        data.add(car);

        Car car2=new Car();
        car2.setCarname("车2");
        car2.setIncon(R.drawable.asidun2);
        data.add(car2);

        Car car3=new Car();
        car3.setCarname("车3");
        car3.setIncon(R.drawable.asidun3);
        data.add(car3);

        Car car4=new Car();
        car4.setCarname("车4");
        car4.setIncon(R.drawable.asidun4);
        data.add(car4);

        Car car5=new Car();
        car5.setCarname("车5");
        car5.setIncon(R.drawable.asidun5);
        data.add(car5);

        Car car6=new Car();
        car6.setCarname("车6");
        car6.setIncon(R.drawable.asidun6);
        data.add(car6);

        myAdapter=new MyAdapter(this,data);
        lv.setAdapter(myAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplication(),ForthActivity.class);
                intent.putExtra("kind",position+1);
                startActivity(intent);

            }
        });
    }


}
