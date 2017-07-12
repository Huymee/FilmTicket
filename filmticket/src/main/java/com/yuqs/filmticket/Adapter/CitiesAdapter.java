package com.yuqs.filmticket.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuqs.filmticket.Entity.CityBean;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.R;

import java.util.List;


public class CitiesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    OnSelectedCityListener listener;
    private Context context;
    private List<List<CityBean.CitysBean.City>> cities;
    private final int WORD = 1;
    private final int CITY = 2;

    public CitiesAdapter(Context context, List<List<CityBean.CitysBean.City>> cities,OnSelectedCityListener listener){
        this.context = context;
        this.cities = cities;
        this.listener=listener;
    }

    public List<List<CityBean.CitysBean.City>> getData() {
        return cities;
    }

    @Override
    public int getItemCount() {
        int count = 1;
        if(cities==null || cities.size()==0) return count;
        count +=cities.size();
        for(List<CityBean.CitysBean.City> datasBean:cities){
            count += datasBean.size();
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        int count = 0;

        for(int i = 0; i < cities.size(); i++){
            if(position==count){
                return WORD;
            }
            List<CityBean.CitysBean.City> addressList = cities.get(i);
            for(int j =0;j<addressList.size();j++){
                count++;
                if(position==count){
                    return CITY;
                }
            }
            count++;
        }
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case WORD:
                View word = LayoutInflater.from(context).inflate(R.layout.item_layout_word, parent, false);
                return new WordViewHolder(word);
            case CITY:
                View city = LayoutInflater.from(context).inflate(R.layout.item_layout_city, parent, false);
                return new CityViewHolder(city);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int count = 0;
        for(int i = 0; i < cities.size(); i++){
            if(position==count){
                WordViewHolder wordViewHolder = (WordViewHolder) holder;
                wordViewHolder.textWord.setText(MyApplication.WORDS[i]);
            }
            List<CityBean.CitysBean.City> addressList = cities.get(i);
            for(int j =0;j<addressList.size();j++){
                count++;
                if(position==count){
                    CityViewHolder cityViewHolder = (CityViewHolder) holder;
                    final CityBean.CitysBean.City addressListBean = addressList.get(j);
                    cityViewHolder.textCity.setText(addressListBean.getCityName());
                    cityViewHolder.textCity.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MyApplication.currentCity=addressListBean;
                            listener.onSelectedCity(addressListBean);
                        }
                    });
                }
            }
            count++;
        }
    }
    public interface OnSelectedCityListener {
       public void onSelectedCity(CityBean.CitysBean.City city);
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {
        TextView textWord;
        public WordViewHolder(View view) {
            super(view);
            textWord = (TextView) view.findViewById(R.id.textWord);
        }
    }
    public static class CityViewHolder extends RecyclerView.ViewHolder {
        TextView textCity;
        public CityViewHolder(View view) {
            super(view);
            textCity = (TextView) view.findViewById(R.id.textCity);
        }
    }
}
