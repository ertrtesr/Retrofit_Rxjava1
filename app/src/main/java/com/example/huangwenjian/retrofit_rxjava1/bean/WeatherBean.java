package com.example.huangwenjian.retrofit_rxjava1.bean;

/**
 * Created by huangwenjian on 16/8/17.
 */
public class WeatherBean {
    public WeatherInfo weatherinfo;

    public class WeatherInfo {
        public String city;
        public String cityid;
        public String temp1;
        public String temp2;
        public String weather;
        public String img1;
        public String img2;
        public String ptime;
    }
}
