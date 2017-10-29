package com.example.android.resto.Models;

import com.example.android.resto.Enums.EventType;

/**
 * Created by android on 10/17/2017.
 */

public class ObservableModel {

    EventType type;

    Object value;

    public EventType getType() {
        return type;
    }

    public ObservableModel setType(EventType type) {

        this.type = type;

        return this;
    }

    public Object getValue() {
        return value;
    }

    public ObservableModel setValue(Object value) {

        this.value = value;

        return this;
    }

    @Override
    public String toString() {

        if(value == null) {

            value = "";
        }

        return value.toString();
    }
}
