package com.akadatsky.api;

import com.akadatsky.model.UserList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("user")
    Call<UserList> getUsers();

}