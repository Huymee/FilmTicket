package com.yuqs.filmticket.Util;

import android.support.v7.app.ActionBar;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.yuqs.filmticket.R;

public class SetMyActionBar {
    public static void setActionBar(Context context, ActionBar actionBar, String title, boolean showUp) {
        TextView tvTitle = (TextView) View.inflate(context, R.layout.abar_title, null);
        tvTitle.setText(title);
        if (actionBar != null) {
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(showUp);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setCustomView(tvTitle, new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        }
    }
}
