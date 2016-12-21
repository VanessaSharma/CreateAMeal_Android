package com.epicodus.createameal.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.epicodus.createameal.models.Recipe;
import com.epicodus.createameal.ui.RecipeDetailFragment;

import java.util.ArrayList;


public class RecipePagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Recipe> mRecipes;

    public RecipePagerAdapter(FragmentManager fm, ArrayList<Recipe> recipes){
        super(fm);
        mRecipes = recipes;
    }

    @Override
    public Fragment getItem(int position) {
        return RecipeDetailFragment.newInstance(mRecipes.get(position));
    }

    @Override
    public int getCount(){
        return mRecipes.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mRecipes.get(position).getName();
    }
}