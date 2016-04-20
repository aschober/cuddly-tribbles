package com.schober.weatherforecast.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.schober.weatherforecast.R;
import com.schober.weatherforecast.WeatherForecastApp;
import com.schober.weatherforecast.data.ForecastApi;
import com.schober.weatherforecast.data.models.Forecast;

import javax.inject.Inject;
import javax.inject.Named;


import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static final String LATITUDE = "30.2672";
    private static final String LONGITUDE = "-97.7431";

    @Inject
    ForecastApi forecastApi;
    @Inject @Named("apiKey") String apiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherForecastApp.getAppComponent(this).inject(this);

        Observable<Forecast> forecastObservable = forecastApi
                .fetchWeatherForecast(
                        apiKey,
                        LATITUDE,
                        LONGITUDE);



    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");

        super.onDestroy();
    }
}
