package com.example.hrms_msil;

import com.example.hrms_msil.pojo.HomeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeApi {
    @GET("serviece/0/home")
    Call<HomeResponse> getAllData();
}
