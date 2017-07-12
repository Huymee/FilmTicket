package com.yuqs.filmticket.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuqs.filmticket.Activity.MainActivity1;
import com.yuqs.filmticket.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment01a extends Fragment implements MainActivity1.OnAbarCheckedChangeListener {

    private ChildFragmentPlaying fragmentPlaying;
    private ChildFragmentFuture fragmentFuture;

    public MainFragment01a() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_page_01a, container, false);

        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction tran = fm.beginTransaction();

        fragmentPlaying = new ChildFragmentPlaying();
        fragmentFuture = new ChildFragmentFuture();
        //R.id.relative为布局
        tran.add(R.id.vp_main_page01, fragmentPlaying, "index").show(fragmentPlaying)
                .add(R.id.vp_main_page01, fragmentFuture, "bill").hide(fragmentFuture);
        tran.commit();
        return v;
    }

    @Override
    public void onAbarCheckedChanged(int index) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction tran = fm.beginTransaction();
        switch (index){
            case 0:tran.show(fragmentPlaying);
                tran.hide(fragmentFuture);
                break;
            case 1:tran.show(fragmentFuture);
                tran.hide(fragmentPlaying);
                break;
        }
        tran.commit();
    }
}
