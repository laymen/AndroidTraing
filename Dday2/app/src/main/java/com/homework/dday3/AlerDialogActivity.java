package com.homework.dday3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.homework.dday2.R;

/**
 * Created by Administrator on 2017/2/22 0022.
 */
public class AlerDialogActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
    }

    public void click(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("mouse");

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //确定的事件
            }
        });
        builder.create();
        builder.show();

    }

    public void progess(View v) {


    }

    public void date(View v) {
        DatePickerDialog a = new DatePickerDialog(this, listener, 2013, Calendar.JANUARY, 1);
        a.show();

    }

    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


        }
    };
}
