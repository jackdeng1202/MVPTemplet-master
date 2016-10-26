package com.wtm.mvpdemo.model;

/**
 * Model：登录业务逻辑
 *
 */
public interface IUserLoginModel {

    /**
     * 登录业务逻辑
     * @param username
     * @param password
     * @param listener
     */
    void login(String username, String password, OnUserLoginListener listener);
}
