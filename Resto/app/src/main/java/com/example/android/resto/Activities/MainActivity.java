package com.example.android.resto.Activities;

import android.app.Activity;
import android.graphics.Point;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.android.resto.App;
import com.example.android.resto.Enums.EventType;
import com.example.android.resto.Fragments.AboutUsFragment;
import com.example.android.resto.Fragments.HomeFragment;
import com.example.android.resto.Managers.FragmentManager;
import com.example.android.resto.Models.ObservableModel;
import com.example.android.resto.R;
import com.example.android.resto.Utilities.EventObservable;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends BaseActivity implements Observer{

    private DrawerLayout mDrawer;
    private NavigationView nvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.setCurrentActivity(this);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        nvView = (NavigationView) findViewById(R.id.nvView);

        setupDrawerContent(nvView);

        FragmentManager.showFragment(HomeFragment.class);

        EventObservable.withType(EventType.MENU_OPEN).addObserver(this);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {

        Class fragmentClass = AboutUsFragment.class;

        switch(menuItem.getItemId()) {

            case R.id.about:

                FragmentManager.showFragment(fragmentClass);

                break;

            case R.id.exit:

                finish();

                break;

        }

        mDrawer.closeDrawers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        App.setCurrentActivity(null);

        EventObservable.withType(EventType.MENU_OPEN).deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        if(arg == null || !(arg instanceof ObservableModel)) {

            return;

        }

        ObservableModel model = (ObservableModel) arg;

        switch (model.getType()) {

            case MENU_OPEN:

                mDrawer.openDrawer(Gravity.START);

                break;
        }

    }
}
