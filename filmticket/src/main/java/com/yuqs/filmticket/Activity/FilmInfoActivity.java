package com.yuqs.filmticket.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.yuqs.filmticket.Adapter.HSVPicListAdapter;
import com.yuqs.filmticket.Entity.FilmInfoBean;
import com.yuqs.filmticket.Entity.FilmInfoBean.FilmInfo;
import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.Manager.DateManager;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.SetMyActionBar;
import com.yuqs.filmticket.View.HSVLayout;

import java.util.HashMap;
import java.util.Map;

public class FilmInfoActivity extends AppCompatActivity implements View.OnClickListener, HttpManager.OnRequestJsonListener {

    private String filmId;
    private int filmType;
    private TextView tvFilmType;
    private TextView tv_film_area;
    private TextView tv_film_time;
    private TextView tv_film_format;
    private TextView tv_play_time;
    private Button btn_buy;
    private TextView tv_upcoming_countdown;
    private ImageView iv_3d_imax;
    private TextView tv_directors;
    private TextView tv_actors;
    private HSVLayout gallery;
    private TextView tv_story;
    private RelativeLayout rl_upcoming_countdown;
    private NetworkImageView iv_icon;
    private TextView tv_score;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        filmId = intent.getStringExtra(IURL.ACTION_FILM_ID);
        filmType = intent.getIntExtra(IURL.ACTION_FILM_TYPE, 0);
        String filmName = intent.getStringExtra(IURL.ACTION_FILM_NAME);
        url = IURL.GET_FILM_INFO;
        setContentView(R.layout.activity_film);
        SetMyActionBar.setActionBar(this, getSupportActionBar(), filmName, true);
        initView();
        requestHttpInfo();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        iv_icon = (NetworkImageView) findViewById(R.id.iv_icon);
        //设置默认图片
        iv_icon.setDefaultImageResId(R.mipmap.ic_launcher);
        //设置加载错误时的图片
        iv_icon.setErrorImageResId(android.R.drawable.ic_delete);
        tv_score = (TextView) findViewById(R.id.tv_score);
        tvFilmType = (TextView) findViewById(R.id.tv_film_type);
        tv_film_area = (TextView) findViewById(R.id.tv_film_area);
        tv_film_time = (TextView) findViewById(R.id.tv_film_time);
        tv_film_format = (TextView) findViewById(R.id.tv_film_format);
        tv_play_time = (TextView) findViewById(R.id.tv_play_time);
        btn_buy = (Button) findViewById(R.id.btn_buy);
        rl_upcoming_countdown = (RelativeLayout) findViewById(R.id.rl_upcoming_countdown);
        tv_upcoming_countdown = (TextView) findViewById(R.id.tv_upcoming_countdown);
        iv_3d_imax = (ImageView) findViewById(R.id.iv_3d_imax);
        tv_directors = (TextView) findViewById(R.id.tv_directors);
        tv_actors = (TextView) findViewById(R.id.tv_actors);
        gallery = (HSVLayout) findViewById(R.id.hsv_film_pic_list);
        tv_story = (TextView) findViewById(R.id.tv_story);
    }

    private void requestHttpInfo() {
        Map<String, String> params = new HashMap<>();
        params.put(IURL.ACTION_FILM_ID, filmId);
        if (filmType == IURL.FILM_TYPE_FUTURE) {
            rl_upcoming_countdown.setVisibility(View.VISIBLE);
            btn_buy.setVisibility(View.GONE);
        } else {
            rl_upcoming_countdown.setVisibility(View.GONE);
            btn_buy.setVisibility(View.VISIBLE);
            if (filmType == IURL.FILM_TYPE_PLAYING) {
                btn_buy.setOnClickListener(this);
            } else {
                btn_buy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        }
        HttpManager.getManager().requestHttpJson(this, params, url, this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ChooseCinemaActivity.class);
        intent.putExtra(IURL.ACTION_FILM_ID, filmId);
        startActivity(intent);
    }


    private void setFilmInfo(FilmInfo film) {
        final String BIG3D = "巨幕3D";
        final String IMAX = "IMAX3D";
        final String TYPE_3D = "3D";
        final String TYPE_2D = "2D";
        //设置图片
        iv_icon.setImageUrl(film.getPictureThumb(), HttpManager.getManager().getImageLoader());
        iv_icon.setScaleType(ImageView.ScaleType.FIT_XY);
        tv_score.append(film.getScore() + "分");
        tv_actors.append(film.getActorName());
        tv_directors.append(film.getDirectorName());
        tv_film_area.append(film.getCountry());
        tvFilmType.append(film.getPixtype());
        tv_film_time.append(film.getPixlength() + "分钟");
        String fileType = film.getFileType();
        if (fileType.contains(BIG3D)) {
            tv_film_format.setText(BIG3D);
        } else if (fileType.contains(TYPE_3D)) {
            tv_film_format.setText(TYPE_3D);
        } else if (fileType.contains(TYPE_2D)) {
            tv_film_format.setText(TYPE_2D);
        } else {
            tv_film_format.setVisibility(View.GONE);
        }
        if (fileType.contains(IMAX)) {
            iv_3d_imax.setVisibility(View.VISIBLE);
        } else {
            iv_3d_imax.setVisibility(View.GONE);
        }
        tv_story.append(film.getGutdescipty());
        tv_play_time.append(film.getFshowtime());
        //TODO 设置离上映的天数
        tv_upcoming_countdown.setText(DateManager.getUpcomingDays(film.getFshowtime()));
    }


    @Override
    public void onResponseSucceed(String json, String url) {
        FilmInfoBean bean = HttpManager.getManager().decodeFilmInfoByJson(json);
        setFilmInfo(bean.getFilmInfo());
        HSVPicListAdapter adapter = new HSVPicListAdapter(this, bean.getPicList());
        int length = adapter.getCount();
        final String[] urls = new String[length];
        for (int i = 0; i < length; i++) {
            FilmInfoBean.PicListBean picListBean = adapter.getItem(i);
            urls[i] = picListBean.getPicture();
        }
        gallery.setAdapter(adapter, 10, 0, 10, 0);
        gallery.setOnItemClickListener(new HSVLayout.OnItemClickListener() {
            @Override
            public void onItemClick(View item, int position) {
                Intent intent = new Intent(FilmInfoActivity.this, FilmPicListActivity.class);//跳转到剧照查看页面
                intent.putExtra("index", position);
                intent.putExtra("urls", urls);
                FilmInfoActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    public void onResponseError(String volleyError) {

    }
}
