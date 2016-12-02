package com.epicodus.createameal.models;

import java.util.ArrayList;

public class Recipe {
    private String mName;
    private ArrayList<String> mIngredients = new ArrayList<>();
    private String mRating;
    private String mImageUrl;
    private String mTime;


    public Recipe(String name, ArrayList<String> ingredients, String rating, String imageUrl, String time) {
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

    public String getRating(){
        return mRating;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public String getTime(){
        return mTime;
    }

}
