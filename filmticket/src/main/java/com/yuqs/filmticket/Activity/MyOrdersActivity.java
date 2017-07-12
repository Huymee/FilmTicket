package com.yuqs.filmticket.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yuqs.filmticket.Fragment.MyOrderFinishFragment;
import com.yuqs.filmticket.Fragment.MyOrderUnpaidFragment;
import com.yuqs.filmticket.Fragment.MyOrderUnpickFragment;
import com.yuqs.filmticket.Listener.MyOnPageChangeListener;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.SetMyActionBar;

public class MyOrdersActivity extends AppCompatActivity {

    private RadioGroup rgMyOrders;
    private ViewPager vpMyOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        SetMyActionBar.setActionBar(this,getSupportActionBar(),getResources().getString(R.string.my_order),true);
        vpMyOrders = (ViewPager) findViewById(R.id.vp_my_orders);
        setViewPager(vpMyOrders);
        rgMyOrders = (RadioGroup) findViewById(R.id.rg_my_orders);
        rgMyOrders.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (vpMyOrders != null)
                    vpMyOrders.setCurrentItem(group.indexOfChild(group.findViewById(checkedId)));
            }
        });
        ((RadioButton) rgMyOrders.getChildAt(0)).setChecked(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    private void setViewPager(ViewPager viewPager) {
        FragmentPagerAdapter adapter = new FragAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (rgMyOrders != null)
                    ((RadioButton) rgMyOrders.getChildAt(position)).setChecked(true);
            }
        });
    }

    class FragAdapter extends FragmentPagerAdapter {
        FragAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MyOrderUnpaidFragment();
                case 1:
                    return new MyOrderUnpickFragment();
                case 2:
                    return new MyOrderFinishFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
