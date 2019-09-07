package com.diptika.weatherforecast.base;

import android.support.annotation.NonNull;

import com.diptika.weatherforecast.BuildConfig;
import com.diptika.weatherforecast.network.WeatherApi;
import com.diptika.weatherforecast.network.WeatherApiConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Diptika on 07/09/19.
 */
public class RetrofitProvider {
    private static final int TIMEOUT = 180;
    private static RetrofitProvider sRetrofitInstance;
    private WeatherApi weatherApi;

    private RetrofitProvider() {
        buildRestApi();
    }

    public static synchronized RetrofitProvider getInstance() {
        if (sRetrofitInstance == null) {
            sRetrofitInstance = new RetrofitProvider();
        }
        return sRetrofitInstance;
    }

    public WeatherApi getRestApi() {
        if (null == weatherApi) {
            buildRestApi();
        }
        return weatherApi;
    }

    private void buildRestApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient.Builder okHttpClient = getOkHttpBuilder();
        okHttpClient.readTimeout(TIMEOUT, TimeUnit.SECONDS);
        okHttpClient.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        final Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(WeatherApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build());
        weatherApi = builder.build().create(WeatherApi.class);
    }

    @NonNull
    private OkHttpClient.Builder getOkHttpBuilder() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        }
        okHttpClient.addInterceptor(logging);
        return okHttpClient;
    }

}
