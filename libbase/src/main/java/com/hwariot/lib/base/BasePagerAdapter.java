package com.hwariot.lib.base;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/***
 * @date 创建时间 2018/3/30 14:07
 * @author 作者: yulong
 * @description ViewPager的基类Adapter
 */
public abstract class BasePagerAdapter<T> extends PagerAdapter {
    protected List<T> dataList;

    public void addDataList(List<T> list) {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    public int getRealCount() {
        if (dataList == null) {
            return 0;
        }
        return dataList.size();
    }

    public List<T> getDataList() {
        return dataList;
    }

    public T getItem(int position){
        if (dataList != null){
            return dataList.get(position % getRealCount());
        }
        return null;
    }

    public void setDataList(List<T> list) {
        dataList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return getRealCount();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
