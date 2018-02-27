package com.bilibili.tonychan.module;

import android.content.Intent;
import android.os.Bundle;

import com.bilibili.tonychan.bilibili_tonychan_android.R;
import com.bilibili.tonychan.utils.ConstantUtil;
import com.bilibili.tonychan.utils.PreferenceUtil;
import com.trello.rxlifecycle2.components.RxActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;


/*  使用了butterknife和rx */

public class SplashActivity extends RxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setUpSplash();
    }


    private void setUpSplash() {
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> finishTask());
    }



    private void finishTask() {
        boolean isLogin = PreferenceUtil.getBoolean(ConstantUtil.KEY, false);
        if (isLogin) {
//            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        } else {
//            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }
        SplashActivity.this.finish();
    }



}
