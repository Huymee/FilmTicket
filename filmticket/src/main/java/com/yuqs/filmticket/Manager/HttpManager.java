package com.yuqs.filmticket.Manager;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.LruCache;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.yuqs.filmticket.Entity.CinemaForFilmBean;
import com.yuqs.filmticket.Entity.CinemaInfoBean;
import com.yuqs.filmticket.Entity.CinemaListBean;
import com.yuqs.filmticket.Entity.CityAreaBean;
import com.yuqs.filmticket.Entity.FilmFutureBean;
import com.yuqs.filmticket.Entity.FilmInfoBean;
import com.yuqs.filmticket.Entity.FilmPlanBean;
import com.yuqs.filmticket.Entity.FilmPlayingBean;
import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.Util.ImageFileCacheUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 46433 on 17/05/11.
 */

public class HttpManager {
    private RequestQueue queue = null;
    private static HttpManager httpManager;
    private String nullJson = "非空参数未符合定义";

    private HttpManager() {
    }

    public static HttpManager getManager() {
        if (httpManager == null) {
            httpManager = new HttpManager();
        }
        return httpManager;
    }

    public void requestHttpJson(Context context, final Map<String, String> params, final String url, final OnRequestJsonListener listener) {
        if (queue == null) queue = Volley.newRequestQueue(context);
        //创建一个网络请求
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String json) {
                Log.i("TAG", url + "请求成功" + json);
                if (json.contains(nullJson)) {
                    listener.onResponseError(nullJson);
                } else {
                    listener.onResponseSucceed(json, url);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("TAG", "请求失败" + volleyError.toString());
                listener.onResponseError(volleyError.toString());
            }
        }) {
            /**
             * 设置网络请求的参数
             */
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>(params);
                map.put("token", IURL.TOKEN);
                map.put("platform", "4");
                return map;
            }
        };
        //将创建的request请求添加到请求队列中
        queue.add(request);
    }
    public CinemaListBean decodeCinemaListByJson(String string) {
        //将返回的string转换成FilmPlayingBean对象
        return gson.fromJson(string, CinemaListBean.class);
    }

    public FilmPlayingBean decodePlayingFilmByJson(String string) {
        //将返回的string转换成FilmPlayingBean对象
        return gson.fromJson(string, FilmPlayingBean.class);
    }

    public FilmFutureBean decodeFutureFilmByJson(String string) {
        //将返回的string转换成FilmFutureBean对象
        return gson.fromJson(string, FilmFutureBean.class);
    }

    public FilmInfoBean decodeFilmInfoByJson(String string) {
        //将返回的string转换成FilmFutureBean对象
        return gson.fromJson(string, FilmInfoBean.class);
    }

    public CinemaForFilmBean decodeCinemaByJson(String string) {
        return gson.fromJson(string, CinemaForFilmBean.class);
    }

    public CinemaInfoBean decodeCinemaInfoByJson(String string) {
        return gson.fromJson(string, CinemaInfoBean.class);
    }

    private Gson gson = new Gson();

    public FilmPlanBean decodeFilmPlanByJson(String json) {
        return gson.fromJson(json, FilmPlanBean.class);
    }

    public CityAreaBean decodeCityAreaByJson(String json) {
        return gson.fromJson(json, CityAreaBean.class);
    }


    /**
     * 获取ImageLoader
     *
     * @return ImageLoader
     */
    public ImageLoader getImageLoader() {
        ImageLoader loader = new ImageLoader(queue, new ImageLoader.ImageCache() {
            int maxSize = 1024 * 1024 * 4;
            LruCache<String, Bitmap> cache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight();
                }
            };

            @Override
            public Bitmap getBitmap(String url) {
                Bitmap bitmap = cache.get(url);
                if (bitmap == null)
                    bitmap = ImageFileCacheUtils.getInstance().getImage(url);
                return bitmap;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
                ImageFileCacheUtils.getInstance().saveBitmap(bitmap, url);
            }
        });
        return loader;
    }


    /**
     * 网络请求Json字符串之后的回调接口
     */
    public interface OnRequestJsonListener {
        /**
         * 加载成功后调用的回调函数
         *
         * @param json 返回的json字符串
         */
        void onResponseSucceed(String json, String url);

        /**
         * 加载失败后调用的方法
         *
         * @param volleyError 返回的错误信息
         */
        void onResponseError(String volleyError);
    }
}
