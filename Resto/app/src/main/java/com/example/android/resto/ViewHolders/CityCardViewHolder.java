package com.example.android.resto.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.resto.App;
import com.example.android.resto.Models.City;
import com.example.android.resto.R;
import com.squareup.picasso.Picasso;

/**
 * Created by android on 10/15/2017.
 */

public class CityCardViewHolder extends BaseCardViewHolder {

    public CityCardViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void init(Object value) {

        City city = (City) value;

        ImageView cityImage = itemView.findViewById(R.id.city_image);

        TextView cityName = itemView.findViewById(R.id.city_name);

        TextView countryName = itemView.findViewById(R.id.country);

        cityName.setText(city.getName());

        countryName.setText(city.getCountryName());

        String imageUrl = city.getImage();

        Picasso.with(App.getContext()).load(imageUrl).into(cityImage);

    }
}
