package com.yuqs.filmticket.Manager;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuqs.filmticket.Entity.CityBean;
import com.yuqs.filmticket.Entity.FilmFutureBean;
import com.yuqs.filmticket.Entity.FilmPlayingBean;
import com.yuqs.filmticket.Entity.IURL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 46433 on 17/06/02.
 */

public class CityHttpManager {
    private static RequestQueue queue = null;
    private static ArrayList<List<CityBean.CitysBean.City>> cityList;
    private static OnRequestCityListener cityListener;

    public static void requestHttpPlayingFilm(Context context, final OnRequestCityListener listener) {
        cityListener = listener;
        if (queue == null) queue = Volley.newRequestQueue(context);
        //创建一个网络请求
        StringRequest request = new StringRequest(Request.Method.POST, IURL.GET_CITY, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                Log.i("TAG", "请求成功" + string);
                //将返回的string转换成FilmPlayingBean对象
                Gson gson = new Gson();
                CityBean cityBean = gson.fromJson(string, CityBean.class);
                //提取filmPlayingBean中的PlayingFilm列表
                cityList = new ArrayList<>();
                cityList.add(cityBean.getCitys().getA());
                cityList.add(cityBean.getCitys().getB());
                cityList.add(cityBean.getCitys().getC());
                cityList.add(cityBean.getCitys().getD());
                cityList.add(cityBean.getCitys().getE());
                cityList.add(cityBean.getCitys().getF());
                cityList.add(cityBean.getCitys().getG());
                cityList.add(cityBean.getCitys().getH());
                cityList.add(cityBean.getCitys().getI());
                cityList.add(cityBean.getCitys().getJ());
                cityList.add(cityBean.getCitys().getK());
                cityList.add(cityBean.getCitys().getL());
                cityList.add(cityBean.getCitys().getM());
                cityList.add(cityBean.getCitys().getN());
                cityList.add(cityBean.getCitys().getO());
                cityList.add(cityBean.getCitys().getP());
                cityList.add(cityBean.getCitys().getQ());
                cityList.add(cityBean.getCitys().getR());
                cityList.add(cityBean.getCitys().getS());
                cityList.add(cityBean.getCitys().getT());
                cityList.add(cityBean.getCitys().getU());
                cityList.add(cityBean.getCitys().getV());
                cityList.add(cityBean.getCitys().getW());
                cityList.add(cityBean.getCitys().getX());
                cityList.add(cityBean.getCitys().getY());
                cityList.add(cityBean.getCitys().getZ());
                cityListener.onResponseSucceed(cityList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("TAG", "请求失败" + volleyError.toString());
                cityListener.onResponseError(volleyError);
            }
        }) {
            /**
             * 设置网络请求的参数
             * @return
             * @throws AuthFailureError
             */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("token", IURL.TOKEN);
                map.put("platform", "4");
                return map;
            }
        };
        //将创建的request请求添加到请求队列中
        queue.add(request);
    }

    /**
     * 网络加载城市列表之后的回调接口
     */
    public interface OnRequestCityListener {
        void onResponseSucceed(ArrayList<List<CityBean.CitysBean.City>> list);

        void onResponseError(VolleyError volleyError);
    }
}
