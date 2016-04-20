package com.schober.weatherforecast.data;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

@Module
public class ForecastApiModule {
    private static final String WEATHER_BASE_URL = "https://api.forecast.io/";
    private static final String WEATHER_API_KEY = "WEATHER_API_KEY";

    @Provides @Named("apiKey")
    String provideApiKey() {
        return WEATHER_API_KEY;
    }

    @Provides @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build();
    }

    @Provides @Singleton
    ForecastApi provideForecastApi(Retrofit retrofit) {
        return retrofit.create(ForecastApi.class);
    }
}
