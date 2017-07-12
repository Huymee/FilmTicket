package com.yuqs.filmticket.View;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.yuqs.filmticket.Adapter.HSVBaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class HSVLayout extends LinearLayout {

    public HSVBaseAdapter adapter;
    public Context context;
    private int temp = -1;
    private List<View> list = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private OnItemSelectedListener onItemSelectedListener;
    private int mSelectedColor = Color.WHITE;


    public HSVLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void setAdapter(final HSVBaseAdapter adapter, int paddingLeft, int paddingTop,
                           int paddingRight, int paddingBottom) {
        this.adapter = adapter;
        this.removeAllViews();
        int length = adapter.getCount();
        for (int i = 0; i < length; i++) {
            final View view = adapter.getView(i, null, null);
            view.setId(generateViewId());
            view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            list.add(view);
        }
        for (int i = 0; i < length; i++) {
            final View view = list.get(i);
            // 为视图设定点击监听器
            final int finalI = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, finalI);
                    }
                    doItemSelected(finalI, v);
                }
            });
            this.setOrientation(HORIZONTAL);
            this.addView(view, new LinearLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        }
    }

    public void setItemSelected(int position) {
        if (list == null) {
            return;
        }
        View v = list.get(position);
        doItemSelected(position, v);
    }

    private void doItemSelected(int position, View view) {
        if (onItemSelectedListener != null) {
            int viewId = view.getId();
            if (temp != viewId) {
                if (temp != -1) {
                    View view1 = findViewById(temp);
                    view1.setSelected(false);
                    view1.setBackgroundColor(Color.TRANSPARENT);
                }
                view.setSelected(true);
                view.setBackgroundColor(mSelectedColor);
                onItemSelectedListener.onItemSelected(view, position);
                temp = viewId;
            }
        }
    }

    public void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener listener, int selectedColor) {
        onItemSelectedListener = listener;
        mSelectedColor = selectedColor;
    }

    public interface OnItemClickListener {
        void onItemClick(View item, int position);
    }

    public interface OnItemSelectedListener {
        void onItemSelected(View item, int position);
    }
}