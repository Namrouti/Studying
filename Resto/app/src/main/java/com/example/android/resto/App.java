package com.example.android.resto;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by android on 10/3/2017.
 */

public class App extends Application {

    private static Context context;

    private static AppCompatActivity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();

        App.context = this;
    }

    public static Context getContext() {
        return context;
    }

    public static void setCurrentActivity(AppCompatActivity currentActivity) {
        App.currentActivity = currentActivity;
    }

    public static AppCompatActivity getCurrentActivity() {
        return currentActivity;
    }
}
