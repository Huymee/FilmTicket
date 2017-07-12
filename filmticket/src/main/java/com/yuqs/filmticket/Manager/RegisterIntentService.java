package com.yuqs.filmticket.Manager;

import android.app.IntentService;
import android.content.Intent;


import com.yuqs.filmticket.Entity.UserEntity;


/**
 * 注册账号的服务
 */

public class RegisterIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public RegisterIntentService() {
        super("RegisterIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        //接收数据 // TODO: 17/06/24 写入注册逻辑
        UserEntity userEntity = (UserEntity) intent.getSerializableExtra("data");

    }
}
