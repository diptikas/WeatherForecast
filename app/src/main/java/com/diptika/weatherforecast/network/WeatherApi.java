package com.diptika.weatherforecast.network;

import com.diptika.weatherforecast.model.response.CurrentWeatherResponse;
import com.diptika.weatherforecast.model.response.WeatherForecastResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Diptika on 07/09/19.
 */
public interface WeatherApi {

    @GET(WeatherApiConstants.CURRENT)
    Single<CurrentWeatherResponse> getCurrentWeather(@Query("key") String apiKey,
                                                             @Query("q") String city);


    @GET(WeatherApiConstants.FORECAST)
    Single<WeatherForecastResponse> getWeatherForecast(@Query("key") String apiKey,
                                                               @Query("q") String city,
                                                               @Query("days") Integer days);



}
