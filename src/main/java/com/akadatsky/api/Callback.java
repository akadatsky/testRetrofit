package com.akadatsky.api;

import com.akadatsky.Log;
import retrofit2.Call;
import retrofit2.Response;

@FunctionalInterface
public interface Callback<T> extends retrofit2.Callback<T> {

    @Override
    void onResponse(Call<T> call, Response<T> response);

    @Override
    default void onFailure(Call<T> call, Throwable t) {
        Log.out("Request failed");
    }

}
