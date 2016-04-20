package com.schober.weatherforecast;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherForecastAppModule {

    @NonNull
    private final WeatherForecastApp app;

    public WeatherForecastAppModule(WeatherForecastApp app) {
        this.app = app;
    }

    @Provides @Singleton @Named("applicationContext")
    Context provideApplicationContext() {
        return app;
    }
}