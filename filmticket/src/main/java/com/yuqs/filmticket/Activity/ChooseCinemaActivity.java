package com.yuqs.filmticket.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.yuqs.filmticket.Adapter.CinemaAdapter;
import com.yuqs.filmticket.Entity.CinemaForFilmBean;
import com.yuqs.filmticket.Entity.CinemaForFilmBean.Cinema;
import com.yuqs.filmticket.Entity.CinemaListBean;
import com.yuqs.filmticket.Entity.CityAreaBean;
import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.SetMyActionBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChooseCinemaActivity extends AppCompatActivity implements HttpManager.OnRequestJsonListener, AdapterView.OnItemClickListener {

    private String filmID;
    private String cityID;
    private Map<String, String> params = new HashMap<>();
    private EditText et_search;
    private TextView tv_cancel;
    private RelativeLayout rl_area;
    private TextView tv_area;
    private RelativeLayout rl_features;
    private TextView tv_features;
    private RelativeLayout rl_sort;
    private TextView tv_sort;
    private ListView xListView;
    private CinemaAdapter adapter;
    private List<Cinema> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        filmID = intent.getStringExtra(IURL.ACTION_FILM_ID);
        cityID = MyApplication.currentCity.getId();
        setContentView(R.layout.activity_choose_cinema);
        params.put(IURL.ACTION_FILM_ID, filmID);
        params.put(IURL.ACTION_CITY_ID, cityID);
        HttpManager.getManager().requestHttpJson(this, params, IURL.GET_FILM_BY_FILM_AND_CITY, this);
        SetMyActionBar.setActionBar(this, getSupportActionBar(), "选择影院", true);
        initView();
        setListener();
    }

    private void initView() {
        et_search = (EditText) findViewById(R.id.et_search);
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        rl_area = (RelativeLayout) findViewById(R.id.rl_area);
        tv_area = (TextView) findViewById(R.id.tv_area);
        rl_features = (RelativeLayout) findViewById(R.id.rl_features);
        tv_features = (TextView) findViewById(R.id.tv_features);
        rl_sort = (RelativeLayout) findViewById(R.id.rl_sort);
        tv_sort = (TextView) findViewById(R.id.tv_sort);
        xListView = (ListView) findViewById(R.id.xListView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponseSucceed(String json, String url) {
        CinemaForFilmBean bean = HttpManager.getManager().decodeCinemaByJson(json);
        list = bean.getData();
        adapter = new CinemaAdapter(this);
        xListView.setAdapter(adapter);
        adapter.addDatas(list);
        xListView.setOnItemClickListener(this);
    }

    @Override
    public void onResponseError(String volleyError) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Cinema cinema = adapter.getItem(position);
        int cinemaId = cinema.getCinemaId();
        Intent intent = new Intent(this, CinemaInfoActivity.class);
        intent.putExtra("cinemaId", cinemaId);
        intent.putExtra("cinemaName", cinema.getCname());
        intent.putExtra(IURL.ACTION_FILM_ID, filmID);
        startActivity(intent);
    }

    private Map<String, String> map = new HashMap<>();


    private void setListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.rl_area:
                        //按地区选择
                        map.put(IURL.ACTION_CITY_ID, MyApplication.currentCity.getId());
                        HttpManager.getManager().requestHttpJson(ChooseCinemaActivity.this, map, IURL.GET_AREA_BY_CITY, new HttpManager.OnRequestJsonListener() {
                            @Override
                            public void onResponseSucceed(String json, String url) {
                                CityAreaBean bean = HttpManager.getManager().decodeCityAreaByJson(json);
                                final List<CityAreaBean.Area> cityArealist = bean.getAreas();
                                final String[] areas = new String[cityArealist.size()];
                                final Integer[] areaIds = new Integer[cityArealist.size()];
                                for (int i = 0; i < cityArealist.size(); i++) {
                                    areaIds[i] = cityArealist.get(i).getId();
                                    areas[i] = cityArealist.get(i).getAreaName();
                                }
                                new AlertDialog.Builder(ChooseCinemaActivity.this).setTitle("请选择区域")
                                        .setIcon(android.R.drawable.ic_dialog_info)
                                        .setSingleChoiceItems(areas, 0,
                                                new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        chosenAreaId = areaIds[which];
                                                        tv_area.setText(areas[which]);
                                                        resetListView();
                                                        dialog.dismiss();
                                                    }
                                                })
                                        .setNegativeButton("取消选择", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                chosenAreaId = -1;
                                                resetListView();
                                                tv_area.setText("全部区域");
                                            }
                                        }).show();
                            }

                            @Override
                            public void onResponseError(String volleyError) {

                            }
                        });
                        break;
                    case R.id.rl_sort:
                        // TODO 按距离排序
                        break;
                }
            }
        };
        rl_area.setOnClickListener(listener);
        rl_features.setVisibility(View.GONE);
        rl_sort.setOnClickListener(listener);
    }

    private int chosenAreaId = -1;

    private void resetListView() {
        List<Cinema> chosenList = new ArrayList();
        if (chosenAreaId != -1) {
            for (Cinema cinema : list) {
                if (chosenAreaId == (cinema.getAreaId())) {
                    chosenList.add(cinema);
                }
            }
        } else {
            chosenList = list;
        }
        adapter.addDatas(chosenList);
    }
}
