package com.itheima.mvpdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

    private EditText etUsername;
    private EditText etPassword;
    private ProgressBar progressBar;
    private Context context;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        context = this;
        initViews();
        btnLogin.setOnClickListener(this);
    }

    private void initViews() {
        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                login();
                break;
        }
    }

    /**
     * 登录
     */
    private void login() {
        showProgressBar();
        //模拟网络耗时操作
        new Thread() {
            public void run() {
                SystemClock.sleep(1500);
                String username = getUsername();
                String password = getPassword();
                if ("heima".equals(username) && "123456".equals(password)) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            makeToast("登录成功，跳转到主页");
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            makeToast("登录失败");
                        }
                    });
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        hideProgressBar();
                    }
                });
            }

        }.start();
    }

    /**
     * 显示滚动条
     */
    private void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    /**
     * 隐藏滚动条
     */
    private void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    /**
     * 获取密码
     */
    private String getPassword() {
        return etPassword.getText().toString();
    }

    /**
     * 获取用户名
     */
    private String getUsername() {
        return etUsername.getText().toString();
    }

    private void makeToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
