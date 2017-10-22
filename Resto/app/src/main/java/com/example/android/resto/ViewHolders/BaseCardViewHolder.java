package com.example.android.resto.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.example.android.resto.App;
import com.example.android.resto.Enums.CardType;
import com.example.android.resto.R;

/**
 * Created by android on 10/15/2017.
 */

public class BaseCardViewHolder extends RecyclerView.ViewHolder {

    public BaseCardViewHolder(View itemView) {

        super(itemView);

    }

    public static BaseCardViewHolder createViewHolder(CardType type) {

        View itemView;

        LayoutInflater inflater = LayoutInflater.from(App.getContext());

        switch (type) {

            case CITY_CARD:

                itemView = inflater.inflate(R.layout.view_city_card,null);

                return new CityCardViewHolder(itemView);

            case RESTO_CARD:

                itemView = inflater.inflate(R.layout.view_restaurant_layout, null);

                return new RestoCardViewHolder(itemView);

        }

        return null;
    }

    public void init(Object value) {

    }
}
