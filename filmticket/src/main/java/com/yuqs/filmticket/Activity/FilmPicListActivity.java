package com.yuqs.filmticket.Activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.NetworkImageView;
import com.yuqs.filmticket.Manager.HttpManager;
import com.yuqs.filmticket.R;

public class FilmPicListActivity extends AppCompatActivity {

    private int index;
    private String[] urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        index = intent.getIntExtra("index", 0);
        urls = intent.getStringArrayExtra("urls");
        setContentView(R.layout.activity_film_pic_list);
        initView();
    }

    private void initView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_film_pic);
        MyFilmPicPagerAdapter adapter = new MyFilmPicPagerAdapter(urls);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(index);
    }

    class MyFilmPicPagerAdapter extends PagerAdapter {

        private String[] urls;

        public MyFilmPicPagerAdapter(String[] urls) {
            this.urls=urls;
        }

        @Override
        public int getCount() {
            return urls.length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(FilmPicListActivity.this).inflate(R.layout.item_film_pic_view_pager, null);
            NetworkImageView imageView = (NetworkImageView) view.findViewById(R.id.iv_film_pic);
            imageView.setImageUrl(urls[position], HttpManager.getManager().getImageLoader());
            container.addView(view, 0);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
