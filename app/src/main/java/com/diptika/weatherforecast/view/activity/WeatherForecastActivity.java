package com.diptika.weatherforecast.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.diptika.weatherforecast.R;
import com.diptika.weatherforecast.domain.CurrentWeatherInteractor;
import com.diptika.weatherforecast.domain.WeatherContract;
import com.diptika.weatherforecast.domain.WeatherForecastInteractor;
import com.diptika.weatherforecast.domain.WeatherPresenter;
import com.diptika.weatherforecast.model.response.CurrentWeatherResponse;
import com.diptika.weatherforecast.model.response.Forecastday;
import com.diptika.weatherforecast.model.response.WeatherForecastResponse;
import com.diptika.weatherforecast.view.adapter.WeatherForecastAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diptika on 07/09/19.
 */
public class WeatherForecastActivity extends AppCompatActivity implements WeatherContract.View {
    public static final String TAG=WeatherForecastActivity.class.getName();
    public static final int DELAY=5000;
    public static final int DAYS=4;
    public static final String CITY="Bangalore";

    private WeatherPresenter weatherPresenter;
    private TextView tvCurrentWeather;
    private TextView tvCity;
    private RelativeLayout rlError,rlLoading;
    private LinearLayout llWeatherInfo;
    private RecyclerView rvWeatherForecast;
    private WeatherForecastAdapter weatherForecastAdapter;
    private List<Forecastday> weatherForecastResponseList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_forecast);
        initView();
        initPresenter();
    }

    /**
     * initialize view
     */
    private void initView() {
        if(getSupportActionBar()!=null) {
            getSupportActionBar().hide();
        }
        tvCurrentWeather=findViewById(R.id.tv_current_weather);
        tvCity=findViewById(R.id.tv_city);
        rlError=findViewById(R.id.rl_error);
        rlLoading=findViewById(R.id.rl_loading);
        llWeatherInfo=findViewById(R.id.ll_weather_info);
        rvWeatherForecast=findViewById(R.id.rv_weather_forecast);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvWeatherForecast.setLayoutManager(linearLayoutManager);
        weatherForecastResponseList = new ArrayList<>();
        weatherForecastAdapter = new WeatherForecastAdapter(this,weatherForecastResponseList);
        rvWeatherForecast.setAdapter(weatherForecastAdapter);


    }

    //initializing presenter
    private void initPresenter(){
        weatherPresenter = new WeatherPresenter(new CurrentWeatherInteractor(),new WeatherForecastInteractor());
        weatherPresenter.subscribeView(this);
        //get current weather info
        showLoadingView();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                weatherPresenter.getCurrentWeatherData(CITY);
            }
        },DELAY); // wait for 5 seconds

    }



    @Override
    public void onError(String errMsg) {
      showErrorView();
    }

    /**
     * Update UI
     * @param currentWeatherResponse
     */
    @Override
    public void showCurrentWeatherData(CurrentWeatherResponse currentWeatherResponse) {
        if(currentWeatherResponse!=null) {
            showWeatherView();
            String temp = String.valueOf(currentWeatherResponse.getCurrent()!=null?
                    (int)currentWeatherResponse.getCurrent().getTemp_c():0) + "\u00B0";

            tvCurrentWeather.setText(temp);

            tvCity.setText(currentWeatherResponse.getLocation()!=null &&
                    !TextUtils.isEmpty(currentWeatherResponse.getLocation().getName()) ?
                    currentWeatherResponse.getLocation().getName() : CITY);
        }else {
           showErrorView();
        }
        weatherPresenter.getWeatherForecastData(CITY,DAYS);

    }


    @Override
    public void showWeatherForecastData(WeatherForecastResponse weatherForecastResponse) {
     if(weatherForecastResponse!=null && weatherForecastResponse.getForecast()!=null){
         weatherForecastResponseList.addAll(weatherForecastResponse.getForecast().getForecastday());
     }
     weatherForecastAdapter.notifyDataSetChanged();
    }

    private void showErrorView(){
        llWeatherInfo.setVisibility(View.GONE);
        rlLoading.setVisibility(View.GONE);
        rlError.setVisibility(View.VISIBLE);
    }

    private void showLoadingView(){
        llWeatherInfo.setVisibility(View.GONE);
        rlLoading.setVisibility(View.VISIBLE);
        rlError.setVisibility(View.GONE);
    }

    private void showWeatherView(){
        llWeatherInfo.setVisibility(View.VISIBLE);
        rlLoading.setVisibility(View.GONE);
        rlError.setVisibility(View.GONE);
    }


    @Override
    protected void onDestroy() {
        if (weatherPresenter.wasSubscribed(this)) {
            weatherPresenter.unsubscribeView(this);
        }
        super.onDestroy();
    }


}
