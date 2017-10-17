package com.example.android.observers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer{

    TextView clickMe;
    EventType type = EventType.NAME_CHANGED;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickMe = (TextView) findViewById(R.id.text);

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ObservableModel model = new ObservableModel();

                model.setType(type);

                model.setValue("hhhhhhhhhhhhhhhhhhhhhhhhh");

                EventObservable.withType(type).notifyObservers(model);

            }
        });

        EventObservable.withType(type).addObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {

        ObservableModel model = (ObservableModel) o;

        switch (model.getType()) {

            case DATE_CHANGED: {

                String data = "";

                if (o != null) {

                    data = o.toString();
                }

                Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

                break;

            }

            case NAME_CHANGED: {

                Toast.makeText(this, "NAME CHANGED!", Toast.LENGTH_SHORT).show();

                break;

            }
        }



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventObservable.withType(type).deleteObserver(this);
    }
}
