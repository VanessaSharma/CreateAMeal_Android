package com.epicodus.createameal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;


import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RecipeResultsActivity extends AppCompatActivity {
    public static final String TAG = UserActivity.class.getSimpleName();
    @Bind(R.id.recipeTextView) TextView mRecipeTextView;
    @Bind(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_results);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String recipe = intent.getStringExtra("recipe");

        mRecipeTextView.setText("Here are all the recipes related to your search for " + recipe);

        getRecipes(recipe);
    }

    private void getRecipes(String recipeName){
        final YummlyService yummlyService = new YummlyService();
        yummlyService.findRecipes(recipeName, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}

