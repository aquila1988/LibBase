package com.hwariot.lib.base;

import android.widget.BaseAdapter;

import java.util.List;

/***
 * @date 创建时间 2018/4/11 11:54
 * @author 作者: yulong
 * @description List的Adapter基类
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {
    protected List<T> dataList;

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void addDataList(List<T> list) {
        if (this.dataList == null) {
            this.dataList = list;
        } else {
            dataList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public int getRealCount() {
        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

    @Override
    public int getCount() {
        return getRealCount();
    }

    @Override
    public T getItem(int position) {
        if (dataList == null) {
            return null;
        }
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
