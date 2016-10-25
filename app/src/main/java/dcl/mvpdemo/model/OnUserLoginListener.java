package com.itheima.mvpdemo.model;

/**
 * 用户登录回调接口
 */
public interface OnUserLoginListener {

    /**
     * 登录成功
     * @param user
     */
    void loginSuccess(User user);

    /**
     * 登录失败
     */
    void loginFailed();
}
