package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yuqs.filmticket.Entity.CinemaForFilmBean.Cinema;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.DistanceUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 46433 on 17/06/08.
 */

public class CinemaAdapter extends MyBaseAdapter<Cinema> {

    public CinemaAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_choose_cinemas_list, null);
            holder.iv_seat = (ImageView) convertView.findViewById(R.id.iv_seat);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_address = (TextView) convertView.findViewById(R.id.tv_address);
            holder.tv_remainder_film = (TextView) convertView.findViewById(R.id.tv_remainder_film);
            holder.ll_reduce = (LinearLayout) convertView.findViewById(R.id.ll_reduce);
            holder.tv_reduce_content = (TextView) convertView.findViewById(R.id.tv_reduce_content);
            holder.tv_reduce_price = (TextView) convertView.findViewById(R.id.tv_reduce_price);
            holder.tv_film_plan = (TextView) convertView.findViewById(R.id.tv_film_plan);
            holder.rl_price_low = (RelativeLayout) convertView.findViewById(R.id.rl_price_low);
            holder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
            holder.tv_distance = (TextView) convertView.findViewById(R.id.tv_distance);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Cinema cinema = getItem(position);
        List<Cinema.FilmPlanBean> planList = cinema.getFilmPlan();
        //设置影院名
        holder.tv_name.setText(cinema.getCname());
        //设置影院地址
        holder.tv_address.setText(cinema.getAddress());

        //是否有活动 有则显示
        holder.ll_reduce.setVisibility(View.GONE);
//        //活动名
//        holder.tv_reduce_content.setText(cinema.getAddress());
//        //活动价格
//        holder.tv_reduce_price.setText(cinema.getAddress());
        if (planList != null) {
            //设置今日剩余场次
            holder.tv_remainder_film.setText("今日余" + planList.size() + "场");
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < planList.size(); i++) {
                Cinema.FilmPlanBean planBean = planList.get(i);
                builder.append(planBean.getPlaytime());
                if (i != (planList.size() - 1))
                    builder.append("|");
            }
            String filmPlan = builder.toString();
            //放映计划
            holder.tv_film_plan.setVisibility(View.VISIBLE);
            holder.tv_film_plan.setText(filmPlan);
        } else {
            holder.tv_remainder_film.setText("今日余0场");
            holder.tv_film_plan.setVisibility(View.GONE);
        }
        //价格
        holder.tv_price.setText(String.valueOf(cinema.getFilmMinPrice()));

        //距离
        double latitude = cinema.getLatitude();
        double longitude = cinema.getLongitude();
        double distance = DistanceUtil.getDistance(longitude, latitude);
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

        return convertView;
    }

    class ViewHolder {
        TextView tv_name;
        TextView tv_address;
        ImageView iv_seat;
        TextView tv_remainder_film;
        LinearLayout ll_reduce;
        TextView tv_reduce_content;
        TextView tv_reduce_price;
        TextView tv_film_plan;
        RelativeLayout rl_price_low;
        TextView tv_price;
        TextView tv_distance;
    }
}
