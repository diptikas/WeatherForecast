package com.diptika.weatherforecast.domain;

import com.diptika.weatherforecast.base.BasePresenterContract;
import com.diptika.weatherforecast.model.response.CurrentWeatherResponse;
import com.diptika.weatherforecast.model.response.WeatherForecastResponse;

/**
 * Created by Diptika on 07/09/19.
 */
public class WeatherContract {

    public interface View {
        void notifyDataSetChanged();

        void onError(String errMsg);

        void showCurrentWeatherData(CurrentWeatherResponse currentWeatherResponse);

        void showWeatherForecastData(WeatherForecastResponse weatherForecastResponse);

    }

    public interface Presenter extends BasePresenterContract {
        void getCurrentWeatherData(String city);

        void getWeatherForecastData(String city, int days);

        void onCurrentWeatherDataFetched(CurrentWeatherResponse currentWeatherResponse);

        void onWeatherForecastDataFetched(WeatherForecastResponse weatherForecastResponse);
    }

    public interface CurrentWeatherApiContract {
        void getCurrentWeatherInfo(String city);
    }

    public interface WeatherForecastApiContract {
        void getWeatherForecastInfo(String city,int days);

    }
}
