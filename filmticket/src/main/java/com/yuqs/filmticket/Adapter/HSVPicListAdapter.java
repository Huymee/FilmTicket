package com.yuqs.filmticket.Adapter;
import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.volley.toolbox.NetworkImageView;
import com.yuqs.filmticket.Entity.FilmInfoBean.PicListBean;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.R;

/**
 * 为画廊定义适配器
 * @author Administrator
 *
 */
public class HSVPicListAdapter extends HSVBaseAdapter<PicListBean> {

    public HSVPicListAdapter(Context context, List<PicListBean> list) {
        super(context, list);
    }

    @Override
    public View getView(int location, View arg1, ViewGroup arg2) {
        View view =LayoutInflater.from(context).inflate(R.layout.item_film_pic,null);
        NetworkImageView image=(NetworkImageView)view.findViewById(R.id.iv_film_pic_list);
        PicListBean bean=getItem(location); //获取当前的Item
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setImageUrl(bean.getPicture(), HttpManager.getManager().getImageLoader());

        return view;
    }

}
