package com.example.vatavarana;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Retrofit_API {

    //Overall, this interface defines a method getWeatherData that, when called,
    // will make an HTTP GET request to the specified endpoint "weather" with the provided query parameters (city, appid, units).
    // The response is expected to be of type WeatherJson, and Retrofit will handle the serialization of the response into this type.
    @GET("weather")
    Call<WeatherModel> getWeatherData(
            @Query("q") String city,
            @Query("appid") String appid,
            @Query("units") String units);
}
