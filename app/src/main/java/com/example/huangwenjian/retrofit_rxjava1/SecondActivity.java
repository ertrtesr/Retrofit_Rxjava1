package com.example.huangwenjian.retrofit_rxjava1;

import android.os.Bundle;
import android.widget.ListView;

import com.example.huangwenjian.retrofit_rxjava1.adapter.ItemAdapter;
import com.trello.rxlifecycle.components.RxActivity;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: huangwenjian
 * 描述:
 * 日期: 16/8/18
 */
@EActivity(R.layout.activity_second)
public class SecondActivity extends RxActivity {
    @ViewById(R.id.lv_first)
    ListView mLv_first;

    @ViewById(R.id.lv_second)
    ListView mLv_second;

    private List<String> mFirstList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void bindData() {
        for (int i = 0; i < 10; i++) {
            mFirstList.add(i + "");
        }
        mLv_first.setAdapter(new ItemAdapter<>(this, mFirstList, R.layout.item_list));
    }
}
