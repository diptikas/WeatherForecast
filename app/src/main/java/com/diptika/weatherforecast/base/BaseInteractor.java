package com.diptika.weatherforecast.base;

import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Diptika on 07/09/19.
 */
public class BaseInteractor {
    private final CompositeDisposable subscriptionQueue = new CompositeDisposable();
    private BasePresenterContract presenterContract;
    private OnBaseInteractorUnsubscribeListener onBaseInteractorUnsubscribeListener;

    public BaseInteractor() {
    }

    public void subscribePresenter(BasePresenterContract updateListener) {
        BasePresenterContract previousListener = this.presenterContract;
        if (previousListener != null) {
            throw new IllegalStateException("A view was already bound to this listener, please unbind it before binding any other view = " + previousListener);
        } else {
            this.presenterContract = updateListener;
        }
    }


    public void unsubscribePresenter(BasePresenterContract updateListener) {
        BasePresenterContract previousListener = this.presenterContract;
        if (previousListener == updateListener) {
            this.presenterContract = null;
            this.clearSubscriptionQueue();
        } else {
            throw new IllegalStateException("No such listener was bound previously.");
        }
    }

    public BasePresenterContract getPresenterContract() {
        return this.presenterContract;
    }

    void queueSubscriptionForDisposal(Disposable subscription) {
        this.subscriptionQueue.add(subscription);
    }



    void clearSubscriptionQueue() {
        this.subscriptionQueue.clear();
        if (this.onBaseInteractorUnsubscribeListener != null) {
            this.onBaseInteractorUnsubscribeListener.onBaseInteractorUnsubscribed();
        }

    }


    protected <E> SingleObserver<E> getSingleSubscriber(final RxSingleObserverEvent singleObserverEvents) {
        return new SingleObserver<E>() {
            public void onSubscribe(@NonNull Disposable d) {
                BaseInteractor.this.queueSubscriptionForDisposal(d);
            }

            public void onSuccess(E value) {
                singleObserverEvents.onSuccess(value);
            }

            public void onError(Throwable error) {
                singleObserverEvents.onError(error);
            }
        };
    }
}
