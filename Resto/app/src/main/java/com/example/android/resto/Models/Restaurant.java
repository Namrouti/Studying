package com.example.android.resto.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Android on 10/22/2017.
 */

public class Restaurant {

    @SerializedName("id")
    String id;

    @SerializedName("name")
    String name;

    @SerializedName("address")
    String address;

    @SerializedName("rating")
    float rating;

    @SerializedName("category")
    String category;

    @SerializedName("image")
    String image;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public float getRating() {
        return rating;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }
}
