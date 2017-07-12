package com.yuqs.filmticket.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.SetMyActionBar;

public class MyRechargeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recharge);
        SetMyActionBar.setActionBar(this, getSupportActionBar(), getResources().getString(R.string.recharge_title), true);
        final EditText editText = (EditText) findViewById(R.id.et_money);
        Button button = (Button) findViewById(R.id.btn_sure_to_recharge);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg_pay_type);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().isEmpty()) {
                    Toast.makeText(MyRechargeActivity.this, "请输入要充值的金额", Toast.LENGTH_SHORT).show();
                    return;
                }
                int money = Integer.valueOf(editText.getText().toString());
                int payType = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
                String payTypeStr;
                if (payType == 0) payTypeStr = "微信";
                else if (payType == 1) payTypeStr = "支付宝";
                else {
                    Toast.makeText(MyRechargeActivity.this, "请选择付款方式", Toast.LENGTH_SHORT).show();
                    return;
                }
                new AlertDialog.Builder(MyRechargeActivity.this).setTitle("请确认").setMessage("确定通过" + payTypeStr + "充值，\n充值金额为:人民币" + money + "元。")
                        .setPositiveButton("确定充值", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO 根据选择 来对接支付宝或微信接口
                                Toast.makeText(MyRechargeActivity.this, "正在跳转到充值界面", Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("返回修改", null).create().show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
