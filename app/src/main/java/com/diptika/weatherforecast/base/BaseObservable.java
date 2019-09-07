package com.diptika.weatherforecast.base;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Diptika on 07/09/19.
 */
public class BaseObservable {
    public BaseObservable() {
    }

    public <T> ObservableTransformer<T, T> applyCommonSchedulers() {
        return new ObservableTransformer<T, T>() {
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public <T> SingleTransformer<T, T> applyCommonSchedulersSingle() {
        return new SingleTransformer<T, T>() {
            public SingleSource<T> apply(@NonNull Single<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
