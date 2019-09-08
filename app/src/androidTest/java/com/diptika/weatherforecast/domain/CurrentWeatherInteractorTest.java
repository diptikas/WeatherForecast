package com.diptika.weatherforecast.domain;

import com.diptika.weatherforecast.model.response.CurrentWeatherResponse;
import com.diptika.weatherforecast.model.response.WeatherForecastResponse;
import com.diptika.weatherforecast.network.RestApiObservables;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by Diptika on 08/09/19.
 */
public class CurrentWeatherInteractorTest {
    private RestApiObservables restApiObservables;
    private CurrentWeatherInteractor currentWeatherInteractor;

    @Before
    public void setUp() throws Exception {
        restApiObservables=mock(RestApiObservables.class);
        currentWeatherInteractor=new CurrentWeatherInteractor();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getWeatherForecastInfo(){
        currentWeatherInteractor.getCurrentWeatherInfo("Bngalore");
    }

    @Test
    public void SuccessTest(){
        CurrentWeatherResponse currentWeatherResponse=mock(CurrentWeatherResponse.class);
        currentWeatherInteractor.onSuccess(currentWeatherResponse);
    }

    @Test
    public void onErrorTest(){
        CurrentWeatherResponse currentWeatherResponse=mock(CurrentWeatherResponse.class);
        currentWeatherInteractor.onSuccess(currentWeatherResponse);
    }
}