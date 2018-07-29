package com.akadatsky;

import com.akadatsky.api.RetrofitClient;
import com.akadatsky.model.UserList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main {

    public static void main(String[] args) {
        testAddUsers();
        testGetUsers();
    }

    private static void testAddUsers() {
    }

    private static void testGetUsers() {
        Callback<UserList> callback = new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                Log.out("Users: " + response.body().getUsers());
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Log.out("FAIL");
            }
        };
        RetrofitClient.getApiService().getUsers().enqueue(callback);
    }

}