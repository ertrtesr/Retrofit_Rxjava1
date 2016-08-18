package com.example.huangwenjian.retrofit_rxjava1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.huangwenjian.retrofit_rxjava1.api.API;
import com.example.huangwenjian.retrofit_rxjava1.api.APIManager;
import com.example.huangwenjian.retrofit_rxjava1.bean.WeatherBean;
import com.example.huangwenjian.retrofit_rxjava1.utils.DialogUtils;
import com.trello.rxlifecycle.components.RxActivity;

public class MainActivity extends RxActivity {

    private Button mBtn_weather;
    private TextView mTv_city;
    private Button mBtn_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        mBtn_weather = (Button) findViewById(R.id.btn_weather);
        mTv_city = (TextView) findViewById(R.id.tv_city);
        mBtn_dialog = (Button) findViewById(R.id.btn_dialog);
    }

    private void initListener() {
        mBtn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APIManager.doApi(API.getWeather(), MainActivity.this, bean -> refreshUI(bean), e -> onError());
            }
        });

        mBtn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtils.showDialog(MainActivity.this, R.layout.dialog_custom);
            }
        });
    }

    /**
     * 网络请求成功成功时调用,刷新界面
     *
     * @param weatherBean
     */
    private void refreshUI(WeatherBean weatherBean) {
        mTv_city.setText(weatherBean.weatherinfo.city);
    }

    /**
     * 网络请求失败时调用,展示失败的界面
     */
    private void onError() {

    }
}
