package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础适配器
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {
    protected LayoutInflater layoutInflater = null;//先定义一个布局解析器，定义访问权限为子类可用
    protected Context context = null;//上下文对象
    private List<T> datas = new ArrayList<>();

    public MyBaseAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    /**
     * 向adapter中添加一批数据
     *
     * @param list      要添加的数据
     * @param isToClear 是否清除原适配器中的数据
     */
    public void addDatas(List<T> list, boolean isToClear) {
        if (isToClear) datas.clear();
        if (datas != null) {
            datas.addAll(list);
            notifyDataSetChanged();
        }
    }
    /**
     * 向adapter重新中添加一批数据，并默认将adapter中原有的数据清空
     *
     * @param list      要添加的数据
     */
    public void addDatas(List<T> list) {
        datas.clear();
        if (datas != null) {
            datas.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);
}
