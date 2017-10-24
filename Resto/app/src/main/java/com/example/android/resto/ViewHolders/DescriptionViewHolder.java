package com.example.android.resto.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.example.android.resto.R;

/**
 * Created by android on 10/15/2017.
 */

public class DescriptionViewHolder extends BaseCardViewHolder {

    public DescriptionViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void init(Object value) {
        super.init(value);

        String description = value == null ? "" : value.toString();

        TextView name = itemView.findViewById(R.id.name);

        name.setText(" • " + description);
    }
}
