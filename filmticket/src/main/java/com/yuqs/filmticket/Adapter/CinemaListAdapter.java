package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuqs.filmticket.Entity.CinemaListBean.CinemaDetail;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.DistanceUtil;

import java.math.BigDecimal;

/**
 * Created by 46433 on 17/06/22.
 */

public class CinemaListAdapter extends MyBaseAdapter<CinemaDetail> {

    public CinemaListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View cv, ViewGroup parent) {
        Holder holder;
        if(cv==null){
            holder=new Holder();
            cv=layoutInflater.inflate(R.layout.cinema_fragment_listview_item,null);
            holder.tv_cinema_name= (TextView) cv.findViewById(R.id.tv_cinema_name);
            holder.tv_low_price= (TextView) cv.findViewById(R.id.tv_low_price);
            holder.tv_cinema_activities= (TextView) cv.findViewById(R.id.tv_cinema_activities);
            holder.tv_cinema_address= (TextView) cv.findViewById(R.id.tv_cinema_address);
            holder.tv_distance= (TextView) cv.findViewById(R.id.tv_distance);
            holder.ll_min_price= (LinearLayout) cv.findViewById(R.id.ll_min_price);
            holder.ll_activities= (LinearLayout) cv.findViewById(R.id.ll_activities);
            cv.setTag(holder);
        }else {
            holder= (Holder) cv.getTag();
        }
        CinemaDetail cinema=getItem(position);
        double price=cinema.getLprice();
        int acti=cinema.getActivityCount();
        if(acti==0){
            holder.ll_activities.setVisibility(View.GONE);
        }else {
            holder.ll_activities.setVisibility(View.VISIBLE);
        }
        if(price==0){
            holder.ll_activities.setVisibility(View.GONE);
            holder.ll_min_price.setVisibility(View.GONE);
        }else {
            holder.ll_min_price.setVisibility(View.VISIBLE);
        }
        holder.tv_cinema_name.setText(cinema.getCname());
        holder.tv_low_price.setText(cinema.getLprice()+"元");
        holder.tv_cinema_activities.setText(String.valueOf(cinema.getActivityCount()));
        holder.tv_cinema_address.setText(cinema.getAddress());
        double latitude = cinema.getLatitude();
        double longitude = cinema.getLongitude();
        double distance = DistanceUtil.getDistance(longitude, latitude);
        if(distance>5000*1000){
            holder.tv_distance.setVisibility(View.GONE);
        }else {
            holder.tv_distance.setVisibility(View.VISIBLE);
        }
        String str;
        if (distance < 1000) {
            str = (int) distance + "米";
        } else if (distance > 10000) {
            str = (int) (distance / 1000) + "千米";
        } else {
            BigDecimal b = new BigDecimal(distance / 1000);
            double distance1 = b.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            str = distance1 + "千米";
        }
        holder.tv_distance.setText(str);
        return cv;
    }
    private class Holder{
        TextView tv_cinema_name;
        TextView tv_low_price;
        TextView tv_cinema_activities;
        TextView tv_cinema_address;
        TextView tv_distance;
        LinearLayout ll_min_price;
        LinearLayout ll_activities;
    }
}
