package com.example.android.resto.Models;

import com.example.android.resto.Enums.CardType;

/**
 * Created by Android on 10/24/2017.
 */

public class CardModel {

    CardType type;

    Object value;

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
