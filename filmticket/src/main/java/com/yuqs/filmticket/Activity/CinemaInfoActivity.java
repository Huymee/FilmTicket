package com.yuqs.filmticket.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yuqs.filmticket.Adapter.DateListAdapter;
import com.yuqs.filmticket.Adapter.HAVFilmAdapter;
import com.yuqs.filmticket.Adapter.HSVBaseAdapter;
import com.yuqs.filmticket.Adapter.MyBaseAdapter;
import com.yuqs.filmticket.Adapter.PlanAdapter;
import com.yuqs.filmticket.Entity.CinemaInfoBean;
import com.yuqs.filmticket.Entity.FilmPlanBean;
import com.yuqs.filmticket.Entity.FilmPlayingBean;
import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.Manager.DateManager;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.SetMyActionBar;
import com.yuqs.filmticket.View.HSVLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CinemaInfoActivity extends AppCompatActivity implements HttpManager.OnRequestJsonListener {

    private RelativeLayout rl_cinema_info;
    private TextView tv_cinema_name;
    private TextView tv_cinema_address;
    private RadioGroup rg_film_tab;
    private View layout_tickets;
    private View layout_activies;
    private ImageView iv_no_plan;
    private View layout_tickets_content;
    private HSVLayout hsv_film_list;
    private RelativeLayout rl_film_name;
    private TextView tv_film_score;
    private TextView tv_film_name;
    private HSVLayout hsv_date_list;
    private ImageView iv_day_plan_no_data;
    private ListView lv_plan;
    private WebView webview;
    private ProgressBar webview_progressbar;
    private int cinemaId;
    private String filmID;
    private Map<String, String> map = new HashMap<>();
    private long time = System.currentTimeMillis();
    private Date date = new Date(time);
    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String dateStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 0);
        filmID = intent.getStringExtra(IURL.ACTION_FILM_ID);

        map.put("cinemaID", String.valueOf(cinemaId));
        HttpManager.getManager().requestHttpJson(this, map, IURL.GET_CINEMA_INFO_BY_ID, this);
        Map<String, String> filmMap = new HashMap<>();
        filmMap.put("cinemaId", String.valueOf(cinemaId));
        HttpManager.getManager().requestHttpJson(this, filmMap, IURL.GET_HOT_FILM_BY_CINEMA_ID, this);
        dateStr = dateFormat.format(date);
        planMap = new HashMap<>();
        planMap.put("filmId", filmID);
        planMap.put("cinemaID", String.valueOf(cinemaId));
        planMap.put("curDate", dateStr);
        planMap.put("mgroupId", "0");
        requestPlan(planMap);
        setContentView(R.layout.activity_cinema_info);
        SetMyActionBar.setActionBar(this, getSupportActionBar(), intent.getStringExtra("cinemaName"), true);
        initView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        //电影院信息 点击进入电影院信息界面
        rl_cinema_info = (RelativeLayout) findViewById(R.id.rl_cinema_info);
        //电影院名字
        tv_cinema_name = (TextView) findViewById(R.id.tv_cinema_name);
        //电影院地址
        tv_cinema_address = (TextView) findViewById(R.id.tv_cinema_address);
        rg_film_tab = (RadioGroup) findViewById(R.id.rg_film_tab);
        layout_tickets = findViewById(R.id.layout_tickets);
        layout_activies = findViewById(R.id.layout_activies);
