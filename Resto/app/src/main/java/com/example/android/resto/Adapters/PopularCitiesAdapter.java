package com.example.android.resto.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.android.resto.Enums.CardType;
import com.example.android.resto.Models.City;
import com.example.android.resto.ViewHolders.BaseCardViewHolder;

import java.util.List;

/**
 * Created by android on 10/15/2017.
 */

public class PopularCitiesAdapter extends RecyclerView.Adapter<BaseCardViewHolder> {

    List<City> popular;

    public PopularCitiesAdapter(List<City> cities) {

        popular = cities;
    }

    @Override
    public BaseCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardType type = CardType.CITY_CARD;

        return BaseCardViewHolder.createViewHolder(type);

    }

    @Override
    public void onBindViewHolder(BaseCardViewHolder holder, int position) {

        holder.init(popular.get(position));

    }

    @Override
    public int getItemCount() {

        return popular == null ? 0 : popular.size();

    }
}
