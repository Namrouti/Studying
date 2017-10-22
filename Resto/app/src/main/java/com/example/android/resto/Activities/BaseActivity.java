package com.example.android.resto.Activities;

import android.support.v7.app.AppCompatActivity;

import com.example.android.resto.App;

/**
 * Created by android on 10/3/2017.
 * 
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        App.setCurrentActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        App.setCurrentActivity(null);
    }
}
