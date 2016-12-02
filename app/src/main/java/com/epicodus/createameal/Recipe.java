package com.epicodus.createameal;

import java.util.ArrayList;

public class Recipe {
    private String mName;
    private ArrayList<String> mIngredients = new ArrayList<>();
    private double mRating;
    private String mImageUrl;
    private String mTime;


    public Recipe(String name, ArrayList<String> ingredients, double rating, String imageUrl, String time, String servings) {
        this.mName = name;
        this.mIngredients = ingredients;
        this.mRating = rating;
        this.mImageUrl = imageUrl;
        this.mTime = time;
    }

    public String getmName(){
        return mName;
    }

    public ArrayList<String> getmIngredients(){
        return mIngredients;
    }

    public double getmRating(){
        return mRating;
    }

    public String getmImageUrl(){
        return mImageUrl;
    }

    public String getmTime(){
        return mTime;
    }

}
