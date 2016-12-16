package com.epicodus.createameal.models;

import java.util.ArrayList;
import java.util.List;

import org.parceler.Parcel;


@Parcel
public class Recipe {
     String name;
     List<String> ingredients = new ArrayList<>();
     double rating;
     String imageUrl;
     String time;
    private String pushId;
    String index;


    public Recipe(){}

    public Recipe(String name, ArrayList<String> ingredients, double rating, String imageUrl, String time) {
        this.name = name;
        this.ingredients = ingredients;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.time = time;
        this.index = "not_specified";

    }

    public String getName(){
        return name;
    }

    public List<String> getIngredients(){
        return ingredients;
    }

    public double getRating(){
        return rating;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getTime(){
        return time;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}


