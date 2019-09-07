package com.diptika.weatherforecast.domain;

import com.diptika.weatherforecast.base.BaseInteractor;
import com.diptika.weatherforecast.base.RxSingleObserverEvent;
import com.diptika.weatherforecast.model.response.WeatherForecastResponse;
import com.diptika.weatherforecast.network.RestApiObservables;

/**
 * Created by Diptika on 07/09/19.
 */
public class WeatherForecastInteractor extends BaseInteractor implements WeatherContract.WeatherForecastApiContract,
        RxSingleObserverEvent<WeatherForecastResponse> {

    private RestApiObservables restApiObservables = new RestApiObservables();

    private WeatherContract.Presenter getPresenter() {
        return (WeatherContract.Presenter) getPresenterContract();
    }

    /**
     *  Api call for getting weather forecast info
     * @param city
     * @param days
     */
    @Override
    public void getWeatherForecastInfo(String city, int days) {
        restApiObservables.getWeatherForecastResponse(city,days).subscribe(this.<WeatherForecastResponse>getSingleSubscriber(this));

    }

    /**
     * Callback when api returns response
     *
     * @param weatherForecastResponse
     */
    @Override
    public void onSuccess(WeatherForecastResponse weatherForecastResponse) {
        if (getPresenter() != null) {
            getPresenter().onWeatherForecastDataFetched(weatherForecastResponse);
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

