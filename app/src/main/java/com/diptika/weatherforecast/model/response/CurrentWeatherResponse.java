package com.diptika.weatherforecast.model.response;

/**
 * Created by Diptika on 07/09/19.
 */
public class CurrentWeatherResponse {
    private Location location;
    private Current current;

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

}
