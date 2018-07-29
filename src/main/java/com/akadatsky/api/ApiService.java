package com.akadatsky.api;

import com.akadatsky.model.UserList;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("user")
    Call<Void> addUser(
            @Field("name") String name,
            @Field("age") int age);

    @GET("user")
    Call<UserList> getUsers();

}