package com.yuqs.filmticket;

import android.Manifest;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.yuqs.filmticket.Entity.CityBean;
import com.yuqs.filmticket.Entity.UserEntity;
import com.yuqs.filmticket.Manager.CityHttpManager;
import com.yuqs.filmticket.Util.CrashHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 46433 on 17/05/31.
 */

public class MyApplication extends Application implements CityHttpManager.OnRequestCityListener, BDLocationListener {
    public static MyApplication instance;
    public static UserEntity currentUser;
    public static CityBean.CitysBean.City currentCity;
    public static ArrayList<List<CityBean.CitysBean.City>> cityList;
    public static String[] WORDS = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z", "#"};
    public static Toast toast;
    public LocationClient mLocationClient = null;
    public static double currentLatitude;
    public static double currentLongitude;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        SDKInitializer.initialize(this);
        CityHttpManager.requestHttpPlayingFilm(this, this);
        SharedPreferences preferences = getSharedPreferences("city", MODE_PRIVATE);
        currentCity = new CityBean.CitysBean.City();
        currentCity.setCityName(preferences.getString("city", ""));
        currentCity.setId(preferences.getString("city_id", ""));
        SharedPreferences errorPreferences=getSharedPreferences("errorInfo",MODE_PRIVATE);
        toast = new Toast(this);
        View toastView = LayoutInflater.from(this).inflate(R.layout.item_city_toast, null);
        toast.setView(toastView);
        CrashHandler.getInstance().init(this);
        setLocation();
    }

    private void setLocation(){
        mLocationClient = new LocationClient(this);
        mLocationClient.registerLocationListener(this);
        setLocationOption();
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (hasLocationPermission(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    mLocationClient.start();
                }else {
                    handler.postDelayed(this,1000);
                }
            }
        },1000);
    }
    //设置相关参数
    private void setLocationOption() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 0;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setLocationNotify(false);//可选，默认false，设置是否当gps有效时按照定义的频率输出GPS结果
        option.setOpenGps(true); //打开gps可选，默认false,设置是否使用gps
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setIsNeedLocationPoiList(true);
        option.setAddrType("all");
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.setPriority(LocationClientOption.GpsFirst);//gps
        option.disableCache(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    public void onResponseSucceed(ArrayList<List<CityBean.CitysBean.City>> list) {
        cityList = list;
    }

    @Override
    public void onResponseError(VolleyError volleyError) {
    }

    /**
     * 检查用户权限
     */
    private boolean hasLocationPermission(String permission) {//Manifest.permission.ACCESS_COARSE_LOCATION
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                //没有权限的情况
                return false;
            } else {
                //有权限的情况
                return true;
            }
        } else {
            //版本低于Android 6.0,不需要检查运行时权限,直接执行操作
            return true;
        }
    }

    @Override
    public void onReceiveLocation(BDLocation bdLocation) {
        currentLatitude=bdLocation.getLatitude();
        currentLongitude=bdLocation.getLongitude();
        mLocationClient.stop();
    }

}
