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

import java.util.List;

/**
 * Created by android on 10/3/2017.
 */

public class AboutUsFragment extends BaseFragment {

    RecyclerView restoList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_about, null);

        return rootView;
    }
}
