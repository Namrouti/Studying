package com.example.android.resto.Activities;

import android.app.Activity;
import android.graphics.Point;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;

import com.example.android.resto.App;
import com.example.android.resto.Fragments.HomeFragment;
import com.example.android.resto.Managers.FragmentManager;
import com.example.android.resto.R;

public class MainActivity extends BaseActivity {

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
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass = HomeFragment.class;
        switch(menuItem.getItemId()) {
            case R.id.home_fragment:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_second_fragment:
                //fragmentClass = SecondFragment.class;
                break;
            case R.id.nav_third_fragment:
                //fragmentClass = ThirdFragment.class;
                break;
            default:
                fragmentClass = HomeFragment.class;
        }

        FragmentManager.showFragment(fragmentClass);

        // Insert the fragment by replacing any existing fragment

        // Close the navigation drawer
        mDrawer.closeDrawers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        App.setCurrentActivity(null);
    }
}
