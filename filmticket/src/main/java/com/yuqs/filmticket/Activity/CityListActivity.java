package com.yuqs.filmticket.Activity;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.yuqs.filmticket.Adapter.CityListAdapter;
import com.yuqs.filmticket.Entity.CityBean;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.View.QuickIndexView;

import java.util.ArrayList;
import java.util.List;

public class CityListActivity extends AppCompatActivity implements CityListAdapter.OnSelectedCityListener, View.OnClickListener {

    private QuickIndexView quickIndexView;
    public static ArrayList<List<CityBean.CitysBean.City>> mCityList;
    private ListView listView;
    private CityListAdapter adapter;
    private TextView mTv = null;
    public LocationClient mLocationClient = null;
    public MyLocationListener myListener = new MyLocationListener();
    private LinearLayout ll_location_result;
    private LinearLayout ll_location;
    private TextView tv_isPositioning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        ActionBar aBar = getSupportActionBar();
        setActionBar(aBar);
        TextView tvLastCity = (TextView) findViewById(R.id.tv_city);
        tvLastCity.setText(MyApplication.currentCity.getCityName());
        quickIndexView = (QuickIndexView) findViewById(R.id.quickIndexView);
        listView = (ListView) findViewById(R.id.lv_city);
        tv_isPositioning = (TextView) findViewById(R.id.tv_isPositioning);
        tvLastCity.setOnClickListener(this);
        initEvent();
    }
    /**
     * 检查用户权限
     */
    private void checkPermission(String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(permissions[0]) != PackageManager.PERMISSION_GRANTED||
                    checkSelfPermission(permissions[1]) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(permissions, 100);//这里的100是一个执行代码
            } else
                mLocationClient.start();//获取权限后执行自己的方法
        } else mLocationClient.start();//版本低于Android 6.0,不需要检查运行时权限,直接执行操作
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 100://对应上面定义的执行代码
                if (permissions.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须获得所需的权限才能使用此功能", Toast.LENGTH_SHORT).show();
                        } else mLocationClient.start();//获取权限后执行自己的方法
                    }
                } else {
                    Toast.makeText(this, "必须获得所需的权限才能使用此功能", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onResume() {
        String[] permissions={Manifest.permission.ACCESS_COARSE_LOCATION};
        checkPermission(permissions);
        super.onResume();
    }

    @Override
    protected void onStart() {

        mLocationClient = new LocationClient(this);
        mLocationClient.registerLocationListener(myListener);
        mTv = (TextView) findViewById(R.id.tv_location_city_result);
        ll_location_result = (LinearLayout) findViewById(R.id.ll_location_result);
        ll_location = (LinearLayout) findViewById(R.id.ll_location);
        setLocationOption();

        mCityList = MyApplication.cityList;
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mCityList == null) {
                    handler.postDelayed(this, 500);
                    return;
                }
                adapter = new CityListAdapter(CityListActivity.this, mCityList, CityListActivity.this);
                listView.setAdapter(adapter);
            }
        }, 500);
        super.onStart();
    }

    private void setActionBar(ActionBar aBar) {
        TextView tvTitle = (TextView) View.inflate(this, R.layout.abar_title, null);
        tvTitle.setText(getResources().getString(R.string.city_title));
        if (aBar != null) {
            aBar.setDisplayShowCustomEnabled(true);
            aBar.setDisplayShowTitleEnabled(false);
            aBar.setCustomView(tvTitle, new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        }
    }

    private void initEvent() {
        quickIndexView.setOnIndexChangeListener(new QuickIndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String words) {
                List<List<CityBean.CitysBean.City>> datas = adapter.getData();
                if (datas != null && datas.size() > 0) {
                    int count = 0;
                    for (int i = 0; i < datas.size(); i++) {
                        List<CityBean.CitysBean.City> datasBean = datas.get(i);
                        String str = MyApplication.WORDS[i];
                        TextView view = (TextView) MyApplication.toast.getView();
                        view.setText(str);
                        MyApplication.toast.setGravity(Gravity.CENTER, 0, 150);
                        MyApplication.toast.show();
                        if (str.equals(words)) {
                            listView.setSelection(count);
//                            listView.smoothScrollToPositionFromTop(count,0,0);
                            return;
                        }
                        count += datasBean.size() + 1;
                    }
                }
            }
        });
    }

    @Override
    public void onSelectedCity(CityBean.CitysBean.City city) {
        setCurrentCity(city);
        finish();
    }

    public void setCurrentCity(CityBean.CitysBean.City city) {
        MyApplication.currentCity = city;
        SharedPreferences preferences = getSharedPreferences("city", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("city", city.getCityName());
        editor.putString("city_id", city.getId());
        editor.apply();
    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView) v;
        if (TextUtils.isEmpty(textView.getText())) return;
        finish();
    }

    //设置相关参数
    private void setLocationOption() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 5000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照定义的频率输出GPS结果
        option.setOpenGps(true); //打开gps可选，默认false,设置是否使用gps
//        option.setServiceName("com.baidu.location.service_v2.9");
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setIsNeedLocationPoiList(true);
        option.setAddrType("all");
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.setPriority(LocationClientOption.NetWorkFirst);
        option.setPriority(LocationClientOption.GpsFirst);       //gps
        option.disableCache(true);
        mLocationClient.setLocOption(option);
    }

    private class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            final String locationCity = location.getCity();
            if (locationCity != null && locationCity.length() != 0) {
                ll_location.setVisibility(View.GONE);
                ll_location_result.setVisibility(View.VISIBLE);
                ll_location_result.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<List<CityBean.CitysBean.City>> datas = adapter.getData();
                        for (List<CityBean.CitysBean.City> cityList:datas) {
                            for (CityBean.CitysBean.City city:cityList) {
                                if(locationCity.equals(city.getCityName())){
                                    setCurrentCity(city);
                                    finish();
                                    return;
                                }
                            }
                        }
                        Toast.makeText(CityListActivity.this, "暂无此城市电影信息,请选择附近城市", Toast.LENGTH_SHORT).show();
                    }
                });
                mTv.setText(locationCity);
                mLocationClient.stop();
            }else {
                Toast.makeText(CityListActivity.this, "定位失败", Toast.LENGTH_SHORT).show();
                tv_isPositioning.setText("定位失败,正在重新定位...");
            }
        }

    }

    @Override
    protected void onPause() {
        mLocationClient.stop();
        super.onPause();
    }


}
