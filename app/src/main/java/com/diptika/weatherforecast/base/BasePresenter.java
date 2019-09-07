package com.diptika.weatherforecast.base;

import android.util.ArrayMap;
import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Diptika on 07/09/19.
 */
public abstract class BasePresenter<V> {
    private static final String TAG = BasePresenter.class.getSimpleName();
    private V viewContract;
    private Map<BaseInteractor, BasePresenterContract> interactorMap = new HashMap<>();

    public BasePresenter() {
    }

    public void subscribeView(V updateListener) {
        this.subscribeInteractor();
        V previousListener = this.viewContract;
        if (previousListener != null) {
            throw new IllegalStateException("A view was already bound to this listener, please unbind it before binding any other view = " + previousListener);
        } else {
            this.viewContract = updateListener;
            this.subscribeAllPresenterViews();
        }
    }

    public boolean wasSubscribed(V updateListener) {
        if (updateListener != null) {
            if (this.viewContract == null) {
                return false;
            }

            if (updateListener == this.viewContract) {
                return true;
            }
        }

        return false;
    }

    public void unsubscribeView(V updateListener) {
        V previousListener = this.viewContract;
        if (previousListener == updateListener) {
            this.viewContract = null;
            this.unsubscribeAllPresenterViews();
        } else {
            throw new IllegalStateException("No such listener was bound previously.");
        }
    }

    protected void subscribeInteractor(BaseInteractor interactor, BasePresenterContract contract) {
        this.interactorMap.put(interactor, contract);
    }

    public abstract void subscribeInteractor();

    protected V getViewContract() {
        return this.viewContract;
    }

    private void subscribeAllPresenterViews() {
        if (this.interactorMap != null && !this.interactorMap.isEmpty()) {
            Iterator var1 = this.interactorMap.entrySet().iterator();

            while (var1.hasNext()) {
                Map.Entry<BaseInteractor, BasePresenterContract> entry = (Map.Entry) var1.next();
                Log.e(TAG, String.format("Subscribing %s to %s", ((BaseInteractor) entry.getKey()).getClass().getSimpleName(), ((BasePresenterContract) entry.getValue()).getClass().getSimpleName()));
                ((BaseInteractor) entry.getKey()).subscribePresenter((BasePresenterContract) entry.getValue());
            }
        }

    }

    private void unsubscribeAllPresenterViews() {
        if (this.interactorMap != null && !this.interactorMap.isEmpty()) {
            Iterator var1 = this.interactorMap.entrySet().iterator();

            while (var1.hasNext()) {
                Map.Entry<BaseInteractor, BasePresenterContract> entry = (Map.Entry) var1.next();
                Log.e(TAG, String.format("unsubscribing %s from %s", ((BaseInteractor) entry.getKey()).getClass().getSimpleName(), ((BasePresenterContract) entry.getValue()).getClass().getSimpleName()));
                ((BaseInteractor) entry.getKey()).unsubscribePresenter((BasePresenterContract) entry.getValue());
            }
        }

    }
}
