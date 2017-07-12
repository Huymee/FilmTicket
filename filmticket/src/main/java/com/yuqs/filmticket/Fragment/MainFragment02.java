package com.yuqs.filmticket.Fragment;

/**
 * Created by 46433 on 17/04/10.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yuqs.filmticket.Activity.CinemaInfoActivity;
import com.yuqs.filmticket.Adapter.CinemaListAdapter;
import com.yuqs.filmticket.Adapter.MyBaseAdapter;
import com.yuqs.filmticket.Entity.CinemaListBean;
import com.yuqs.filmticket.Entity.CityAreaBean;
import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment02 extends Fragment implements HttpManager.OnRequestJsonListener {
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
    private String cityId;
    private List<CinemaListBean.CinemaDetail> list;
    private MyBaseAdapter<CinemaListBean.CinemaDetail> adapter;

    public MainFragment02() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_choose_cinema, container, false);
        initView(view);
        setListener();
        adapter = new CinemaListAdapter(getContext());
        return view;
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
                        HttpManager.getManager().requestHttpJson(getContext(), map, IURL.GET_AREA_BY_CITY, new HttpManager.OnRequestJsonListener() {
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
                                new AlertDialog.Builder(getContext()).setTitle("请选择区域")
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
                    case R.id.rl_features:
                        //按特色选择
                        final String[] features = {"免费WIFI", "眼镜免压", "免费停车"};
                        new AlertDialog.Builder(getContext()).setTitle("请选择服务")
                                .setIcon(android.R.drawable.ic_dialog_info)
                                .setSingleChoiceItems(features, 0,
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                featur = features[which];
                                                resetListView();
                                                tv_features.setText(featur);
                                                dialog.dismiss();
                                            }
                                        })
                                .setPositiveButton("取消选择", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        featur = "";
                                        tv_features.setText("影院特色");
                                        resetListView();
                                    }
                                }).show();
                        break;
                    case R.id.rl_sort:
                        // TODO 按距离排序
                        break;
                }
            }
        };
        rl_area.setOnClickListener(listener);
        rl_features.setOnClickListener(listener);
        rl_sort.setOnClickListener(listener);
    }

    private int chosenAreaId = -1;
    private Set<String> chosenFeatur = new HashSet<>();
    private String featur = "";

    private void resetListView() {
        List<CinemaListBean.CinemaDetail> chosenList = new ArrayList();
        if (chosenAreaId != -1) {
            for (CinemaListBean.CinemaDetail cinema : list) {
                if (chosenAreaId == (cinema.getAreaId())) {
                    chosenList.add(cinema);
                }
            }
        } else {
            chosenList = list;
        }
        Set<CinemaListBean.CinemaDetail> finalChosenList = new HashSet<>();
        if (!featur.equals("")) {
            for (CinemaListBean.CinemaDetail cinema : chosenList) {
                for (CinemaListBean.CinemaDetail.CinemaServiceBean service : cinema.getCinemaService()) {
                    if (service.getServiceName().contains(featur)) {
                        finalChosenList.add(cinema);
                    }
                }
            }
        } else {
            adapter.addDatas(chosenList);
            return;
        }
        adapter.addDatas(new ArrayList<>(finalChosenList));
    }

    private void initView(View v) {
        et_search = (EditText) v.findViewById(R.id.et_search);
        tv_cancel = (TextView) v.findViewById(R.id.tv_cancel);
        xListView = (ListView) v.findViewById(R.id.xListView);
        rl_area = (RelativeLayout) v.findViewById(R.id.rl_area);
        tv_area = (TextView) v.findViewById(R.id.tv_area);
        rl_sort = (RelativeLayout) v.findViewById(R.id.rl_sort);
        tv_sort = (TextView) v.findViewById(R.id.tv_sort);
        rl_features = (RelativeLayout) v.findViewById(R.id.rl_features);
        tv_features = (TextView) v.findViewById(R.id.tv_features);
    }

    @Override
    public void onResume() {
        String newCityId = MyApplication.currentCity.getId();
        cityId = newCityId;
        params.put("cityId", cityId);
        HttpManager.getManager().requestHttpJson(getContext(), params, IURL.GET_CINEMA_LIST, this);

        super.onResume();
    }

    @Override
    public void onResponseSucceed(String json, String url) {
        CinemaListBean bean = HttpManager.getManager().decodeCinemaListByJson(json);
        list = bean.getCinemaDetailList();
        xListView.setAdapter(adapter);
        adapter.addDatas(list);
        xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CinemaListBean.CinemaDetail cinema = adapter.getItem(position);
                int cinemaId = cinema.getId();
                Intent intent = new Intent(getContext(), CinemaInfoActivity.class);
                intent.putExtra("cinemaId", cinemaId);
                intent.putExtra("cinemaName", cinema.getCname());
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void onResponseError(String volleyError) {

    }
}
