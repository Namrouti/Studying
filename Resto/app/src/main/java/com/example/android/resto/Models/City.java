package com.example.android.resto.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by android on 10/10/2017.
 */

public class City {
    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;

    @SerializedName("country_name")
    String countryName;

    @SerializedName("cover_image")
    String image;

    @SerializedName("lat")
    double lat;
    @SerializedName("lng")
    double lng;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getCountryName() {
        return countryName;
    }
}
