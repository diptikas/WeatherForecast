package com.diptika.weatherforecast.network;

import com.diptika.weatherforecast.base.BaseObservable;
import com.diptika.weatherforecast.base.RetrofitProvider;
import com.diptika.weatherforecast.model.response.CurrentWeatherResponse;
import com.diptika.weatherforecast.model.response.WeatherForecastResponse;

import io.reactivex.Single;

/**
 * Created by Diptika on 07/09/19.
 */
public class RestApiObservables extends BaseObservable {
    private final String apiKey = "9bf5a12dba894a6e917181335190609";

    private WeatherApi weatherApi = RetrofitProvider.getInstance().getRestApi();



    public Single<CurrentWeatherResponse> getCurrentWeatherResponse(String city) {
        return weatherApi
                .getCurrentWeather(apiKey,city)
                .compose(this.<CurrentWeatherResponse>applyCommonSchedulersSingle());
    }

    public Single<WeatherForecastResponse> getWeatherForecastResponse(String city, Integer days) {
        return weatherApi
                .getWeatherForecast(apiKey,city,days)
                .compose(this.<WeatherForecastResponse>applyCommonSchedulersSingle());
    }

}
