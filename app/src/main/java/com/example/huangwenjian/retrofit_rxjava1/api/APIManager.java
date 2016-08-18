package com.example.huangwenjian.retrofit_rxjava1.api;

import android.content.Context;

import com.example.huangwenjian.retrofit_rxjava1.utils.DialogUtils;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.components.RxActivity;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by huangwenjian on 16/8/17.
 */
public class APIManager {
    /**
     * @param observable getWeather()的返回值
     * @param activity
     * @param next      处理请求成功的方法
     * @param error     处理请求失败的方法
     * @param <T>
     */
    public static <T> void doApi(Observable<T> observable, final RxActivity activity, Action1<T> next, Action1<Throwable> error) {

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(activity.<T>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(next, error, () -> onComplete());             //完整的写法
    }

    private static void onComplete() {
        DialogUtils.hideDialog();
    }

    private static <T> T filterResult(T t, Context context) {
        T result = (T) t;
        return result;
    }
}
