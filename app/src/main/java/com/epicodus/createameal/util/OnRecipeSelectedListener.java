package com.epicodus.createameal.util;

import com.epicodus.createameal.models.Recipe;

import java.util.ArrayList;

/**
 * Created by Guest on 12/21/16.
 */
public interface OnRecipeSelectedListener {
    public void onRecipeSelected(Integer position, ArrayList<Recipe> recipes);

}
