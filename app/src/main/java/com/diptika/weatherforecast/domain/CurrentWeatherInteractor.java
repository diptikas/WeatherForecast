package com.diptika.weatherforecast.domain;

import com.diptika.weatherforecast.base.BaseInteractor;
import com.diptika.weatherforecast.base.RxSingleObserverEvent;
import com.diptika.weatherforecast.model.response.CurrentWeatherResponse;
import com.diptika.weatherforecast.network.RestApiObservables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diptika on 07/09/19.
 */
public class CurrentWeatherInteractor extends BaseInteractor implements WeatherContract.CurrentWeatherApiContract,
        RxSingleObserverEvent<CurrentWeatherResponse> {

    private RestApiObservables restApiObservables = new RestApiObservables();

    private WeatherContract.Presenter getPresenter() {
        return (WeatherContract.Presenter) getPresenterContract();
    }

    /**
     * Api call for getting current weather info
     * @param city
     */
    @Override
    public void getCurrentWeatherInfo(String city) {
          restApiObservables.getCurrentWeatherResponse(city).subscribe(this.<CurrentWeatherResponse>getSingleSubscriber(this));
    }

    /**
     * Callback when api returns response
     * @param currentWeatherResponse
     */
    @Override
    public void onSuccess(CurrentWeatherResponse currentWeatherResponse) {
        if (getPresenter() != null) {
            getPresenter().onCurrentWeatherDataFetched(currentWeatherResponse);
        }
    }

    /**
     * Callback when api get failure
     *
     * @param throwable
     */
    @Override
    public void onError(Throwable throwable) {
        if (getPresenter() != null) {
            getPresenter().onError(throwable);
        }
    }

}
