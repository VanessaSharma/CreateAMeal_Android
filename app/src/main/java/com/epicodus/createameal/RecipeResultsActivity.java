package com.epicodus.createameal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RecipeResultsActivity extends AppCompatActivity {
    public static final String TAG = UserActivity.class.getSimpleName();

    @Bind(R.id.recipeTextView) TextView mRecipeTextView;
    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Recipe> mRecipes = new ArrayList<>();

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

    private void getRecipes(final String recipeName){
        final YummlyService yummlyService = new YummlyService();

        yummlyService.findRecipes(recipeName, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mRecipes = yummlyService.processResults(response);

                RecipeResultsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] recipeNames = new String[mRecipes.size()];
                        for (int i = 0; i < recipeNames.length; i++) {
                            recipeNames[i] = mRecipes.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(RecipeResultsActivity.this,
                                android.R.layout.simple_list_item_1, recipeNames);
                        mListView.setAdapter(adapter);

                        for (Recipe recipe : mRecipes) {
                            Log.d(TAG, "Name: " + recipe.getName());
                            Log.d(TAG, "Ingredients: " + recipe.getIngredients());
                            Log.d(TAG, "Rating: " + recipe.getRating());
                            Log.d(TAG, "Image url: " + recipe.getImageUrl());
                            Log.d(TAG, "Time: " + recipe.getTime());

                        }
                    }
                });
            }
        });
    }
}

//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                try {
//                    String jsonData = response.body().string();
//                    Log.v(TAG, jsonData);
//                } catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//}

