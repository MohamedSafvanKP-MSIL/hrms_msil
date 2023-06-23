package com.example.hrms_msil;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface InboxApi {



    @POST("serviece/0/inbox")
    Call<InboxPojo> createPost(@Body InboxPojo inboxPojo);


}