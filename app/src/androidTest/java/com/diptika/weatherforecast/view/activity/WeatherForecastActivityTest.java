package com.diptika.weatherforecast.view.activity;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.diptika.weatherforecast.R;
import com.diptika.weatherforecast.model.response.CurrentWeatherResponse;
import com.diptika.weatherforecast.model.response.Location;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Diptika on 07/09/19.
 */
@RunWith(AndroidJUnit4.class)
public class WeatherForecastActivityTest {

    @Rule
    public ActivityTestRule<WeatherForecastActivity> rule  = new  ActivityTestRule<>(WeatherForecastActivity.class);


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testShowErrorView() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.ll_weather_info)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.rl_loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.rl_error)).check(matches(isDisplayed()));
    }

    @Test
    public void testShowLoadingView() {
        onView(withId(R.id.ll_weather_info)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.rl_loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.rl_error)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test
    public void testShowWeatherView() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.ll_weather_info)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.rl_loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.rl_error)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test
    public void testClickRetry() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.ll_weather_info)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.rl_loading)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        onView(withId(R.id.rl_error)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_retry)).check(matches(isDisplayed())).perform(click());
    }

    @Test
    public void testSetUpRecyclerView(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.ll_weather_info)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_weather_forecast)).check(matches(isDisplayed()));
    }

    @Test
    public void testShowCurrentWeatherData(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.ll_weather_info)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_city)).check(matches(isDisplayed()));
        CurrentWeatherResponse currentWeatherResponse=mock(CurrentWeatherResponse.class);
        Location location=new Location();
        location.setName("Bangalore");
        when(currentWeatherResponse.getLocation()).thenReturn(location);
        assertEquals("Bangalore", currentWeatherResponse.getLocation().getName());
    }

    @After
    public void tearDown() throws Exception {
    }
}