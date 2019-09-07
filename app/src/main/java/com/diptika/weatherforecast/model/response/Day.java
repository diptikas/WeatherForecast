package com.diptika.weatherforecast.model.response;

/**
 * Created by Diptika on 07/09/19.
 */
public class Day {
    private Condition condition;
    private float maxtemp_c;
    private float maxtemp_f;
    private float mintemp_c;
    private float mintemp_f;
    private float avgtemp_c;
    private float avgtemp_f;
    private float maxwind_mph;
    private float maxwind_kph;
    private float totalprecip_mm;
    private float totalprecip_in;
    private float avgvis_km;
    private float avgvis_miles;
    private float avghumidity;
    private float uv;

    public float getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(float maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public float getMaxtemp_f() {
        return maxtemp_f;
    }

    public void setMaxtemp_f(float maxtemp_f) {
        this.maxtemp_f = maxtemp_f;
    }

    public float getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(float mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public float getMintemp_f() {
        return mintemp_f;
    }

    public void setMintemp_f(float mintemp_f) {
        this.mintemp_f = mintemp_f;
    }

    public float getAvgtemp_c() {
        return avgtemp_c;
    }

    public void setAvgtemp_c(float avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    public float getAvgtemp_f() {
        return avgtemp_f;
    }

    public void setAvgtemp_f(float avgtemp_f) {
        this.avgtemp_f = avgtemp_f;
    }

    public float getMaxwind_mph() {
        return maxwind_mph;
    }

    public void setMaxwind_mph(float maxwind_mph) {
        this.maxwind_mph = maxwind_mph;
    }

    public float getMaxwind_kph() {
        return maxwind_kph;
    }

    public void setMaxwind_kph(float maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

    public float getTotalprecip_mm() {
        return totalprecip_mm;
    }

    public void setTotalprecip_mm(float totalprecip_mm) {
        this.totalprecip_mm = totalprecip_mm;
    }

    public float getTotalprecip_in() {
        return totalprecip_in;
    }

    public void setTotalprecip_in(float totalprecip_in) {
        this.totalprecip_in = totalprecip_in;
    }

    public float getAvgvis_km() {
        return avgvis_km;
    }

    public void setAvgvis_km(float avgvis_km) {
        this.avgvis_km = avgvis_km;
    }

    public float getAvgvis_miles() {
        return avgvis_miles;
    }

    public void setAvgvis_miles(float avgvis_miles) {
        this.avgvis_miles = avgvis_miles;
    }

    public float getAvghumidity() {
        return avghumidity;
    }

    public void setAvghumidity(float avghumidity) {
        this.avghumidity = avghumidity;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public float getUv() {
        return uv;
    }

    public void setUv(float uv) {
        this.uv = uv;
    }

}
