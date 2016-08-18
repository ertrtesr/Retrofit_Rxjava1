package com.example.huangwenjian.retrofit_rxjava1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.huangwenjian.retrofit_rxjava1.R;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * 作者: huangwenjian
 * 描述:
 * 日期: 16/8/18
 */
public class ItemAdapter<T> extends BaseAdapter {
    private Context mContext;
    private List<String> mList;
    private int mItemLayoutId;
    private LayoutInflater mInflater;

    public ItemAdapter() {
    }

    public ItemAdapter(Context context, List<String> list, int itemLayoutId) {
        mContext = context;
        mList = list;
        mItemLayoutId = itemLayoutId;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = null;
        ViewHolder holder = null;
        if (convertView == null) {
            view = mInflater.inflate(mItemLayoutId, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_item.setText(mList.get(position));
        return view;
    }


    static class ViewHolder {
        TextView tv_item;

        public ViewHolder() {
        }

        public ViewHolder(View view) {
            tv_item = (TextView) view.findViewById(R.id.tv_item);
        }
    }
}
