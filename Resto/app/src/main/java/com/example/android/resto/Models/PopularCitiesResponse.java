package com.example.android.resto.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by android on 10/10/2017.
 */

public class PopularCitiesResponse {

    @SerializedName("result")
    List<City> popularCities;

    public List<City> getPopularCities() {
        return popularCities;
    }
}
