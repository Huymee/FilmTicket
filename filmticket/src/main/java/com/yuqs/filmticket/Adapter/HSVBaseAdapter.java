package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 为画廊定义适配器
 * @author Administrator
 *
 */
public abstract class HSVBaseAdapter<T> extends BaseAdapter {

    List<T> list;
    public Context context;
    public HSVBaseAdapter(Context context, List<T> list){
        this.context=context;
        if(list==null) {
            this.list = new ArrayList<>();
        }else {
            this.list=list;
        }
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int location) {
        return list.get(location);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);

    public void setData(List<T> list){
        if(list==null){
            return;
        }
        this.list=list;
        notifyDataSetChanged();
    }

}
