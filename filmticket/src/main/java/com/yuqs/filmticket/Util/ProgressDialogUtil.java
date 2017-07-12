package com.yuqs.filmticket.Util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.TextView;

import com.yuqs.filmticket.R;


/**
 * Created by 46433 on 17/05/19.
 * 自定义进度条
 */

public class ProgressDialogUtil {
    public static ProgressDialog progressDialog;

    public static void showProgressDialog(Activity activity, String msg,boolean clickOutsideClose) {

        progressDialog = new ProgressDialog(activity);
        progressDialog.show();
        View view = View.inflate(activity, R.layout.dialog, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_dialog);
        tv.setText(msg);
        progressDialog.getWindow().setContentView(view);
        int w, h;
        w = activity.getResources().getDisplayMetrics().widthPixels;
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        h = view.getMeasuredHeight();
        progressDialog.getWindow().setLayout(w, h);
        //设置在外部点击时不关闭
        progressDialog.setCanceledOnTouchOutside(clickOutsideClose);

    }
}
