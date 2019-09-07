package com.diptika.weatherforecast.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.diptika.weatherforecast.R;
import com.diptika.weatherforecast.model.response.Forecastday;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Diptika on 07/09/19.
 */
public class WeatherForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Forecastday> weatherForecastResponseList;

    public WeatherForecastAdapter(Context context,List<Forecastday> weatherForecastResponseList) {
        this.context=context;
        this.weatherForecastResponseList = weatherForecastResponseList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_weather_forecast, null);
        return new WeatherForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((WeatherForecastViewHolder) viewHolder).bindData(weatherForecastResponseList.get(position));

    }

    @Override
    public int getItemCount() {
        return weatherForecastResponseList != null ? weatherForecastResponseList.size() : 0;

    }

    public static class WeatherForecastViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTemp,tvDay;

        public WeatherForecastViewHolder(View itemView) {
            super(itemView);
            tvTemp=itemView.findViewById(R.id.tv_temp);
            tvDay=itemView.findViewById(R.id.tv_day);
        }

        public void bindData(Forecastday forecastday) {
            String temp = String.valueOf(forecastday.getDay()!=null?
                    (int)forecastday.getDay().getAvgtemp_c():0) + "\u2103";

            tvTemp.setText(temp);

            SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
            String dayOfTheWeek="";
            try {
                Date date=format1.parse(forecastday.getDate());
                dayOfTheWeek = (String) DateFormat.format("EEEE", date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tvDay.setText(!TextUtils.isEmpty(dayOfTheWeek)?dayOfTheWeek:"");
        }


    }

}