package com.example.hrms_msil.Inbox;

import com.example.hrms_msil.Inbox.InboxPojo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface InboxApi {
    @POST("serviece/0/inbox")
    Call<InboxPojo> createPost(@Body InboxPojo inboxPojo);
}