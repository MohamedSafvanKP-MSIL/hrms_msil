package com.example.hrms_msil;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeApi {
    @GET("serviece/0/home")
    Call<HomePojo> getAllData();
}
