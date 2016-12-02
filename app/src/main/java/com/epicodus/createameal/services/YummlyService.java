package com.epicodus.createameal.services;

import com.epicodus.createameal.Constants;
import com.epicodus.createameal.models.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YummlyService {
    public static void findRecipes(String recipeName, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YUMMLY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YUMMLY_ID_QUERY_PARAMETER, Constants.YUMMLY_ID);
        urlBuilder.addQueryParameter(Constants.YUMMLY_KEY_QUERY_PARAMETER, Constants.YUMMLY_KEY);
        urlBuilder.addQueryParameter(Constants.YUMMLY_QUERY_PARAMETER, recipeName);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Recipe> processResults(Response response) {
        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject yummlyJSON = new JSONObject(jsonData);
                JSONArray foundrecipes = yummlyJSON.getJSONArray("matches");
                for (int i = 0; i < foundrecipes.length(); i++) {
                    JSONObject recipeJSON = foundrecipes.getJSONObject(i);
                    String name = recipeJSON.getString("recipeName");
                    String rating = recipeJSON.getString("rating");
                    String imageUrl = recipeJSON.getString("smallImageUrls");
                    String time = recipeJSON.getString("totalTimeInSeconds");
                    ArrayList<String> ingredients = new ArrayList<>();
                    JSONArray ingredientsJSON = recipeJSON.getJSONObject("ingredients")
                            .getJSONArray("ingredients");
                    for (int y = 0; y < ingredientsJSON.length(); y++) {
                        ingredients.add(ingredientsJSON.get(y).toString());
                }

                     Recipe recipe = new Recipe(name, ingredients, rating, imageUrl, time);
                     recipes.add(recipe);
                }
                }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recipes;
    }


}