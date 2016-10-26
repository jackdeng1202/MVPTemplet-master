package com.wtm.mvpdemo.model;

import android.os.SystemClock;

/**
 * Model层，用户登录
 */
public class UserLoginModel implements IUserLoginModel {
    @Override
    public void login(final String username, final String password, final OnUserLoginListener listener) {
        //模拟网络耗时操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(1500);
                //登录业务逻辑
                if("heima26".equals(username) && "123456".equals(password)){//登录成功
                    User user = new User(username, password);
                    listener.loginSuccess(user);
                }else{//登录失败
                    listener.loginFailed();
                }
            }
        }).start();
    }
}
