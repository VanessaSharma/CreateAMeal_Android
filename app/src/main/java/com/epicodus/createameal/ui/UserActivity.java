package com.epicodus.createameal.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import com.epicodus.createameal.R;
import com.epicodus.createameal.services.YummlyService;
import com.epicodus.createameal.models.Recipe;
import com.epicodus.createameal.Constants;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class UserActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = UserActivity.class.getSimpleName();

    private DatabaseReference mSearchedRecipeReference;

    private ValueEventListener mSearchedRecipeReferenceListener;


    @Bind(R.id.userInfo) TextView mUserInfo;
    @Bind(R.id.recipesButton) Button mRecipesButton;
    @Bind(R.id.websiteButton) Button mWebsiteButton;
    @Bind(R.id.recipeEditText) EditText mRecipeEditText;
    @Bind(R.id.savedRecipeButton) Button mSavedRecipeButton;

    public ArrayList<Recipe> mRecipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedRecipeReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_RECIPE);

        mSearchedRecipeReferenceListener = mSearchedRecipeReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot recipeSnapshot : dataSnapshot.getChildren()) {
                    String recipe = recipeSnapshot.getValue().toString();
                    Log.d("Recipes updated", "recipe: " + recipe);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);



        mUserInfo.setText("Welcome!");

        mSavedRecipeButton.setOnClickListener(this);
        mRecipesButton.setOnClickListener(this);
        mWebsiteButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == mRecipesButton) {
            String recipe = mRecipeEditText.getText().toString();
            saveRecipeToFirebase(recipe);
            Intent intent = new Intent(UserActivity.this, RecipeResultsActivity.class);
            intent.putExtra("recipe", recipe);
            startActivity(intent);
        } else if (v == mWebsiteButton) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.yummly.com/"));
            startActivity(webIntent);
        } else if ( v == mSavedRecipeButton) {
            Intent intent = new Intent(UserActivity.this, SavedRecipeListActivity.class);
            startActivity(intent);
        }
    }
    public void saveRecipeToFirebase(String recipe) {
        mSearchedRecipeReference.push().setValue(recipe);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedRecipeReference.removeEventListener(mSearchedRecipeReferenceListener);
    }

    private void getRecipes(final String recipeName){
        final YummlyService yummlyService = new YummlyService();
        yummlyService.findRecipes(recipeName, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try{
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                    mRecipes = yummlyService.processResults(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
