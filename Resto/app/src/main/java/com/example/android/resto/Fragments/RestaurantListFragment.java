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
import com.example.android.resto.App;
import com.example.android.resto.Enums.CardType;
import com.example.android.resto.FragArgs;
import com.example.android.resto.Interfaces.RetroCallback;
import com.example.android.resto.Managers.RetrofitManager;
import com.example.android.resto.Models.City;
import com.example.android.resto.Models.Restaurant;
import com.example.android.resto.Models.RestaurantsResponse;
import com.example.android.resto.R;
import com.example.android.resto.Utilities.UIUtil;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by android on 10/3/2017.
 */

public class RestaurantListFragment extends BaseFragment {

    RecyclerView restoList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_restaurant_list, null);

        restoList = rootView.findViewById(R.id.resto_list);

        City city = (City) args.get(FragArgs.CITY);

        TextView title = rootView.findViewById(R.id.city_name);

        title.setText(city.getName());

        UIUtil.showLoadingView((ViewGroup) rootView);

        RetrofitManager.getInstance().getRestaurantList(new RetroCallback<RestaurantsResponse>() {
            @Override
            public void onResult(boolean isSuccess, RestaurantsResponse result) {

                UIUtil.hideLoadingView(rootView);

                if(isSuccess) {

                    List<Restaurant> restaurants = result.getRestaurants();

                    initializeRestaurants(restaurants);

                }

            }
        });

        return rootView;
    }

    private void initializeRestaurants(List<Restaurant> restaurants) {

        restoList.setLayoutManager(new LinearLayoutManager(App.getContext()));

        restoList.setAdapter(new CardListAdapter(restaurants, CardType.RESTO_CARD));
    }
}