//        iv_no_plan = (ImageView) findViewById(R.id.iv_no_plan);
//        layout_tickets_content = findViewById(R.id.layout_tickets_content);
        hsv_film_list = (HSVLayout) findViewById(R.id.hsv_film_list);
        //电影信息 点击进入电影信息界面
        rl_film_name = (RelativeLayout) findViewById(R.id.rl_film_name);
        //电影评分
        tv_film_score = (TextView) findViewById(R.id.tv_film_score);
        //电影名
        tv_film_name = (TextView) findViewById(R.id.tv_film_name);
        //放映日期计划
        hsv_date_list = (HSVLayout) findViewById(R.id.hsv_date_list);
        iv_day_plan_no_data = (ImageView) findViewById(R.id.iv_day_plan_no_data);
        lv_plan = (ListView) findViewById(R.id.lv_plan);
        //活动界面
        webview = (WebView) findViewById(R.id.webview);
        webview_progressbar = (ProgressBar) findViewById(R.id.webview_progressbar);
        DateListAdapter listAdapter = new DateListAdapter(this, DateManager.getDateList());
        hsv_date_list.setAdapter(listAdapter, 8, 4, 8, 4);
        hsv_date_list.setOnItemSelectedListener(new HSVLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(View item, int position) {
                // 改变日期
                calendar.setTime(date);
                calendar.add(Calendar.DATE, position);
                Date date1 = calendar.getTime();
                dateStr = dateFormat.format(date1);
                planMap.put("curDate", dateStr);
                requestPlan(planMap);
            }
        }, Color.LTGRAY);
        hsv_date_list.setItemSelected(0);

    }

    @Override
    protected void onStart() {
        rg_film_tab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (group.indexOfChild(findViewById(checkedId))) {
                    case 0:
                        layout_tickets.setVisibility(View.VISIBLE);
                        layout_activies.setVisibility(View.GONE);
                        break;
                    case 1:
                        layout_activies.setVisibility(View.VISIBLE);
                        layout_tickets.setVisibility(View.GONE);
                        break;
                }
            }
        });
        ((RadioButton) rg_film_tab.getChildAt(0)).setChecked(true);

        super.onStart();
    }

    private void requestPlan(Map<String, String> map) {
        HttpManager.getManager().requestHttpJson(this, map, IURL.GET_FILM_PLAN, this);
    }

    @Override
    public void onResponseSucceed(String json, String url) {
        switch (url) {
            case IURL.GET_CINEMA_INFO_BY_ID:
                CinemaInfoBean cinemaInfoBean = HttpManager.getManager().decodeCinemaInfoByJson(json);
                CinemaInfoBean.CinemaInfo cinemaInfo = cinemaInfoBean.getCinema();
                tv_cinema_name.setText(cinemaInfo.getCname());
                tv_cinema_address.setText(cinemaInfo.getAddress());
                rl_cinema_info.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO 实现点击跳转到影院详情页面
                    }
                });
                break;
            case IURL.GET_HOT_FILM_BY_CINEMA_ID:
                FilmPlayingBean filmPlayingBean = HttpManager.getManager().decodePlayingFilmByJson(json);
                final List<FilmPlayingBean.PlayingFilm> list = filmPlayingBean.getData();
                int filmPosition = 0;
                if (filmID != null) {
                    for (int i = 0; i < list.size(); i++) {
                        FilmPlayingBean.PlayingFilm bean = list.get(i);
                        if (filmID.equals(bean.getFilmID())) {
                            filmPosition = i;
                            break;
                        }
                    }
                }
                HSVBaseAdapter adapter = new HAVFilmAdapter(this, list);
                hsv_film_list.setAdapter(adapter, 0, 0, 0, 0);
                hsv_film_list.setOnItemSelectedListener(new HSVLayout.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(View item, int position) {
                        final FilmPlayingBean.PlayingFilm film = list.get(position);
                        tv_film_name.setText(film.getChname());
                        tv_film_score.setText(film.getScore() + "分");
                        rl_film_name.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(CinemaInfoActivity.this, FilmInfoActivity.class);
                                intent.putExtra(IURL.ACTION_FILM_ID, film.getFilmID());
                                intent.putExtra(IURL.ACTION_FILM_TYPE, IURL.FILM_TYPE_CHOSEN_CINEMA);
                                startActivity(intent);
                            }
                        });
                        planMap.put("filmId", film.getFilmID());
                        requestPlan(planMap);
                    }
                }, Color.LTGRAY);
                hsv_film_list.setItemSelected(filmPosition);
                break;
            case IURL.GET_FILM_PLAN:
                MyBaseAdapter<FilmPlanBean.DataBean.FilmPlan> planAdapter = new PlanAdapter(this);
                FilmPlanBean filmPlanBean = HttpManager.getManager().decodeFilmPlanByJson(json);
                List<FilmPlanBean.DataBean.FilmPlan> filmPlan = filmPlanBean.getData().getList();
                planAdapter.addDatas(filmPlan);
                lv_plan.setAdapter(planAdapter);
                int totalHeight = getTotalHeight(planAdapter);
                //设置listView的高度
                lv_plan.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, totalHeight));
//                lv_plan.invalidate();
//                planAdapter.notifyDataSetChanged();
                break;
        }

    }

    public int getTotalHeight(MyBaseAdapter planAdapter) {
        int totalHeight = 0;
        for (int i = 0; i < planAdapter.getCount(); i++) {
            View view = planAdapter.getView(i, null, lv_plan);
            view.measure(0, 0);
            totalHeight += view.getMeasuredHeight();
        }
        return totalHeight;
    }

    private Map<String, String> planMap;

    @Override
    public void onResponseError(String volleyError) {

    }
}
