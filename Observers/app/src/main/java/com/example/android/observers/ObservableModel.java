package com.example.android.observers;

/**
 * Created by android on 10/17/2017.
 */

public class ObservableModel {

    EventType type;

    Object value;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {

        if(value == null) {

            value = "";
        }

        return value.toString();
    }
}
