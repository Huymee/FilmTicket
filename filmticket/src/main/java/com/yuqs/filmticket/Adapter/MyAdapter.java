package com.yuqs.filmticket.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.yuqs.filmticket.Entity.FilmPlayingBean;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<FilmPlayingBean.PlayingFilm> mDataSet;//电影数据

    public MyAdapter(ArrayList<FilmPlayingBean.PlayingFilm> dataSet) {
        mDataSet = dataSet;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLPrice;
        private NetworkImageView ivPicture;
        private TextView tvDirector;
        private TextView tvOnlyDescribe;
        private TextView tvActorName;
        private TextView tvShowTime;
        private TextView tvScoreHead;
        private TextView tvScoreEnd;
        private TextView tvName;
        private TextView tvFilmFormat;
        private RelativeLayout rl01;
        private RelativeLayout rl02;

        private ViewHolder(View v) {
            super(v);
            //定义holder的控件
            rl01 = (RelativeLayout) v.findViewById(R.id.rl_img_bottom);
            rl02 = (RelativeLayout) v.findViewById(R.id.rl_img_bottom2);
            tvLPrice = (TextView) v.findViewById(R.id.tv_lPrice);
            ivPicture = (NetworkImageView) v.findViewById(R.id.iv_film_picture);
            tvOnlyDescribe = (TextView) v.findViewById(R.id.tv_only_describe);
            tvDirector = (TextView) v.findViewById(R.id.tv_director);
            tvActorName = (TextView) v.findViewById(R.id.tv_actorName);
            tvShowTime = (TextView) v.findViewById(R.id.tv_show_time);
            tvScoreHead = (TextView) v.findViewById(R.id.tv_score_before);
            tvScoreEnd = (TextView) v.findViewById(R.id.tv_score_after);
            tvName = (TextView) v.findViewById(R.id.tv_name);
            tvFilmFormat = (TextView) v.findViewById(R.id.tv_film_format); //设置默认图片
            ivPicture.setDefaultImageResId(R.mipmap.ic_launcher);
            //设置加载错误时的图片
            ivPicture.setErrorImageResId(android.R.drawable.ic_delete);
            //添加属性动画使得控件在出现时就被缩小
//            ObjectAnimator scaleY=ObjectAnimator.ofFloat(v,"scaleY",1,0.6f);
//            ObjectAnimator scaleX= ObjectAnimator.ofFloat(v,"scaleX",1,0.6f);
//            AnimatorSet animatorSet=new AnimatorSet();
//            animatorSet.play(scaleX).with(scaleY);
//            animatorSet.setDuration(500);
//            animatorSet.start();
            setOnShowListener();
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // TODO: 17/05/26  设置分享
                    return false;
                }
            });
        }

        private void setOnShowListener() {
            View.OnClickListener listener =  new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.rl_img_bottom:
                            rl01.setVisibility(View.GONE);
                            rl02.setVisibility(View.VISIBLE);
                            break;
                        case R.id.rl_img_bottom2:
                            rl01.setVisibility(View.VISIBLE);
                            rl02.setVisibility(View.GONE);
                            break;
                    }
                }
            };
            //为控件添加监听器以实现点击监听
            rl01.setOnClickListener(listener);
            rl02.setOnClickListener(listener);
        }
    }
int count=1;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_film_playing_card_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        Log.i("创建ViewHolder",""+count++);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,int position) {
        Log.i("创建ViewHolder","使用的holder："+holder);
        Log.i("显示的下标","当前下标onBindViewHolder"+position);
        //获取电影对象
        FilmPlayingBean.PlayingFilm film = mDataSet.get(position);
        //获取分数，以便后期使用
        double score = film.getScore();
        //设置简介
        holder.tvOnlyDescribe.setText(film.getOnlyDescribe());
        //设置图片
        holder.ivPicture.setImageUrl(film.getPicture(), HttpManager.getManager().getImageLoader());
//        //设置默认图片
//        holder.ivPicture.setDefaultImageResId(R.mipmap.ic_launcher);
//        //设置加载错误时的图片
//        holder.ivPicture.setErrorImageResId(android.R.drawable.ic_delete);
        //设置缩放模式1
        holder.ivPicture.setScaleType(ImageView.ScaleType.FIT_XY);
        //设置最低价格
        holder.tvLPrice.setText(String.valueOf(film.getLprice()));
        //设置导演
        holder.tvDirector.setText("导演：" + film.getDirectorName());
        //设置主演
        holder.tvActorName.setText("主演：" + film.getActorName());
        //设置上映日期
        holder.tvShowTime.setText("上映日期：" + film.getPlayTime());
        //设置分数的整数部分
        holder.tvScoreHead.setText(String.valueOf((int) score) + ".");
        //设置分数的小数部分
        holder.tvScoreEnd.setText(String.valueOf(((int) (score * 10)) % 10));
        //设置电影名称
        holder.tvName.setText(film.getChname());
        //设置电影格式
        holder.tvFilmFormat.setText(film.getTypeName());
        //将默认显示设置为初始模式，避免重用时初始效果发生变化
        holder.rl01.setVisibility(View.GONE);
        holder.rl02.setVisibility(View.VISIBLE);
//        ObjectAnimator scaleY=ObjectAnimator.ofFloat(holder,"scaleY",1,0.6f);
//        ObjectAnimator scaleX=ObjectAnimator.ofFloat(holder,"scaleX",1,0.6f);
//        AnimatorSet animatorSet=new AnimatorSet();
//        animatorSet.play(scaleX).with(scaleY);
//        animatorSet.setDuration(500);
//        animatorSet.start();

//        View.OnClickListener listener =  new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()){
//                    case R.id.rl_img_bottom:
//                        holder.rl01.setVisibility(View.GONE);
//                        holder.rl02.setVisibility(View.VISIBLE);
//                        break;
//                    case R.id.rl_img_bottom2:
//                        holder.rl01.setVisibility(View.VISIBLE);
//                        holder.rl02.setVisibility(View.GONE);
//                        break;
//                }
//            }
//        };
//        //为控件添加监听器以实现点击监听
//        holder.rl01.setOnClickListener(listener);
//        holder.rl02.setOnClickListener(listener);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}
