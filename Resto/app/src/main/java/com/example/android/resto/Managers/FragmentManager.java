package com.example.android.resto.Managers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.android.resto.App;
import com.example.android.resto.Fragments.BaseFragment;
import com.example.android.resto.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by android on 10/3/2017.
 */

public class FragmentManager {

    public static void addFragment(Fragment fragment) {

        FragmentTransaction transaction = App.getCurrentActivity().getSupportFragmentManager().beginTransaction();

        transaction.addToBackStack(fragment.getTag());

        transaction.add(R.id.flContent, fragment).commit();
        Log.d("status", "added");
    }

    public static <T extends BaseFragment> void showFragment(Class<T> clazz, Map<String, Object> args) {

        if(args == null) {

            args = new HashMap<>();

        }

        try {

            BaseFragment fragment = clazz.newInstance();

            fragment.setArgs(args);

            addFragment(fragment);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static <T extends BaseFragment> void showFragment(Class<T> clazz) {

        showFragment(clazz, null);

    }
}
