package com.example.android.resto.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.resto.App;
import com.example.android.resto.FragArgs;
import com.example.android.resto.Fragments.RestaurantListFragment;
import com.example.android.resto.Managers.FragmentManager;
import com.example.android.resto.Models.City;
import com.example.android.resto.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by android on 10/15/2017.
 */

public class CityCardViewHolder extends BaseCardViewHolder {

    public CityCardViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void init(Object value) {

        final City city = (City) value;

        ImageView cityImage = itemView.findViewById(R.id.city_image);

        TextView cityName = itemView.findViewById(R.id.city_name);

        TextView countryName = itemView.findViewById(R.id.country);

        cityName.setText(city.getName());

        countryName.setText(city.getCountryName());

        String imageUrl = city.getImage();

        Picasso.with(App.getContext()).load(imageUrl).into(cityImage);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> args = new HashMap<>();

                args.put(FragArgs.CITY, city);

                FragmentManager.showFragment(RestaurantListFragment.class, args, null);

            }
        });

    }
}
