package com.example.huangwenjian.retrofit_rxjava1;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.huangwenjian.retrofit_rxjava1.adapter.ItemAdapter;
import com.trello.rxlifecycle.components.RxActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
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
    private List<String> mSecondList = new ArrayList<>();
    private String mFirstStr;           //第一列的第一个字符
    private ItemAdapter<Object> mFirstAdapter;
    private ItemAdapter<Object> mSecondAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 控件注入后的操作
     */
    @AfterViews
    void afterInjectView() {
        initData();
    }

    /**
     * 点击第一列的条目对应刷新第二列列表数据
     *
     * @param position
     */
    @ItemClick(R.id.lv_first)
    void itemClick(int position) {
        mFirstAdapter.setSelected(position);
        refreshSecond(position);
    }

    @ItemClick(R.id.lv_second)
    void itemclick(int position) {
        mSecondAdapter.setSelected(position);
    }

    /**
     * 刷新第二列
     *
     * @param position 第一列列表的点击位置
     */
    private void refreshSecond(int position) {
        mSecondList.clear();        //清空第二列的集合,重新添加
        for (int i = 0; i < 20; i++) {
            mSecondList.add(mFirstList.get(position) + "---" + i);
        }
        mSecondAdapter.notifyDataSetChanged();
        mSecondAdapter.setSelected(0);      //默认让列表2选中第一条,否则会保留上次所选的条目位置
        mLv_second.smoothScrollToPosition(0);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            mFirstList.add(i + "");
        }
        mFirstAdapter = new ItemAdapter<>(this, mFirstList, R.layout.item_list_first);
        mLv_first.setAdapter(mFirstAdapter);
        mFirstStr = mFirstList.get(0);

        //通过第0个字符初始化第二列列表
        initSecond();
    }

    /**
     * 初始化第二列的列表
     */
    private void initSecond() {
        for (int i = 0; i < 20; i++) {
            mSecondList.add(mFirstStr + "---" + i);
        }
        mSecondAdapter = new ItemAdapter<>(this, mSecondList, R.layout.item_list_second);
        mLv_second.setAdapter(mSecondAdapter);
    }
}
