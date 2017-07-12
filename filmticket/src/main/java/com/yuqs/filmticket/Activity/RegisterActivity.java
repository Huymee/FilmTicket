package com.yuqs.filmticket.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.Entity.UserEntity;
import com.yuqs.filmticket.Manager.RegisterIntentService;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.ProgressDialogUtil;
import com.yuqs.filmticket.Util.SetMyActionBar;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUserName;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private EditText etName;
    private Button btnRegister;
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        SetMyActionBar.setActionBar(this,getSupportActionBar(),"用户登录",true);
        initViews();
        addListener();
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, new IntentFilter(IURL.ACTION_REGISTER));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        //activity销毁时解除注册，以免内存泄漏
        unregisterReceiver(myReceiver);
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onSetResult();
        }
        return super.onKeyDown(keyCode, event);
    }

    private void onSetResult() {
        String username = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("username", username);
        intent.putExtra("password", password);
        setResult(IURL.REGISTER_REQUEST_CODE, intent);
        this.finish();
    }

    private void addListener() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //从控件中获取用户输入的数据
                String username = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                String name = etName.getText().toString();
                //创建错误信息
                StringBuilder builder = new StringBuilder();
                if (TextUtils.isEmpty(username)) builder.append("用户名不能为空\n");
                if (TextUtils.isEmpty(password)) builder.append("密码不能为空\n");
                if (!TextUtils.isEmpty(password) && !password.equals(confirmPassword))
                    builder.append("两次密码输入不一致\n");
                if (TextUtils.isEmpty(name)) builder.append("昵称不能为空\n");
                //如果错误信息不为空，则Toast错误信息
                if (!TextUtils.isEmpty(builder))
                    Toast.makeText(RegisterActivity.this, builder.substring(0, builder.length() - 2), Toast.LENGTH_SHORT).show();
                else {
                    //将获得的数据整合成一个userEntity
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUserName(username);
                    userEntity.setPassword(password);
                    userEntity.setName(name);
                    //启动RegisterIntentService并将userEntity通过intent传送过去
                    Intent intent = new Intent(RegisterActivity.this, RegisterIntentService.class);
                    intent.putExtra("data", userEntity);
                    startService(intent);
                    ProgressDialogUtil.showProgressDialog(RegisterActivity.this, "正在注册", true);
                }

            }
        });
    }

    private void initViews() {
        etUserName = (EditText) findViewById(R.id.et_register_username);
        etPassword = (EditText) findViewById(R.id.et_register_password);
        etConfirmPassword = (EditText) findViewById(R.id.et_register_confirm_password);
        etName = (EditText) findViewById(R.id.et_register_name);
        btnRegister = (Button) findViewById(R.id.btn_register_submit);
    }

    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int stateCode = intent.getIntExtra("data", 0);
            if (stateCode == IURL.STATE_SUCCESS) {
                Toast.makeText(context, "注册成功", Toast.LENGTH_SHORT).show();
                ProgressDialogUtil.progressDialog.dismiss();
                onSetResult();
            } else {
                Toast.makeText(context, "注册失败", Toast.LENGTH_SHORT).show();
                ProgressDialogUtil.progressDialog.dismiss();
            }
        }
    }
}
