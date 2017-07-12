package com.yuqs.filmticket.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.SetMyActionBar;

public class MyDiscountActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_discount);
        SetMyActionBar.setActionBar(this,getSupportActionBar(),getResources().getString(R.string.my_discount),true);
        ListView listView= (ListView) findViewById(R.id.lv_my_discount);
        editText = (EditText) findViewById(R.id.et_my_discount_code);
        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.rg_my_discount);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_my_discount_a:editText.setHint(R.string.payment_order_apply_red_package);
                        break;
                    case R.id.rb_my_discount_b:editText.setHint(R.string.payment_order_apply_exchange);
                        break;
                }
            }
        });
        ((RadioButton)radioGroup.getChildAt(0)).setChecked(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}