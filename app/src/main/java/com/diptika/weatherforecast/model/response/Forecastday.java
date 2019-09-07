package com.diptika.weatherforecast.model.response;

/**
 * Created by Diptika on 07/09/19.
 */
public class Forecastday {

    private String date;
    private long date_epoch;
    private Day day;
    private Astro astro;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getDate_epoch() {
        return date_epoch;
    }

    public void setDate_epoch(long date_epoch) {
        this.date_epoch = date_epoch;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

}
