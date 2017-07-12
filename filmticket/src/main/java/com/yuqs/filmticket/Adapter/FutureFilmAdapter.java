package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.yuqs.filmticket.Activity.FilmInfoActivity;
import com.yuqs.filmticket.Entity.FilmFutureBean.FutureFilm;
import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 46433 on 17/05/30.
 */

public class FutureFilmAdapter extends PagerAdapter {
    private List<FutureFilm> list;
    private ViewPager pager;
    private LayoutInflater inflater = null;
    //用于存储回收掉的View
    private List<WeakReference<CardView>> viewList;
    Context context;
    private boolean isMultiScr;
    private final TranslateAnimation mShowAction;
    private final TranslateAnimation mHiddenAction;

    public FutureFilmAdapter(Context context, boolean isMultiScr) {
        this.isMultiScr = isMultiScr;
        this.context = context;
        list = new ArrayList<>();
        viewList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setStartOffset(500);
        mShowAction.setDuration(500);
        mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f);
        mHiddenAction.setDuration(500);
    }

    public void addData(ArrayList<FutureFilm> list) {
        if (list == null || list.size() == 0) this.list = new ArrayList<>();
        else this.list = list;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        }, 0);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(View container, int position) { // 这个方法用来实例化页卡
        if (pager == null) {
            pager = (ViewPager) container;
        }
        View view = null;
        // 从废弃的里去取 取到则使用 取不到则创建
        if (viewList.size() > 0) {
            if (viewList.get(0) != null) {
                view = initView(viewList.get(0).get(), position);
                viewList.remove(0);
            }
        }else
        view = initView(null, position);
        pager.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //存储离屏的View 等待复用
        CardView view = (CardView) object;
        container.removeView(view);
        viewList.add(new WeakReference<>(view));
//        super.destroyItem(container, position, object);
    }

    private View initView(CardView view, int position) {
        ViewHolder holder;
        if (view == null) {
            view = (CardView) inflater.inflate(R.layout.item_film_future_card_view, null);
            holder = new ViewHolder();
            holder.rl01 = (RelativeLayout) view.findViewById(R.id.rl_img_bottom);
            holder.rl02 = (RelativeLayout) view.findViewById(R.id.rl_img_bottom2);
            holder.tvLPrice = (TextView) view.findViewById(R.id.tv_lPrice);
            holder.ivPicture = (NetworkImageView) view.findViewById(R.id.iv_film_picture);
            holder.tvOnlyDescribe = (TextView) view.findViewById(R.id.tv_only_describe);
            holder.tvDirector = (TextView) view.findViewById(R.id.tv_director);
            holder.tvActorName = (TextView) view.findViewById(R.id.tv_actorName);
            holder.tvShowTime = (TextView) view.findViewById(R.id.tv_show_time);
            holder.tvScoreHead = (TextView) view.findViewById(R.id.tv_score_before);
            holder.tvScoreEnd = (TextView) view.findViewById(R.id.tv_score_after);
            holder.tvName = (TextView) view.findViewById(R.id.tv_name);
            holder.tvFilmFormat = (TextView) view.findViewById(R.id.tv_film_format);
            //设置默认图片
            holder.ivPicture.setDefaultImageResId(R.mipmap.ic_launcher);
            //设置加载错误时的图片
            holder.ivPicture.setErrorImageResId(android.R.drawable.ic_delete);
            setOnShowListener(holder);
            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // TODO: 17/05/26  设置分享
                    return false;
                }
            });
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        /**
         * 初始化数据
         */
        if (list != null && position < list.size()) {
            final FutureFilm film = list.get(position);
            //获取分数，以便后期使用
            double score = film.getScore();
            //设置简介
            holder.tvOnlyDescribe.setText(film.getOnlyDescribe());
            //设置图片
            holder.ivPicture.setImageUrl(film.getPicture(), HttpManager.getManager().getImageLoader());
            holder.ivPicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, FilmInfoActivity.class);
                    intent.putExtra(IURL.ACTION_FILM_ID,film.getFilmID());
                    intent.putExtra(IURL.ACTION_FILM_TYPE,IURL.FILM_TYPE_FUTURE);
                    intent.putExtra(IURL.ACTION_FILM_NAME,film.getChname());
                    context.startActivity(intent);
                }
            });
            //设置缩放模式1
            holder.ivPicture.setScaleType(ImageView.ScaleType.FIT_XY);
            //设置最低价格
            holder.tvLPrice.setText(film.getFshowtime() + " 上映");
            //设置导演
            holder.tvDirector.setText("导演：" + film.getDirectorName());
            //设置主演
            holder.tvActorName.setText("主演：" + film.getActorName());
            //设置上映日期
            holder.tvShowTime.setText("上映日期：" + film.getFshowtime());
            //设置分数的整数部分
            holder.tvScoreHead.setText(String.valueOf((int) score) + ".");
            //设置分数的小数部分
            holder.tvScoreEnd.setText(String.valueOf(((int) (score * 10)) % 10));
            //设置电影名称
            holder.tvName.setText(film.getChname());
            //设置电影格式
            holder.tvFilmFormat.setText(film.getFilmTypeName());
            //将默认显示设置为初始模式，避免重用时初始效果发生变化
            holder.rl01.setVisibility(View.GONE);
            holder.rl02.setVisibility(View.VISIBLE);
        }
        return view;
    }

    private void setOnShowListener(final ViewHolder holder) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.rl_img_bottom:
                        holder.rl01.startAnimation(mHiddenAction);
                        holder.rl01.setVisibility(View.GONE);
                        holder.rl02.startAnimation(mShowAction);
                        holder.rl02.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rl_img_bottom2:
                        holder.rl01.startAnimation(mShowAction);
                        holder.rl01.setVisibility(View.VISIBLE);
                        holder.rl02.startAnimation(mHiddenAction);
                        holder.rl02.setVisibility(View.GONE);
                        break;
                }
            }
        };
        //为控件添加监听器以实现点击监听
        holder.rl01.setOnClickListener(listener);
        holder.rl02.setOnClickListener(listener);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    private class ViewHolder {
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
    }
}
