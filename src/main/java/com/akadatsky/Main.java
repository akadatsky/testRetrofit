package com.akadatsky;

import com.akadatsky.api.Callback;
import com.akadatsky.api.RetrofitClient;
import com.akadatsky.model.UserList;

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
        Callback<Void> callback = (call, response) -> Log.out("User created");
        RetrofitClient.getApiService().addUser(name, age).enqueue(callback);
    }

    private static void getUsers() {
        Callback<UserList> callback = (call, response) -> Log.out("Users: " + response.body().getUsers());
        RetrofitClient.getApiService().getUsers().enqueue(callback);
    }

}