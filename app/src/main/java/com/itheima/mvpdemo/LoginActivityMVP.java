package com.itheima.mvpdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.itheima.mvpdemo.model.User;
import com.itheima.mvpdemo.presenter.UserLoginPresenter;
import com.itheima.mvpdemo.view.IUserLoginView;

public class LoginActivityMVP extends Activity implements OnClickListener,IUserLoginView{

    private EditText etUsername;
    private EditText etPassword;
    private ProgressBar progressBar;
    private Context context;
    private Button btnLogin;
    private UserLoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_mvp);
        context = this;
        initViews();
        btnLogin.setOnClickListener(this);
    }

    private void initViews() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        presenter = new UserLoginPresenter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                presenter.login();
                break;
        }
    }


    @Override
    public String getUsername() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void jump2Main(User user) {
        Toast.makeText(LoginActivityMVP.this, "登录成功，跳转主页~~~", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginError() {
        Toast.makeText(LoginActivityMVP.this, "用户名或者密码错误，登录失败~~~", Toast.LENGTH_SHORT).show();
    }
}
