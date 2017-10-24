package com.example.android.resto.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.example.android.resto.R;

/**
 * Created by android on 10/15/2017.
 */

public class NameCardViewHolder extends BaseCardViewHolder {

    public NameCardViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void init(Object value) {
        super.init(value);

        String name = value != null ? value.toString() : "";

        TextView nameTv = itemView.findViewById(R.id.name);

        nameTv.setText(name);
    }
}
