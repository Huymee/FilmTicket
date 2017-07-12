package com.yuqs.filmticket.Activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.yuqs.filmticket.Entity.IURL;
import com.yuqs.filmticket.Entity.UserEntity;
import com.yuqs.filmticket.Manager.LoginBiz;
import com.yuqs.filmticket.MyApplication;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.ProgressDialogUtil;
import com.yuqs.filmticket.Util.SetMyActionBar;


public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnRegister;
    private EditText etUserName;
    private EditText etPassword;
    LoginReceiver loginReceiver;
    private String userName;
    private String password;
    private boolean remenberPassword;
    private boolean autoLogin;
    private CheckBox cbRemenberPassword;
    private CheckBox cbAutoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SetMyActionBar.setActionBar(this, getSupportActionBar(), "用户登录", true);
        initViews();
        getSharedPreferences();
        addListener();
        loginReceiver = new LoginReceiver();
        registerReceiver(loginReceiver, new IntentFilter(IURL.ACTION_LOGIN));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    private void getSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences("userLogin", MODE_PRIVATE);
        remenberPassword = preferences.getBoolean("remenberPassword", remenberPassword);
        autoLogin = preferences.getBoolean("autoLogin", autoLogin);
        userName = preferences.getString("username", "");
        password = preferences.getString("password", "");
        if (remenberPassword) {
            etUserName.setText(userName);
            etPassword.setText(password);
            cbRemenberPassword.setChecked(true);
            if (autoLogin) {
                cbAutoLogin.setChecked(true);
                onLogin();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IURL.REGISTER_REQUEST_CODE) {
            etUserName.setText(data.getStringExtra("username"));
            etPassword.setText(data.getStringExtra("password"));
            onLogin();
        }
    }

    @Override
    protected void onDestroy() {
        remenberPassword = cbRemenberPassword.isChecked();
        autoLogin = cbAutoLogin.isChecked();
        SharedPreferences preferences = getSharedPreferences("userLogin", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", userName);
        editor.putString("password", password);
        editor.putBoolean("remenberPassword", remenberPassword);
        editor.putBoolean("autoLogin", autoLogin);
        editor.commit();
        unregisterReceiver(loginReceiver);
        super.onDestroy();
    }

    private void addListener() {
        cbAutoLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) cbRemenberPassword.setChecked(isChecked);
            }
        });
        cbRemenberPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) cbAutoLogin.setChecked(false);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(LoginActivity.this, RegisterActivity.class), IURL.REGISTER_REQUEST_CODE);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin();
            }
        });
    }

    private void onLogin() {
        userName = etUserName.getText().toString();
        password = etPassword.getText().toString();
        LoginBiz loginBiz = new LoginBiz();
        UserEntity userEntity = new UserEntity(userName, password);
        loginBiz.login(userEntity);
        ProgressDialogUtil.showProgressDialog(LoginActivity.this, "正在登陆", true);
    }

    private void initViews() {
        cbRemenberPassword = (CheckBox) findViewById(R.id.cb_remenber_password);
        cbAutoLogin = (CheckBox) findViewById(R.id.cb_auto_login);
        btnLogin = (Button) findViewById(R.id.btn_login_submit);
        btnRegister = (Button) findViewById(R.id.btn_login_register);
        etUserName = (EditText) findViewById(R.id.et_login_username);
        etPassword = (EditText) findViewById(R.id.et_login_password);
    }

    class LoginReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int stateCode = intent.getIntExtra(IURL.KEY, 0);
            if (stateCode == IURL.STATE_SUCCESS) {
                //将用户信息传递给程序全局
                //获取用户信息
                userName = etUserName.getText().toString();
                password = etPassword.getText().toString();
                //传递给全局
                MyApplication.currentUser = new UserEntity(userName, password);
                Toast.makeText(context, "登陆成功", Toast.LENGTH_SHORT).show();
                //关闭进度条窗口
                ProgressDialogUtil.progressDialog.dismiss();
                //启动目标界面（程序主界面） TODO 修改程序主界面
                finish();
            } else {
                Toast.makeText(context, "登陆失败", Toast.LENGTH_SHORT).show();
                ProgressDialogUtil.progressDialog.dismiss();
            }
        }
    }
}
