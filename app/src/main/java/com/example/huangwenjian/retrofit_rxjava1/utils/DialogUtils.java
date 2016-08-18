package com.example.huangwenjian.retrofit_rxjava1.utils;

import android.content.Context;

import com.example.huangwenjian.retrofit_rxjava1.R;
import com.example.huangwenjian.retrofit_rxjava1.dialog.CustomDialog;

/**
 * Created by huangwenjian on 2016/8/17.
 */
public class DialogUtils {

    private static CustomDialog mDialog;

    public static void showDialog(Context context, int layoutId) {
        mDialog = new CustomDialog(context, layoutId);
        mDialog.show();
    }

    public static void hideDialog() {
        mDialog.dismiss();
        mDialog = null;
    }

    /**
     * 展示loading对话框
     *
     * @param context
     */
    public static void showLoading(Context context) {
        mDialog = new CustomDialog(context, R.layout.dialog_custom);
        mDialog.show();
    }

    /**
     * 隐藏loading对话框
     */
    public static void hideLoading() {
        mDialog.dismiss();
        mDialog = null;
    }
}
