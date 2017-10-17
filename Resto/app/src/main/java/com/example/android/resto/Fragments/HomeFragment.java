package com.example.android.resto.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.resto.Adapters.PopularCitiesAdapter;
import com.example.android.resto.App;
import com.example.android.resto.Interfaces.RetroCallback;
import com.example.android.resto.Managers.RetrofitManager;
import com.example.android.resto.Models.City;
import com.example.android.resto.Models.PopularCitiesResponse;
import com.example.android.resto.R;
import com.example.android.resto.Utilities.UIUtil;

import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by android on 10/3/2017.
 */

public class HomeFragment extends BaseFragment {

    RecyclerView popularCitiesRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, null);

        popularCitiesRecycler = rootView.findViewById(R.id.popular);

        UIUtil.showLoadingView((ViewGroup) rootView);

        RetrofitManager.getInstance().getPopularCities(new RetroCallback<PopularCitiesResponse>() {
            @Override
            public void onResult(boolean isSuccess, PopularCitiesResponse result) {

                UIUtil.hideLoadingView(rootView);

                if (isSuccess) {

                    List<City> popular = result.getPopularCities();

                    initializePopularCities(popular);
                }

            }
        });

        return rootView;
    }

    private void initializePopularCities(List<City> popular) {

        popularCitiesRecycler.setLayoutManager(new LinearLayoutManager(App.getContext()));

        popularCitiesRecycler.setAdapter(new PopularCitiesAdapter(popular));
    }
}
