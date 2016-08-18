package com.example.huangwenjian.retrofit_rxjava1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.huangwenjian.retrofit_rxjava1.api.API;
import com.example.huangwenjian.retrofit_rxjava1.api.APIManager;
import com.example.huangwenjian.retrofit_rxjava1.bean.WeatherBean;
import com.example.huangwenjian.retrofit_rxjava1.utils.DialogUtils;
import com.trello.rxlifecycle.components.RxActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends RxActivity {

    @ViewById(R.id.btn_weather)
    Button mBtn_weather;

    @ViewById(R.id.tv_city)
    TextView mTv_city;

    @ViewById(R.id.btn_dialog)
    Button mBtn_dialog;

    @ViewById(R.id.btn_start)
    Button mBtn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click({R.id.btn_weather, R.id.btn_dialog, R.id.btn_start})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_weather:
                APIManager.doApi(API.getWeather(), MainActivity.this, bean -> refreshUI(bean), e -> onError());
                break;
            case R.id.btn_dialog:
                DialogUtils.showDialog(MainActivity.this, R.layout.dialog_custom);
                break;
            case R.id.btn_start:
                Intent intent = new Intent(MainActivity.this, SecondActivity_.class);
                startActivity(intent);
                break;
            default:
                break;
        }
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
