package com.example.hrms_msil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InboxClientInstance {
    private static final String BASE_URL = "https://3eb04e18-69b1-445e-99ae-6558cb6df52f.mock.pstmn.io/";

    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
