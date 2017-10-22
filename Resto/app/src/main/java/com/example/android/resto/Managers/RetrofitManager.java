package com.example.android.resto.Managers;

import com.example.android.resto.Constants;
import com.example.android.resto.Interfaces.Request;
import com.example.android.resto.Interfaces.RetroCallback;
import com.example.android.resto.Models.PopularCitiesResponse;
import com.example.android.resto.Models.RestaurantsResponse;
import com.example.android.resto.Utilities.UIUtil;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by android on 10/10/2017.
 */

public class RetrofitManager {

    Retrofit retrofit = null;

    Request request;

    private static RetrofitManager instance = null;

    private RetrofitManager(){

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(Constants.SERVER_URL)
                        .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.client(httpClient.build()).build();

        request = retrofit.create(Request.class);

    }

    public static RetrofitManager getInstance() {

        if(instance == null) {

            instance = new RetrofitManager();
        }

        return instance;
    }

    public void getRestaurantList(RetroCallback<RestaurantsResponse> callback) {

        Call<RestaurantsResponse> call = request.getRestaurantList();

        call.enqueue(callback);
    }

    public void getPopularCities(RetroCallback<PopularCitiesResponse> callback) {

        Call<PopularCitiesResponse> call = request.getPopularCities();

        call.enqueue(callback);
    }

}
