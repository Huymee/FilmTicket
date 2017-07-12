package com.yuqs.filmticket.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuqs.filmticket.Activity.FeedBackActivity;
import com.yuqs.filmticket.Activity.LoginActivity;
import com.yuqs.filmticket.Activity.MyDiscountActivity;
import com.yuqs.filmticket.Activity.MyOrdersActivity;
import com.yuqs.filmticket.Activity.MyRechargeActivity;
import com.yuqs.filmticket.Activity.SettingActivity;
import com.yuqs.filmticket.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment03 extends Fragment implements View.OnClickListener {

    public MainFragment03() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main_page_03, container, false);
        View viewLogin = view.findViewById(R.id.ll_user_logon);
        View viewMyOrder = view.findViewById(R.id.ll_my_order);
        View viewMyDiscount = view.findViewById(R.id.ll_my_discount);
        View viewMyRecharge = view.findViewById(R.id.ll_my_recharge);
        View viewSetting = view.findViewById(R.id.ll_main_setting);
        View viewFeedback = view.findViewById(R.id.ll_feedback);
        viewLogin.setOnClickListener(this);
        viewMyOrder.setOnClickListener(this);
        viewMyDiscount.setOnClickListener(this);
        viewMyRecharge.setOnClickListener(this);
        viewSetting.setOnClickListener(this);
        viewFeedback.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_user_logon:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.ll_my_order:
                startActivity(new Intent(getActivity(), MyOrdersActivity.class));
                break;
            case R.id.ll_my_discount:
                startActivity(new Intent(getActivity(), MyDiscountActivity.class));
                break;
            case R.id.ll_my_recharge:
                startActivity(new Intent(getActivity(), MyRechargeActivity.class));
                break;
            case R.id.ll_main_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.ll_feedback:
                startActivity(new Intent(getActivity(), FeedBackActivity.class));
                break;
        }
    }
}
