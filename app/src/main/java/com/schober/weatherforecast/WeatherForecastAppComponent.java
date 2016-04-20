package com.schober.weatherforecast;

import com.schober.weatherforecast.data.ForecastApiModule;
import com.schober.weatherforecast.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                WeatherForecastAppModule.class,
                ForecastApiModule.class
        }
)
public interface WeatherForecastAppComponent {
    void inject(MainActivity mainActivity);
}