package com.example.android.resto.Fragments;

import android.support.v4.app.Fragment;
import android.view.View;

import java.util.Map;

/**
 * Created by android on 10/3/2017.
 */

public class BaseFragment extends Fragment {

    public View rootView;

    Map<String, Object> args;


    public void setArgs(Map<String, Object> args) {
        this.args = args;
    }
}
