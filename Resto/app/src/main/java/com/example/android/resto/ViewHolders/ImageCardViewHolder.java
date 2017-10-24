package com.example.android.resto.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.android.resto.App;
import com.example.android.resto.Constants;
import com.example.android.resto.Models.Restaurant;
import com.example.android.resto.R;
import com.squareup.picasso.Picasso;

/**
 * Created by android on 10/15/2017.
 */

public class ImageCardViewHolder extends BaseCardViewHolder {

    public ImageCardViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void init(Object value) {

        String url = value!= null ? value.toString(): Constants.DEFAULT_IMAGE_URL;

        ImageView coverImage = itemView.findViewById(R.id.image);

        Picasso.with(App.getContext()).load(url).into(coverImage);

    }
}
