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
        urlBuilder.addQueryParameter(Constants.YUMMLY_ID_QUERY_PARAMETER, Constants.YUMMLY_ID);
        urlBuilder.addQueryParameter(Constants.YUMMLY_KEY_QUERY_PARAMETER, Constants.YUMMLY_KEY);
        urlBuilder.addQueryParameter(Constants.YUMMLY_QUERY_PARAMETER, recipeName);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
    }
}