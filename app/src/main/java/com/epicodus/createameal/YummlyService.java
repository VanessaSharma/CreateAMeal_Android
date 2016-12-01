package com.epicodus.createameal;

import java.net.URL;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class YummlyService {
    public static void findRecipes(String recipeName, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YUMMLY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.Yu)
    }
}
