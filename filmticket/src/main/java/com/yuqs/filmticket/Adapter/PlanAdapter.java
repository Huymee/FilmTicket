package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuqs.filmticket.Entity.FilmPlanBean.DataBean.FilmPlan;
import com.yuqs.filmticket.Manager.DateManager;
import com.yuqs.filmticket.R;


/**
 * Created by 46433 on 17/06/21.
 * 放映计划适配器
 */

public class PlanAdapter extends MyBaseAdapter<FilmPlan>{
    public PlanAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView==null){
            holder=new Holder();
            convertView=layoutInflater.inflate(R.layout.item_cinema_info_plan_today,null);
            holder.btn_buy= (Button) convertView.findViewById(R.id.btn_buy);
            holder.btn_buy_stop= (Button) convertView.findViewById(R.id.btn_buy_stop);
            holder.startTime= (TextView) convertView.findViewById(R.id.startTime);
            holder.endTime= (TextView) convertView.findViewById(R.id.endTime);
            holder.tv_format= (TextView) convertView.findViewById(R.id.tv_format);
            holder.tv_hallname= (TextView) convertView.findViewById(R.id.tv_hallname);
            holder.tv_price_login_vip= (TextView) convertView.findViewById(R.id.tv_price_login_vip);
            holder.tv_price_login_original= (TextView) convertView.findViewById(R.id.tv_price_login_original);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        FilmPlan filmPlan=getItem(position);
        String playtime =filmPlan.getPlaytime();
        String fullPlayTime=filmPlan.getFullPlayTime();
        holder.startTime.setText(playtime);
        holder.endTime.setText(filmPlan.getEndtime());
        holder.tv_format.setText(filmPlan.getTypeName()+"/"+filmPlan.getFilmLanguage());
        holder.tv_hallname.setText(filmPlan.getHallName());
        holder.tv_price_login_vip.setText(String.valueOf(filmPlan.getSprice()));
        holder.tv_price_login_original.setText(filmPlan.getPrice()+"元");
        if(DateManager.getTimeIsEnough(playtime,fullPlayTime)){
            holder.btn_buy.setVisibility(View.VISIBLE);
            holder.btn_buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "购票功能敬请期待", Toast.LENGTH_SHORT).show();
                }
            });
            holder.btn_buy_stop.setVisibility(View.GONE);
        }else {
            holder.btn_buy.setVisibility(View.GONE);
            holder.btn_buy_stop.setVisibility(View.VISIBLE);
        }
        return convertView;
    }


    class Holder{
        TextView startTime;
        TextView endTime;
        TextView tv_format;
        TextView tv_hallname;
        TextView tv_price_login_vip;
        TextView tv_price_login_original;
        Button btn_buy;
        Button btn_buy_stop;
    }
}
