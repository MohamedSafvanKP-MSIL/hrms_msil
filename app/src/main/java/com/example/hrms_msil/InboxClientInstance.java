package com.example.hrms_msil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InboxClientInstance {
    private static final String BASE_URL = " https://run.mocky.io/v3/cd848404-121c-47f7-abdf-8884b361cc03/";

    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
