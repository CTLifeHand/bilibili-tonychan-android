package com.bilibili.tonychan.utils;

import android.preference.PreferenceManager;

import com.bilibili.tonychan.BilibiliApp;

/**
 * Created by CYT on 2018/2/26.
 */

public class PreferenceUtil {

    public static boolean getBoolean(String key, boolean defValue) {
        return PreferenceManager.getDefaultSharedPreferences(BilibiliApp.getInstance()).getBoolean(key, defValue);
    }
}
