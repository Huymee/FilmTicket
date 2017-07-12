package com.yuqs.filmticket.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.yuqs.filmticket.Fragment.MainFragment01;
import com.yuqs.filmticket.Fragment.MainFragment01.OnFragmentInteractionListener;
import com.yuqs.filmticket.Fragment.MainFragment01a;
import com.yuqs.filmticket.Fragment.MainFragment02;
import com.yuqs.filmticket.Fragment.MainFragment03;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.R;

public class MainActivity1 extends AppCompatActivity {

    private View tagView;
    private RadioGroup tabGroup;
    private Button btnCity;
    private MainFragment01a fragment01;
    private OnAbarCheckedChangeListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup bottomGroup = (RadioGroup) findViewById(R.id.rg_film_bottom);
        bottomGroup.setOnCheckedChangeListener(bottomListener);
        tagView = View.inflate(this, R.layout.abar_film_relativelayout, null);
        btnCity = (Button) tagView.findViewById(R.id.btn_abar_city);
        tabGroup = (RadioGroup) tagView.findViewById(R.id.rg_film_tab);
        fragment01 = new MainFragment01a();
        ((RadioButton) bottomGroup.findViewById(R.id.rb_film_bottom_a)).setChecked(true);
        ((RadioButton) tabGroup.findViewById(R.id.rb_film_tab_1)).setChecked(true);

    }

    @Override
    protected void onResume() {
        checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        String city = MyApplication.currentCity.getCityName();
        if (TextUtils.isEmpty(city)) {
            startActivity(new Intent(this, CityListActivity.class));
        } else {
            btnCity.setText(city);
        }
        if (fragment01 instanceof OnAbarCheckedChangeListener) {
            mListener = fragment01;
        } else {
            throw new RuntimeException(fragment01.toString()
                    + " must implement OnAbarCheckedChangeListener");
        }
        super.onResume();
    }

    /**
     * 检查用户权限
     */
    private void checkPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{permission}, 100);//这里的100是一个执行代码
            } else
                return;//获取权限后执行自己的方法
        } else return;//版本低于Android 6.0,不需要检查运行时权限,直接执行操作
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 100://对应上面定义的执行代码
                if (permissions.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须获得所需的权限才能使用此功能", Toast.LENGTH_SHORT).show();
                        } else return;//获取权限后执行自己的方法
                    }
                } else {
                    Toast.makeText(this, "必须获得所需的权限才能使用此功能", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void chooseCity(View v) {
        startActivity(new Intent(MainActivity1.this, CityListActivity.class));
    }

    private boolean isPressed = false;

    @Override
    public void onBackPressed() {
        if (isPressed)
            super.onBackPressed();
        else {
            isPressed = true;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            Handler handler = new Handler(getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isPressed = false;
                }
            }, 3000);
        }
    }

    OnCheckedChangeListener tabListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int checkedIndex = group.indexOfChild(findViewById(checkedId));
            if (mListener != null) mListener.onAbarCheckedChanged(checkedIndex);
        }
    };

    public interface OnAbarCheckedChangeListener {
        void onAbarCheckedChanged(int index);
    }

    OnCheckedChangeListener bottomListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment frg01 = fm.findFragmentByTag("frg1");
            Fragment frg02 = fm.findFragmentByTag("frg2");
            Fragment frg03 = fm.findFragmentByTag("frg3");
            ActionBar aBar = getSupportActionBar();
            TextView tvTitle = (TextView) View.inflate(MainActivity1.this, R.layout.abar_title, null);
            if (aBar != null) {
                aBar.setDisplayShowCustomEnabled(true);
                aBar.setDisplayShowTitleEnabled(false);
            }
            switch (checkedId) {
                case R.id.rb_film_bottom_a:
                    tabGroup.setOnCheckedChangeListener(tabListener);
                    ((RadioButton) tabGroup.findViewById(R.id.rb_film_tab_1)).setChecked(true);
                    if (aBar != null) aBar.setCustomView(tagView, new ActionBar.LayoutParams(
                            ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER));
                    if (frg02 != null) ft.detach(frg02);
                    if (frg03 != null) ft.detach(frg03);
                    if (frg01 == null) ft.add(R.id.rl_main, fragment01, "frg1");
                    else ft.attach(frg01);
                    ft.commit();
                    break;
                case R.id.rb_film_bottom_b:
                    tvTitle.setText(getResources().getString(R.string.cinemas));
                    if (aBar != null) aBar.setCustomView(tvTitle, new ActionBar.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
                    if (frg01 != null) ft.detach(frg01);
                    if (frg03 != null) ft.detach(frg03);
                    if (frg02 == null) ft.add(R.id.rl_main, new MainFragment02(), "frg2");
                    else ft.attach(frg02);
                    ft.commit();
                    break;
                case R.id.rb_film_bottom_c:
                    tvTitle.setText(getResources().getString(R.string.my));
                    if (aBar != null) aBar.setCustomView(tvTitle, new ActionBar.LayoutParams(
                            ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
                    if (frg01 != null) ft.detach(frg01);
                    if (frg02 != null) ft.detach(frg02);
                    if (frg03 == null) ft.add(R.id.rl_main, new MainFragment03(), "frg3");
                    else ft.attach(frg03);
                    ft.commit();
                    break;
            }
        }
    };
}