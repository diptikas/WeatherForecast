package com.diptika.weatherforecast.model.response;

/**
 * Created by Diptika on 07/09/19.
 */
public class WeatherForecastResponse {
    private Location location;
    private Current current;
    private Forecast forecast;
    private Alert alert;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

}
