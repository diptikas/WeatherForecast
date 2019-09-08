package com.diptika.weatherforecast.domain;

import com.diptika.weatherforecast.model.response.WeatherForecastResponse;
import com.diptika.weatherforecast.network.RestApiObservables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Diptika on 08/09/19.
 */
public class WeatherForecastInteractorTest {
    private RestApiObservables restApiObservables;
    private WeatherForecastInteractor weatherForecastInteractor;

    @Before
    public void setUp() throws Exception {
        restApiObservables = mock(RestApiObservables.class);
        weatherForecastInteractor = new WeatherForecastInteractor();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getWeatherForecastInfo(){
        weatherForecastInteractor.getWeatherForecastInfo("Bngalore", 6);
    }

    @Test
    public void SuccessTest(){
        WeatherForecastResponse weatherForecastResponse = mock(WeatherForecastResponse.class);
        weatherForecastInteractor.onSuccess(weatherForecastResponse);
    }

    @Test
    public void onErrorTest(){
        WeatherForecastResponse weatherForecastResponse = mock(WeatherForecastResponse.class);
        weatherForecastInteractor.onSuccess(weatherForecastResponse);
    }
}