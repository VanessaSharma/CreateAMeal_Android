package com.epicodus.createameal.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.createameal.R;
import com.epicodus.createameal.models.Recipe;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecipeDetailFragment extends Fragment implements View.OnClickListener {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    @Bind(R.id.recipeImageView)
    ImageView mImageLabel;
    @Bind(R.id.recipeNameTextView)
    TextView mNameLabel;
    @Bind(R.id.ingredientsTextView)
    TextView mIngredientsLabel;
    @Bind(R.id.ratingTextView)
    TextView mRatingLabel;
    @Bind(R.id.timeTextView)
    TextView mTimeTextView;
    @Bind(R.id.ratingsTextView)
    TextView mRatingsTextView;
    @Bind(R.id.saveRecipeButton)
    TextView mSaveRecipeButton;

    private Recipe mRecipe;

    public static RecipeDetailFragment newInstance(Recipe recipe) {
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mRecipe.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mImageLabel);


        mNameLabel.setText(mRecipe.getName());
        mIngredientsLabel.setText(android.text.TextUtils.join(", ", mRecipe.getIngredients()));
        mRatingLabel.setText(Double.toString(mRecipe.getRating()) + "/5");
        mTimeTextView.setText(mRecipe.getTime());
        mIngredientsLabel.setText(android.text.TextUtils.join(", ", mRecipe.getIngredients()));


        mNameLabel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mNameLabel) {
            Intent nameIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mRecipe.getName()));
            startActivity(nameIntent);
        }
    }
}