package com.example.android.resto.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Android on 10/22/2017.
 */

public class Restaurant implements Serializable{

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

    @SerializedName("meals")
    List<String> meals;

    @SerializedName("description")
    String description;

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

    public List<String> getMeals() {
        return meals;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setMeals(List<String> meals) {
        this.meals = meals;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
