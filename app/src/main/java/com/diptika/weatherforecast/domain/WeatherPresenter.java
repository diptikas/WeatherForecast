package com.diptika.weatherforecast.domain;

import com.diptika.weatherforecast.base.BasePresenter;
import com.diptika.weatherforecast.model.response.CurrentWeatherResponse;
import com.diptika.weatherforecast.model.response.WeatherForecastResponse;

import java.util.List;

/**
 * Created by Diptika on 07/09/19.
 */
public class WeatherPresenter extends BasePresenter<WeatherContract.View> implements
        WeatherContract.Presenter {

    private CurrentWeatherInteractor currentWeatherInteractor;
    private WeatherForecastInteractor weatherForecastInteractor;

    public WeatherPresenter(CurrentWeatherInteractor currentWeatherInteractor,
                            WeatherForecastInteractor weatherForecastInteractor) {
        this.currentWeatherInteractor = currentWeatherInteractor;
        this.weatherForecastInteractor = weatherForecastInteractor;
    }


    /**
     * Subscribe the interactors
     */
    @Override
    public void subscribeInteractor() {
        subscribeInteractor(currentWeatherInteractor, this);
        subscribeInteractor(weatherForecastInteractor, this);
    }

    /**
     *
     * @param throwable
     */
    @Override
    public void onError(Throwable throwable) {
        if (getViewContract() != null) {
            getViewContract().onError(throwable.getMessage());
        }
    }

    /**
     * Get current weather info by city name
     * @param city
     */
    @Override
    public void getCurrentWeatherData(String city) {
        if (getViewContract() != null) {
            currentWeatherInteractor.getCurrentWeatherInfo(city);
        }

    }

    /**
     * Fetched current weather info by city name
     * @param currentWeatherResponse
     */
    @Override
    public void onCurrentWeatherDataFetched(CurrentWeatherResponse currentWeatherResponse) {
        if (getViewContract() != null) {
            getViewContract().showCurrentWeatherData(currentWeatherResponse);
        }

    }


    /**
     * Get forecast weather info by city name and days
     * @param city
     * @param days
     */
    @Override
    public void getWeatherForecastData(String city, int days) {
        if (getViewContract() != null) {
            weatherForecastInteractor.getWeatherForecastInfo(city,days);
        }

    }

    /**
     * Fetched forecast weather info by city name and days
     * @param weatherForecastResponse
     */
    @Override
    public void onWeatherForecastDataFetched(WeatherForecastResponse weatherForecastResponse) {
        if (getViewContract() != null) {
            getViewContract().showWeatherForecastData(weatherForecastResponse);
        }
    }
}
