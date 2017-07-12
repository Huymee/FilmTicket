package com.yuqs.filmticket.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuqs.filmticket.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment01 extends Fragment {
    private OnFragmentInteractionListener mListener;
    private Fragment fragment;
    private static ViewPager vPager;

    public MainFragment01() {
        // Required empty public constructor
    }

    public static void setCurrentPage(int index) {
        if (vPager != null)
            vPager.setCurrentItem(index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_page_01, container, false);
        vPager = (ViewPager) v.findViewById(R.id.vp_main_page01);
        FragmentPagerAdapter adapter = new FrgAdapter(getChildFragmentManager());
        vPager.setAdapter(adapter);
        vPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mListener != null) {
                    onViewPagerSelected(position);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return v;
    }

    class FrgAdapter extends FragmentPagerAdapter {
        FrgAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    fragment = new ChildFragmentPlaying();
                    break;
                case 1:
                    fragment = new ChildFragmentFuture();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * 通过此方法将ViewPager监听器里面onPageSelected获取的下标传到此类中
     */
    public void onViewPagerSelected(int content) {
        if (mListener != null) {
            mListener.onFragmentInteraction(content);
        }
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(int position);
    }
}
