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

public class CardListAdapter extends RecyclerView.Adapter<BaseCardViewHolder> {

    List<?> list;

    CardType cardType;

    public CardListAdapter(List<?> list, CardType type) {

        this.list = list;

        cardType = type;
    }

    @Override
    public BaseCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return BaseCardViewHolder.createViewHolder(cardType);

    }

    @Override
    public void onBindViewHolder(BaseCardViewHolder holder, int position) {

        holder.init(list.get(position));

    }

    @Override
    public int getItemCount() {

        return list == null ? 0 : list.size();

    }
}
