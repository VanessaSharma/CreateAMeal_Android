package com.epicodus.createameal.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.createameal.R;
import com.epicodus.createameal.models.Recipe;
import com.epicodus.createameal.ui.RecipeDetailActivity;
import com.epicodus.createameal.ui.RecipeDetailFragment;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
   private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;


    private ArrayList<Recipe> mRecipes = new ArrayList<>();
    private Context mContext;

    public RecipeListAdapter(Context context, ArrayList<Recipe> recipes) {
        mContext = context;
        mRecipes = recipes;
    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position) {
        holder.bindRecipe(mRecipes.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.recipeImageView) ImageView mRecipeImageView;
        @Bind(R.id.recipeNameTextView) TextView mRecipeNameTextView;
        @Bind(R.id.ingredientsTextView) TextView mIngredientsTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;

    private Context mContext;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindRecipe(Recipe recipe) {
            Picasso.with(mContext)
                    .load(recipe.getImageUrl())
                    .into(mRecipeImageView);

            mRecipeNameTextView.setText(recipe.getName());
            mIngredientsTextView.setText(recipe.getIngredients().get(0));
            mRatingTextView.setText("Rating: " + recipe.getRating() + "/5");
        }
        @Override
        public void onClick(View v) {
            Log.d("click listener", "working!");
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, RecipeDetailActivity.class);
            intent.putExtra("position", itemPosition + "");
            intent.putExtra("recipes", Parcels.wrap(mRecipes));
            mContext.startActivity(intent);
        }
    }
}
