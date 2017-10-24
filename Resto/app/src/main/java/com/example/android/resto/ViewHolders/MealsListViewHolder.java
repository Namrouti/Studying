package com.example.android.resto.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.resto.Adapters.MealsListAdapter;
import com.example.android.resto.R;
import com.example.android.resto.Utilities.UIUtil;

import java.util.List;

/**
 * Created by android on 10/15/2017.
 */

public class MealsListViewHolder extends BaseCardViewHolder {

    public MealsListViewHolder(View itemView) {

        super(itemView);

    }

    @Override
    public void init(Object value) {
        super.init(value);

        ListView meals = itemView.findViewById(R.id.meals);

        List<String> mealsList = (List<String>) value;

        if(mealsList == null) {

            return;
        }

        meals.setAdapter(new MealsListAdapter(mealsList));

        int height = mealsList.size() * UIUtil.dpToPx(45);

        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);

        itemView.setLayoutParams(params);

    }
}
