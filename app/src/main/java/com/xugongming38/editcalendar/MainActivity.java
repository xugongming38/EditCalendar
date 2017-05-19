package com.xugongming38.editcalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.xugongming38.editcalendar.utils.DataHelper;
import com.xugongming38.editcalendar.view.CalendarView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTextSelectMonth;
    private ImageButton mLastMonthView;
    private ImageButton mNextMonthView;
    private CalendarView mCalendarView;

    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initData();

        mCalendarView.setSelectedDates(mDatas);//选择的时间

        mTextSelectMonth.setText(mCalendarView.getDate());

        /*测试View中的performClick()作用，即为除了对onTouchEvent事件的响应
        也可以同时处理view自带的setOnClickListener
        否则，对setOnClickListener没效果
        此处有关触摸事件的传递问题需要另外学习
         */

        /*mCalendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    private void initData() {
        mDatas= DataHelper.getDataList(this);
    }

    private void findViews() {
        mTextSelectMonth = (TextView) findViewById(R.id.txt_select_month);
        mLastMonthView = (ImageButton) findViewById(R.id.img_select_last_month);
        mNextMonthView = (ImageButton) findViewById(R.id.img_select_next_month);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mLastMonthView.setOnClickListener(this);
        mNextMonthView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_select_last_month:
                mCalendarView.setLastMonth();
                mTextSelectMonth.setText(mCalendarView.getDate());
                break;
            case R.id.img_select_next_month:
                mCalendarView.setNextMonth();
                mTextSelectMonth.setText(mCalendarView.getDate());
                break;
        }
    }
}
