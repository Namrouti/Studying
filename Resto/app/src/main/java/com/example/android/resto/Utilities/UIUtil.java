package com.example.android.resto.Utilities;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.resto.App;
import com.example.android.resto.R;

/**
 * Created by android on 10/10/2017.
 */

public class UIUtil {

    public static void showLoadingView(ViewGroup rootView){

        View loadingView = rootView.findViewById(R.id.loading_view);

        if(loadingView == null) {

            loadingView = LayoutInflater.from(App.getContext()).inflate(R.layout.loading_dialog, null);

        }

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        rootView.addView(loadingView, params);

    }

    public static void hideLoadingView(View rootView) {

        View loadingView = rootView.findViewById(R.id.loading_view);

        if(loadingView != null) {

            ((ViewGroup)rootView).removeView(loadingView);
        }
    }

}
