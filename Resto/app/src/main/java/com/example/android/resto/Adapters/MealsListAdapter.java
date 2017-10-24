package com.example.android.resto.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.android.resto.App;
import com.example.android.resto.R;

import java.util.List;

/**
 * Created by Android on 10/24/2017.
 */

public class MealsListAdapter extends BaseAdapter {

    List<String> meals;

    public MealsListAdapter(List<String> meals) {

        this.meals = meals;

    }

    @Override
    public int getCount() {

        return meals == null ? 0 : meals.size();

    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(App.getContext()).inflate(R.layout.view_name_card, null);

        TextView name = view.findViewById(R.id.name);

        name.setText(" • " + meals.get(position));

        return view;
    }
}
