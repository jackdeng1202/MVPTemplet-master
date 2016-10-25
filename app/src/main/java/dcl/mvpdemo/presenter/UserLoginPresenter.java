package com.itheima.mvpdemo.presenter;

import android.os.Handler;

import com.itheima.mvpdemo.model.IUserLoginModel;
import com.itheima.mvpdemo.model.OnUserLoginListener;
import com.itheima.mvpdemo.model.User;
import com.itheima.mvpdemo.model.UserLoginModel;
import com.itheima.mvpdemo.view.IUserLoginView;

/**
 * Presenter层
 * 1.p层既然起到桥梁的作用，p层必须持有model和view层对象（成员变量）
 * 2.既然起到桥梁的左右，所以需要提供桥梁方法，当前的业务逻辑是登录，所以桥梁方法也是为了登录服务
 */
public class UserLoginPresenter implements OnUserLoginListener {
    private IUserLoginModel userLoginModel;//model
    private IUserLoginView userLoginView;//view

    /**
     * 两个参数的构造方法对吗？
     * 如果是两个参数，p层是给View层调用的，说明activity持有model和view的对象，说明view和model连通了，不符合MVP架构
     * 所以只能是一个参数构造方法
     * @param userLoginModel
     * @param userLoginView
     */
  /*  public UserLoginPresenter(IUserLoginModel userLoginModel, IUserLoginView userLoginView) {
        this.userLoginModel = userLoginModel;
        this.userLoginView = userLoginView;
    }*/

    /**
     * 所以只能是一个参数构造方法
     * @param userLoginView
     */
    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginModel = new UserLoginModel();
        this.userLoginView = userLoginView;
    }

    /**
     * 沟通Model和view层的桥梁方法
     */
    public void login(){
        //1.登录（model）,下面一行代码集中体现presenter层起到桥梁作用
        userLoginModel.login(userLoginView.getUsername(), userLoginView.getPassword(),this);
        //2.显示滚动条（View）
        userLoginView.showProgressbar();
    }

    @Override
    public void loginSuccess(final User user) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //1.隐藏滚动条
                userLoginView.hideProgressbar();
                //2.跳转主页
                userLoginView.jump2Main(user);
            }
        });

    }

    @Override
    public void loginFailed() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //1.隐藏滚动条
                userLoginView.hideProgressbar();
                //2.提示用户登录失败
                userLoginView.showLoginError();
            }
        });

    }

    private Handler mHandler = new Handler();
}
