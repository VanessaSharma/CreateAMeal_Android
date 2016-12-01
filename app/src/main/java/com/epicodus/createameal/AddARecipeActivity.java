package com.epicodus.createameal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddARecipeActivity extends AppCompatActivity {
    @Bind(R.id.recipeLookup) EditText mRecipeLookup;
    @Bind(R.id.searchButton) Button mSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(new View.OnClickListener(){
            @Override
             public void onClick(View v){
                String recipeLookup = mRecipeLookup.getText().toString();
                Intent intent = new Intent(AddARecipeActivity.this, RecipeResultsActivity.class);
                intent.putExtra("recipeLookup", recipeLookup);
                startActivity(intent);
            }

        });
    }
}
