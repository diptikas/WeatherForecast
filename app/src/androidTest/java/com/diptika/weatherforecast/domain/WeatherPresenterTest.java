package com.diptika.weatherforecast.domain;

import com.diptika.weatherforecast.model.response.CurrentWeatherResponse;
import com.diptika.weatherforecast.model.response.WeatherForecastResponse;
import com.diptika.weatherforecast.view.activity.WeatherForecastActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Diptika on 07/09/19.
 */
public class WeatherPresenterTest {
    private CurrentWeatherInteractor currentWeatherInteractor;
    private WeatherForecastInteractor weatherForecastInteractor;
    private WeatherPresenter weatherPresenter;

    @Before
    public void setUp() throws Exception {
        currentWeatherInteractor = mock(CurrentWeatherInteractor.class);
        weatherForecastInteractor = mock(WeatherForecastInteractor.class);
        weatherPresenter = new WeatherPresenter(currentWeatherInteractor,weatherForecastInteractor);
        weatherPresenter.subscribeView(mock(WeatherForecastActivity.class));
    }

    @After
    public void tearDown() throws Exception {
        //todo cross check here
    }

    @Test
    public void getCurrentWeatherData() {
        weatherPresenter.getCurrentWeatherData("Bangalore");
    }

    @Test
    public void onCurrentWeatherDataFetched() {
        CurrentWeatherResponse currentWeatherResponse = mock(CurrentWeatherResponse.class);
        weatherPresenter.onCurrentWeatherDataFetched(currentWeatherResponse);

    }

    @Test
    public void getWeatherForecastData() {
        weatherPresenter.getWeatherForecastData("Bangalore", 6);
    }

    @Test
    public void onWeatherForecastDataFetched() {
        WeatherForecastResponse weatherForecastResponse = mock(WeatherForecastResponse.class);
        weatherPresenter.onWeatherForecastDataFetched(weatherForecastResponse);
    }
}