package com.example.android.resto.Interfaces;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by android on 10/10/2017.
 */

public abstract class RetroCallback <T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if(response.isSuccessful()) {

            onResult(true, response.body());

        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

        t.printStackTrace();

        onResult(false, null);
    }

    public abstract void onResult(boolean isSuccess, T result);
}
