package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.toolbox.NetworkImageView;
import com.yuqs.filmticket.Activity.CinemaInfoActivity;
import com.yuqs.filmticket.Entity.FilmPlayingBean;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.R;

import java.util.List;

/**
 * Created by 46433 on 17/06/21.
 */

public class HAVFilmAdapter extends  HSVBaseAdapter<FilmPlayingBean.PlayingFilm>{
    public HAVFilmAdapter(Context context, List<FilmPlayingBean.PlayingFilm> list) {
        super(context, list);
    }

    @Override
public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
        holder = new Holder();
        convertView = View.inflate(context,R.layout.item_film_playing,null);
        holder.image = (NetworkImageView) convertView.findViewById(R.id.iv_film_pic_list);
        convertView.setTag(holder);
        } else {
        holder = (Holder) convertView.getTag();
        }
        FilmPlayingBean.PlayingFilm bean = getItem(position); //获取当前的Item
        holder.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.image.setImageUrl(bean.getPictureThumb(), HttpManager.getManager().getImageLoader());
        return convertView;
        }

class Holder {
    NetworkImageView image;
}
                }
