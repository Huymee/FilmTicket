package com.yuqs.filmticket.Activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.SetMyActionBar;

public class FeedBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        SetMyActionBar.setActionBar(this, getSupportActionBar(), getString(R.string.my_fragment_feedback), true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    /**
     * 提交意见
     * @param view
     */
    public void submit(View view){
        new AlertDialog.Builder(this).setTitle("意见反馈").setMessage("感谢您的宝贵意见,我们将高度重视您所提出的意见和建议\n谢谢！").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onBackPressed();
            }
        }).create().show();
    }
}
