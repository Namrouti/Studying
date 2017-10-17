package com.example.android.observers;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Created by android on 10/17/2017.
 */

public class EventObservable extends Observable {

    private static Map<EventType, EventObservable> map = new HashMap<>();

    private EventObservable() {

    }

    public static EventObservable withType(EventType type) {

        if(map.get(type) == null) {

            EventObservable observable = new EventObservable();

            map.put(type, observable);
        }

        return map.get(type);

    }

    public void notifyObservers(ObservableModel model) {

        setChanged();

        super.notifyObservers(model);
    }

}
