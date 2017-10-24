package com.example.android.resto.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.android.resto.Enums.CardType;
import com.example.android.resto.Interfaces.CardFactory;
import com.example.android.resto.Models.CardModel;
import com.example.android.resto.ViewHolders.BaseCardViewHolder;

import java.util.List;

/**
 * Created by Android on 10/24/2017.
 */

public class CardsAdapter extends RecyclerView.Adapter<BaseCardViewHolder> {

    List<CardModel> cardModels;

    public CardsAdapter(CardFactory cardFactory) {

        this.cardModels = cardFactory.getCardModels();

    }

    @Override
    public BaseCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardType type = cardModels.get(viewType).getType();

        BaseCardViewHolder cardViewHolder =
                BaseCardViewHolder.createViewHolder(type);

        return cardViewHolder;
    }

    @Override
    public int getItemViewType(int position) {

        return position;

    }

    @Override
    public void onBindViewHolder(BaseCardViewHolder holder, int position) {

        holder.init(cardModels.get(position).getValue());

    }

    @Override
    public int getItemCount() {

        return cardModels == null ? 0 : cardModels.size();

    }
}
