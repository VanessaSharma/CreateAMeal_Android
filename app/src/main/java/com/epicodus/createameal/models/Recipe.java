package com.epicodus.createameal.models;

import java.util.ArrayList;
import org.parceler.Parcel;

public class Recipe {
    private String mName;
    private ArrayList<String> mIngredients = new ArrayList<>();
    private double mRating;
    private String mImageUrl;
    private String mTime;

    public Recipe(){}

    public Recipe(String name, ArrayList<String> ingredients, double rating, String imageUrl, String time) {
        this.mName = name;
        this.mIngredients = ingredients;
        this.mRating = rating;
        this.mImageUrl = imageUrl;
        this.mTime = time;
    }

    public String getName(){
        return mName;
    }

    public ArrayList<String> getIngredients(){
        return mIngredients;
    }

    public double getRating(){
        return mRating;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public String getTime(){
        return mTime;
    }

}
