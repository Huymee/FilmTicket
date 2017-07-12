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
import com.yuqs.filmticket.Adapter.FutureFilmAdapter;
import com.yuqs.filmticket.Entity.FilmFutureBean;
import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragmentFuture extends Fragment {


    private FutureFilmAdapter adapter;
    private UltraViewPager ultraViewPager;
    private View view;
    private String cityId;
    private Map<String, String> params = new HashMap<>();
    private String url;
    private final MyOnRequestJsonListener listener;

    public ChildFragmentFuture() {
        listener = new MyOnRequestJsonListener();
    }

    @Override
    public void onAttach(Context context) {
        url = IURL.GET_FUTURE_FILM;
        cityId = MyApplication.currentCity.getId();
        params.put("cityId", cityId);
        HttpManager.getManager().requestHttpJson(getContext(), params, url, listener);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_coming_soon, container, false);
        adapter = new FutureFilmAdapter(getContext(), true);
        ultraViewPager = (UltraViewPager) view.findViewById(R.id.ultra_viewpager);
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
        ultraViewPager.setAdapter(adapter);
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
        super.onResume();
    }

    private class MyOnRequestJsonListener implements HttpManager.OnRequestJsonListener {
        @Override
        public void onResponseSucceed(String json, String url) {
            FilmFutureBean bean = HttpManager.getManager().decodeFutureFilmByJson(json);
            adapter.addData(bean.getData());
//            ultraViewPager.setItemRatio(1f);
//            ultraViewPager.setItemRatio(0.72f);
//            ultraViewPager.setMultiScreen(0.8f);
            ultraViewPager.setAutoMeasureHeight(true);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    UltraDepthScaleTransformer ultraDepthScaleTransformer = new UltraDepthScaleTransformer();
                    ultraViewPager.setPageTransformer(false, ultraDepthScaleTransformer);
                }
            }, 0);
            ultraViewPager.setInfiniteLoop(true);
            view.invalidate();
        }

        @Override
        public void onResponseError(String volleyError) {

        }
    }
}
