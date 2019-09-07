package com.diptika.weatherforecast.base;

/**
 * Created by Diptika on 07/09/19.
 */
public interface RxSingleObserverEvent<T> extends RxErrorEvent {
    void onSuccess(T var1);
}
