package com.schober.weatherforecast;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.schober.weatherforecast.data.ForecastApiModule;

public class WeatherForecastApp extends Application {

    private WeatherForecastAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @NonNull
    public static WeatherForecastAppComponent getAppComponent(Context context) {
        WeatherForecastApp app = (WeatherForecastApp) context.getApplicationContext();
        if (app.component == null) {
            app.component = DaggerWeatherForecastAppComponent.builder()
                    .weatherForecastAppModule(new WeatherForecastAppModule(app))
                    .forecastApiModule(new ForecastApiModule())
                    .build();
        }
        return app.component;
    }

}
