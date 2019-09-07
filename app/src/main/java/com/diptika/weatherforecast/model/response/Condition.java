package com.diptika.weatherforecast.model.response;

/**
 * Created by Diptika on 07/09/19.
 */
public class Condition {
    private String text;
    private String icon;
    private float code;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getCode() {
        return code;
    }

    public void setCode(float code) {
        this.code = code;
    }

}
