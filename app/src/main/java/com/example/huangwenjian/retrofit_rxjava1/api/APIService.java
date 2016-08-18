package com.example.huangwenjian.retrofit_rxjava1.api;

import com.example.huangwenjian.retrofit_rxjava1.bean.WeatherBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by huangwenjian on 16/8/17.
 */
public interface APIService {
    /**
     * Rxjava的用法
     *
     * @return
     */
    @GET("data/cityinfo/101010100.html")
    Observable<WeatherBean> getWeather();
}
