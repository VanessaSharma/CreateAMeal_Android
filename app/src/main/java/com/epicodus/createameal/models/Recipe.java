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


    public Recipe(){}

    public Recipe(String name, ArrayList<String> ingredients, double rating, String imageUrl, String time) {
        this.name = name;
        this.ingredients = ingredients;
        this.rating = rating;
        this.imageUrl = getLargeImageUrl(imageUrl);
        this.time = time;
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

    public String getLargeImageUrl(String imageUrl) {
        String largeImageUrl = imageUrl.substring(0, imageUrl.length() - 6).concat("o.jpg");
        return largeImageUrl;
    }
}
