package com.wtm.mvpdemo.view;


import com.wtm.mvpdemo.model.User;

/**
 * View层，如何实现View层，View层是最复杂的一层
 * 1.有什么操作：获取用户名、获取密码
 * 2.有什么用户交互：显示滚动条、隐藏滚动条
 * 3.有什么结果：登录成功跳转主页、登录失败提示用户
 */
public interface IUserLoginView {
    /**获取用户名*/
    String getUsername();
    /**获取密码*/
    String getPassword();

    /**显示滚动条*/
    void showProgressbar();
    /**隐藏滚动条*/
    void hideProgressbar();

    /**登录成功跳转主页*/
    void jump2Main(User user);
    /**登录失败提示用户*/
    void showLoginError();
}
