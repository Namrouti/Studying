package com.example.android.resto.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Android on 10/22/2017.
 */

public class RestaurantsResponse {

    @SerializedName("restaurants")
    List<Restaurant> restaurants;

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
