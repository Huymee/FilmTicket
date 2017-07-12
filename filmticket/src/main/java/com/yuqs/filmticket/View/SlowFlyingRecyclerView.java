package com.yuqs.filmticket.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by 46433 on 17/05/24.
 */

public class SlowFlyingRecyclerView extends RecyclerView {
    public SlowFlyingRecyclerView(Context context) {
        super(context);
    }

    public SlowFlyingRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SlowFlyingRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setRecycledViewPool(RecycledViewPool pool) {
        super.setRecycledViewPool(pool);
    }
}
