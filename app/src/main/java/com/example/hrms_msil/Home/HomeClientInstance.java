package com.example.hrms_msil.Home;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeClientInstance {
    private static final String BASE_URL = "https://run.mocky.io/v3/ad7086f0-0a45-4652-9d25-2a60e6e54601/";

    public static Retrofit getRetrofitInstances() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
