package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yuqs.filmticket.Entity.CityBean;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.R;

import java.util.List;


public class CityListAdapter extends BaseAdapter {
    OnSelectedCityListener listener;
    private Context context;
    private List<List<CityBean.CitysBean.City>> cities;
    private final int WORD = 0;
    private final int CITY = 1;

    public CityListAdapter(Context context, List<List<CityBean.CitysBean.City>> cities, OnSelectedCityListener listener) {
        this.context = context;
        this.cities = cities;
        this.listener = listener;
    }

    public List<List<CityBean.CitysBean.City>> getData() {
        return cities;
    }

    @Override
    public int getCount() {
        int count = 1;
        if (cities == null || cities.size() == 0) return count;
        count += cities.size();
        for (List<CityBean.CitysBean.City> datasBean : cities) {
            count += datasBean.size();
        }
        return count;
    }

    @Override
    public Object getItem(int position) {
        int count = 0;
        for (int i = 0; i < cities.size(); i++) {
            List<CityBean.CitysBean.City> addressList = cities.get(i);
            if (position == count) {
                return MyApplication.WORDS[i];
            }
            for (int j = 0; j < addressList.size(); j++) {
                count++;
                if (position == count) {
                    return addressList.get(j);
                }
            }
            count++;
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View wordView = null;
        View cityView = null;
        if (getItemViewType(position) == WORD) {
            WordViewHolder wordViewHolder;
            if (wordView == null) {
                wordViewHolder = new WordViewHolder();
                wordView = LayoutInflater.from(context).inflate(R.layout.item_layout_word, parent, false);
                wordViewHolder.textWord = (TextView) wordView.findViewById(R.id.textWord);
                wordView.setTag(wordViewHolder);
            } else {
                wordViewHolder = (WordViewHolder) wordView.getTag();
            }
            String strWord= (String) getItem(position);
            wordViewHolder.textWord.setText(strWord);
            return wordView;
        } else {
            CityViewHolder cityViewHolder;
            if (cityView == null) {
                cityViewHolder = new CityViewHolder();
                cityView = LayoutInflater.from(context).inflate(R.layout.item_layout_city, parent, false);
                cityViewHolder.textCity = (TextView) cityView.findViewById(R.id.textCity);
                cityView.setTag(cityViewHolder);
            } else {
                cityViewHolder = (CityViewHolder) cityView.getTag();
            }
            final CityBean.CitysBean.City city = (CityBean.CitysBean.City) getItem(position);
            cityViewHolder.textCity.setText(city.getCityName());
            cityViewHolder.textCity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onSelectedCity(city);
                }
            });
            return cityView;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int count = 0;
        for (int i = 0; i < cities.size(); i++) {
            if (position == count) {
                return WORD;
            }
            List<CityBean.CitysBean.City> addressList = cities.get(i);
            for (int j = 0; j < addressList.size(); j++) {
                count++;
                if (position == count) {
                    return CITY;
                }
            }
            count++;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    public interface OnSelectedCityListener {
        public void onSelectedCity(CityBean.CitysBean.City city);
    }

    class WordViewHolder {
        TextView textWord;
    }

    class CityViewHolder {
        TextView textCity;
    }
}
