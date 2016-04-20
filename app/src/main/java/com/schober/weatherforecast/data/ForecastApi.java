package com.schober.weatherforecast.data;

import com.schober.weatherforecast.data.models.Forecast;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ForecastApi {
    @GET("forecast/{apiKey}/{latitude},{longitude}")
    Observable<Forecast> fetchWeatherForecast(@Path("apiKey") String apiKey,
                                              @Path("latitude") String latitude,
                                              @Path("longitude") String longitude);
}
