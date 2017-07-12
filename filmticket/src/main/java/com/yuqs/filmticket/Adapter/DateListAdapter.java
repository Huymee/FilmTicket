package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuqs.filmticket.R;

import java.util.List;

/**
 * Created by 46433 on 17/06/21.
 */

public class DateListAdapter extends HSVBaseAdapter<String> {

    public DateListAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=View.inflate(context, R.layout.layout_paln_date,null);
        ((TextView)convertView).setText(list.get(position));
        return convertView;
    }
}
