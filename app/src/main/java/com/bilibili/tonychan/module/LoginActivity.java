package com.bilibili.tonychan.module;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bilibili.tonychan.base.RxBaseActivity;

import com.bilibili.tonychan.bilibili_tonychan_android.R;

import butterknife.BindView;

/**
 * Created by CYT on 2018/2/26.
 */

class LoginActivity extends RxBaseActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.iv_icon_left)
    ImageView mLeftLogo;
    @BindView(R.id.iv_icon_right)
    ImageView mRightLogo;
    @BindView(R.id.delete_username)
    ImageView mDeleteUserName;
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_password)
    EditText et_password;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void initViews(Bundle savedInstanceState) {
        et_username.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && et_username.getText().length() > 0) {
                mDeleteUserName.setVisibility(View.VISIBLE);
            } else {
                mDeleteUserName.setVisibility(View.GONE);
            }
            mLeftLogo.setImageResource(R.drawable.ic_22);
            mRightLogo.setImageResource(R.drawable.ic_33);
        });
        et_password.setOnFocusChangeListener((v, hasFocus) -> {
            mLeftLogo.setImageResource(R.drawable.ic_22_hide);
            mRightLogo.setImageResource(R.drawable.ic_33_hide);
        });
        et_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 如果用户名清空了 清空密码 清空记住密码选项
                et_password.setText("");
                if (s.length() > 0) {
                    // 如果用户名有内容时候 显示删除按钮
                    mDeleteUserName.setVisibility(View.VISIBLE);
                } else {
                    // 如果用户名有内容时候 显示删除按钮
                    mDeleteUserName.setVisibility(View.GONE);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void initToolBar() {
        mToolbar.setNavigationIcon(R.drawable.ic_cancle);
        mToolbar.setTitle("登录");
        mToolbar.setNavigationOnClickListener(v -> finish());
    }
}
