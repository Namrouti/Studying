package com.example.android.resto.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.resto.Adapters.CardListAdapter;
import com.example.android.resto.Adapters.CardsAdapter;
import com.example.android.resto.App;
import com.example.android.resto.Enums.CardType;
import com.example.android.resto.FragArgs;
import com.example.android.resto.Interfaces.CardFactory;
import com.example.android.resto.Interfaces.RetroCallback;
import com.example.android.resto.Managers.RetrofitManager;
import com.example.android.resto.Models.CardModel;
import com.example.android.resto.Models.City;
import com.example.android.resto.Models.Restaurant;
import com.example.android.resto.Models.RestaurantsResponse;
import com.example.android.resto.R;
import com.example.android.resto.Utilities.UIUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 10/3/2017.
 */

public class RestaurantDetailsFragment extends BaseFragment implements CardFactory {

    RecyclerView restaurantDetailsCards;

    CardsAdapter adapter;

    Restaurant restaurant;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_restaurant_details, null);

        restaurantDetailsCards = rootView.findViewById(R.id.resto_details_cards);

        restaurantDetailsCards.setLayoutManager(new LinearLayoutManager(App.getContext()));

        restaurant = (Restaurant) getArguments().getSerializable(FragArgs.RESTAURANT);

        adapter = new CardsAdapter(this);

        restaurantDetailsCards.setAdapter(adapter);

        UIUtil.showLoadingView((ViewGroup) rootView);

        RetrofitManager.getInstance().getRestaurantDetails(new RetroCallback<Restaurant>() {
            @Override
            public void onResult(boolean isSuccess, Restaurant result) {

                UIUtil.hideLoadingView(rootView);

                if(isSuccess) {

                    result.setName(restaurant.getName());

                    result.setImage(restaurant.getImage());

                    restaurant = result;

                    adapter = new CardsAdapter(RestaurantDetailsFragment.this);

                    restaurantDetailsCards.setAdapter(adapter);
                }

            }
        });

        return rootView;
    }

    @Override
    public List<CardModel> getCardModels() {

        List<CardModel> cardModels = new ArrayList<>();
        CardType[] cardTypes = {
                CardType.IMAGE_CARD,
                CardType.NAME_CARD,
                CardType.SEPARATOR,
                CardType.MEALS_CARD,
                CardType.SEPARATOR,
                CardType.DESCRIPTION_CARD};

        for (int i = 0 ;i < cardTypes.length ; i++) {

            cardModels.add(getCardModel(cardTypes[i]));
        }

        return cardModels;
    }

    private CardModel getCardModel(CardType type) {

        CardModel model = new CardModel();

        model.setType(type);

        switch (type) {

            case IMAGE_CARD:

                model.setValue(restaurant.getImage());

                break;

            case NAME_CARD:

                model.setValue(restaurant.getName());

                break;

            case MEALS_CARD:

                model.setValue(restaurant.getMeals());

                break;

            case DESCRIPTION_CARD:

                model.setValue(restaurant.getDescription());

                break;

        }

        return model;
    }
}
