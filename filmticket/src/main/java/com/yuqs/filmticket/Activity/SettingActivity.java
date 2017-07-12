package com.yuqs.filmticket.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yuqs.filmticket.Manager.DataCleanManager;
import com.yuqs.filmticket.R;
import com.yuqs.filmticket.Util.SetMyActionBar;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        SetMyActionBar.setActionBar(this, getSupportActionBar(), getString(R.string.setting_title), true);
        toast = new Toast(this).makeText(this, "", Toast.LENGTH_SHORT);
        TextView tvUpdate = (TextView) findViewById(R.id.tv_update);
        TextView tvAbout = (TextView) findViewById(R.id.tv_setting_about_app);
        LinearLayout llQQ = (LinearLayout) findViewById(R.id.ll_setting_QQ);
        LinearLayout llTel = (LinearLayout) findViewById(R.id.ll_setting_tel);
        TextView tvProtocol = (TextView) findViewById(R.id.tv_protocol);
        LinearLayout llCache = (LinearLayout) findViewById(R.id.ll_cache);
        tvUpdate.setOnClickListener(this);
        tvAbout.setOnClickListener(this);
        llQQ.setOnClickListener(this);
        llTel.setOnClickListener(this);
        tvProtocol.setOnClickListener(this);
        llCache.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_update:
                toast.setText("已经是最新版本");
                toast.show();
                break;
            case R.id.tv_setting_about_app:
                new AlertDialog.Builder(this).setTitle("关于软件")
                        .setMessage("软件界面参考:哈票\n软件开发人员:余强胜\n" +
                                "开发人员联系电话:15926962252\n开发人员QQ:464333686\n" +
                                "软件版本:V." + getVersion())
                        .setPositiveButton("确定", null).create().show();
                break;
            case R.id.ll_setting_QQ:
                String url = "mqqwpa://im/chat?chat_type=wpa&uin=464333686";
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } catch (Exception e) {
                    Toast.makeText(this, "无法打开QQ聊天窗口\n请确定是否已安装QQ\n或使用其它方式联系", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ll_setting_tel:
                checkPermission();
                break;
            case R.id.tv_protocol:
                new AlertDialog.Builder(this).setTitle("关于软件")
                        .setMessage("用户协议\n这里是用户协议\n\n\n\n\n\n这里是用户协议\n\n\n\n\n" +
                                "\n这里是用户协议\n\n\n\n\n\n这里是用户协议\n\n\n\n\n" +
                                "\n这里是用户协议\n\n\n\n\n\n这里是用户协议\n\n\n\n\n" +
                                "\n这里是用户协议\n\n\n\n\n\n这里是用户协议\n\n\n\n\n" +
                                "\n这里是用户协议\n\n\n\n\n\n这里是用户协议\n\n\n\n\n" +
                                "\n这里是用户协议\n\n\n\n\n\n这里是用户协议")
                        .setPositiveButton("确定", null).create().show();
                break;
            case R.id.ll_cache:
                DataCleanManager.cleanInternalCache(this);
                toast.setText("缓存清除完成");
                toast.show();
                break;
        }
    }

    private void callCustomerService() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+8615926962252"));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查用户权限
     */
    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 100);//这里的100是一个执行代码
            } else callCustomerService();//获取权限后执行自己的方法
        } else callCustomerService();//版本低于Android 6.0,不需要检查运行时权限,直接执行操作
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 100://对应上面定义的执行代码
                if (permissions.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            Toast.makeText(this, "必须获得所需的权限才能使用此功能", Toast.LENGTH_SHORT).show();
                            return;
                        } else callCustomerService();//获取权限后执行自己的方法
                    }
                } else Toast.makeText(this, "没有获得任何权限", Toast.LENGTH_SHORT).show();
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public String getVersion() {
        String version = "0.0.0";
        try {
            PackageManager manager = this.getPackageManager();
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            version = info.versionName;
        } catch (Exception e) {e.printStackTrace();}
        return version;
    }
}
