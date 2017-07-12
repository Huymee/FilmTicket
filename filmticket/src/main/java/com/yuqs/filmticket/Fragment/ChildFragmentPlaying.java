package com.yuqs.filmticket.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraDepthScaleTransformer;
import com.yuqs.filmticket.Adapter.PlayingFilmAdapter;
import com.yuqs.filmticket.Entity.FilmPlayingBean;
import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragmentPlaying extends Fragment {
    private UltraViewPager ultraViewPager;
    private PlayingFilmAdapter adapter;
    private String cityId;
    private String url;
    private Map<String, String> params = new HashMap<>();
    private final MyOnRequestJsonListener listener;

    public ChildFragmentPlaying() {
        listener = new MyOnRequestJsonListener();
    }

    @Override
    public void onAttach(Context context) {
        url = IURL.GET_PLAYING_FILM;
        cityId = MyApplication.currentCity.getId();
        params.put("cityId", cityId);
        HttpManager.getManager().requestHttpJson(getContext(), params, url, listener);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_playing, container, false);
        adapter = new PlayingFilmAdapter(getContext(), true);
        ultraViewPager = (UltraViewPager) view.findViewById(R.id.ultra_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        ultraViewPager.setAdapter(adapter);
        //内置indicator初始化
        //ultraViewPager.initIndicator();
//        ultraViewPager.setMultiScreen(0.8f);
//        ultraViewPager.setItemRatio(0.9f);
//        ultraViewPager.setAutoMeasureHeight(true);
        return view;
    }

    @Override
    public void onResume() {
        String newCityId = MyApplication.currentCity.getId();
        if (!cityId.equals(newCityId)) {
            cityId = newCityId;
            params.put("cityId", cityId);
            HttpManager.getManager().requestHttpJson(getContext(), params, url, listener);
        }
        System.gc();
        super.onResume();
    }

    private class MyOnRequestJsonListener implements HttpManager.OnRequestJsonListener {
        @Override
        public void onResponseSucceed(String json, String url) {
            FilmPlayingBean bean = HttpManager.getManager().decodePlayingFilmByJson(json);
            adapter.addData(bean.getData());

            //设定页面循环播放
            ultraViewPager.setInfiniteLoop(true);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    UltraDepthScaleTransformer ultraDepthScaleTransformer = new UltraDepthScaleTransformer();
                    ultraViewPager.setPageTransformer(false, ultraDepthScaleTransformer);
                }
            }, 0);
            //设定页面自动切换  间隔2秒
            //ultraViewPager.setAutoScroll(2000);
            ultraViewPager.invalidate();
        }

        @Override
        public void onResponseError(String volleyError) {

        }
    }


}
