package com.diptika.weatherforecast.model.response;

import java.util.List;

/**
 * Created by Diptika on 07/09/19.
 */
public class Forecast {

    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }
}
