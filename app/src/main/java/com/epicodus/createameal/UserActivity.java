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

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class UserActivity extends AppCompatActivity {
    @Bind(R.id.userinfo) TextView mUserInfo;
    @Bind(R.id.listView) ListView mListView;
    public static final String TAG = UserActivity.class.getSimpleName();

    private String[] menu = new String[] {"Recipes", "Grocery List", "Favorites <3", "Add a Recipe"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menu);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String menu = ((TextView)view).getText().toString();
                Toast.makeText(UserActivity.this, menu, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        mUserInfo.setText("Welcome "+ userName);
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
