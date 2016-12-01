package com.epicodus.createameal;

import java.util.ArrayList;

public class Recipe {
    private String mName;
    private ArrayList<String> mIngredients = new ArrayList<>();
    private double mRating;
    private String mImageUrl;
    private String mTime;
    private ArrayList<String> mNutrition = new ArrayList<>();
    private String mServings;


    public Recipe(String name, ArrayList<String> ingredients, double rating, String imageUrl, String time, ArrayList<String> nutrition, String servings) {
        this.mName = name;
        this.mIngredients = ingredients;
        this.mRating = rating;
        this.mImageUrl = imageUrl;
        this.mTime = time;
        this.mNutrition = nutrition;
        this.mServings = servings;
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

    public ArrayList<String> getmNutrition(){
        return mNutrition;
    }

    public String getmServings(){
        return mServings;
    }
}
