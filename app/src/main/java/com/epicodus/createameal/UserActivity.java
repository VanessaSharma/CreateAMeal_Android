package com.epicodus.createameal;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class UserActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.userinfo) TextView mUserInfo;
    @Bind(R.id.recipesButton) Button mRecipesButton;
    @Bind(R.id.groceryListButton) Button mGroceryListButton;
    @Bind(R.id.favoritesButton) Button mFavoritesButton;
    @Bind(R.id.addARecipeButton) Button mAddARecipeButton;
    @Bind(R.id.recipeEditText) EditText mRecipeEditText;

//    public static final String TAG = UserActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        mUserInfo.setText("Welcome "+ userName);

        mRecipesButton.setOnClickListener(this);
        mGroceryListButton.setOnClickListener(this);
        mFavoritesButton.setOnClickListener(this);
        mAddARecipeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mRecipesButton) {
            Intent intent = new Intent(UserActivity.this, RecipeResultsActivity.class);
            startActivity(intent);
        } else if (v == mGroceryListButton) {
            Intent intent = new Intent(UserActivity.this, AddARecipeActivity.class);
            startActivity(intent);
        } else if (v == mFavoritesButton) {
            Intent intent = new Intent(UserActivity.this, FavoritesActivity.class);
            startActivity(intent);
        } else if (v == mAddARecipeButton) {
            String recipe = mRecipeEditText.getText().toString();
            Intent intent = new Intent(UserActivity.this, AddARecipeActivity.class);
            intent.putExtra("recipe", recipe);
            startActivity(intent);
        }
    }
}

