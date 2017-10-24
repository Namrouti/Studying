package com.example.android.resto.ViewHolders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.resto.App;
import com.example.android.resto.FragArgs;
import com.example.android.resto.Fragments.RestaurantDetailsFragment;
import com.example.android.resto.Fragments.RestaurantListFragment;
import com.example.android.resto.Managers.FragmentManager;
import com.example.android.resto.Models.City;
import com.example.android.resto.Models.Restaurant;
import com.example.android.resto.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by android on 10/15/2017.
 */

public class RestoCardViewHolder extends BaseCardViewHolder {

    public RestoCardViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void init(Object value) {

        final Restaurant restaurant = (Restaurant) value;

        ImageView restoImage = itemView.findViewById(R.id.restaurant_image);

        TextView name = itemView.findViewById(R.id.resto_name);

        TextView address = itemView.findViewById(R.id.address);

        TextView category = itemView.findViewById(R.id.category);

        RatingBar ratingBar = itemView.findViewById(R.id.rating);

        name.setText(restaurant.getName());

        address.setText(restaurant.getAddress());

        category.setText(restaurant.getCategory());

        ratingBar.setRating(restaurant.getRating());

        Picasso.with(App.getContext()).load(restaurant.getImage()).into(restoImage);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle args = new Bundle();

                args.putSerializable(FragArgs.RESTAURANT, restaurant);

                FragmentManager.showFragment(RestaurantDetailsFragment.class, null, args);

            }
        });

    }
}
