package com.akadatsky;

import com.akadatsky.api.RetrofitClient;
import com.akadatsky.model.UserList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        addUser("Ivan", 20);
        addUser("Oleg", 30);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getUsers();

    }

    private static void addUser(String name, int age) {
        Callback<Void> callback = new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.out("User created");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.out("FAIL");
            }
        };
        RetrofitClient.getApiService().addUser(name, age).enqueue(callback);
    }

    private static void getUsers() {
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